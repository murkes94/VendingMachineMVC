package com.vendingmachine.controller;

import com.vendingmachine.entity.SnackProduct;
import com.vendingmachine.entity.constants.CoffeeProductConstants;
import com.vendingmachine.entity.constants.ErrorEntityType;
import com.vendingmachine.entity.constants.SnackProductConstants;
import com.vendingmachine.model.action.ActionJsonResponse;
import com.vendingmachine.payment.Payment;
import com.vendingmachine.sensors.MotorSensor;
import com.vendingmachine.service.ErrorEntityService;
import com.vendingmachine.service.SaleService;
import com.vendingmachine.service.SnackProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Optional;

@Controller
public class MainController {


    @Autowired
    private SnackProductService snackProductService;

    @Autowired
    private ErrorEntityService errorEntityService;

    @Autowired
    private SaleService saleService;

    @Autowired
    MessageSource messageSource;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String mainView(ModelMap model) {
        model.addAttribute("snackProducts", snackProductService.getAll());
        return "main";
    }

    @RequestMapping(value = "/buy-product", method = RequestMethod.POST)
    @ResponseBody
    public ActionJsonResponse buyProduct(Locale locale, @RequestParam(value = "productId")String productId,
                                         @RequestParam(value = "token")long token) {

        if (CoffeeProductConstants.ID_LIST.contains(productId)) {

            //TODO buy coffee

        } else if (SnackProductConstants.ID_LIST.contains(productId)) {

            String paymentResponse = Payment.checkNewPayment(token, productId);
            if (!Payment.RESPONSE_OK.equals(paymentResponse)) {
                ActionJsonResponse actionJsonResponse = new ActionJsonResponse(
                        messageSource.getMessage(paymentResponse, null, locale), false);
                return actionJsonResponse;
            }

            Optional<SnackProduct> optionalSnackProduct = snackProductService.getById(productId);
            if (!optionalSnackProduct.isPresent()) {
                //TODO Logger error
                ActionJsonResponse actionJsonResponse = new ActionJsonResponse(
                        messageSource.getMessage("unexpected_error", null, locale),
                        false);
                return actionJsonResponse;
            }
            SnackProduct snackProduct = optionalSnackProduct.get();
            boolean isAvailableQuantity = (snackProduct.getAvailableQuantity() > 0);

            if (!isAvailableQuantity) {
                Payment.cancelNewPayment(token, productId);

                ActionJsonResponse actionJsonResponse = new ActionJsonResponse(
                        messageSource.getMessage("snack_product_is_out_of_stock", new Object[]{productId}, locale),
                        false);
                //add new _OUT_OF_STOCK error with specific product id
                errorEntityService.addNewError(ErrorEntityType.outOfStockType(productId), LocalDateTime.now());
                return actionJsonResponse;
            }

            boolean isMotorWorking = MotorSensor.isMotorOk(productId);

            if (!isMotorWorking) {
                Payment.cancelNewPayment(token, productId);

                ActionJsonResponse actionJsonResponse = new ActionJsonResponse(
                        messageSource.getMessage("motor_is_not_working", null, locale),
                        false);

                errorEntityService.addNewError(ErrorEntityType.MOTOR_ERROR, LocalDateTime.now());
                return actionJsonResponse;
            }

            LocalDateTime date = LocalDateTime.now();
            saleService.addNewSale(productId, snackProduct.getPrice(), date);

            ActionJsonResponse actionJsonResponse = new ActionJsonResponse(
                    messageSource.getMessage("product_sale_success", new Object[]{snackProduct.getName()}, locale),
                    true);
            return actionJsonResponse;
        }

        ActionJsonResponse actionJsonResponse = new ActionJsonResponse(
                messageSource.getMessage("unexpected_error", null, locale),
                false);
        return actionJsonResponse;

    }
}