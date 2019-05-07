package com.vendingmachine.controller;

import com.vendingmachine.entity.SnackProduct;
import com.vendingmachine.entity.TemperatureSettings;
import com.vendingmachine.model.action.ActionJsonResponse;
import com.vendingmachine.service.ErrorEntityService;
import com.vendingmachine.service.SnackProductService;
import com.vendingmachine.service.TemperatureSettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.EntityNotFoundException;
import java.util.Locale;

@Controller
public class AdminController {

    @Autowired
    private SnackProductService snackProductService;

    @Autowired
    private TemperatureSettingsService temperatureSettingsService;

    @Autowired
    private ErrorEntityService errorEntityService;

    @Autowired
    MessageSource messageSource;

    @RequestMapping(value = "/admin", method = RequestMethod.POST)
    public String adminView(ModelMap model) {
        //TODO login. spring security. password, etc.

        model.addAttribute("temperatureSettings", temperatureSettingsService.getAll());
        model.addAttribute("snackProducts", snackProductService.getAll());
        return "/admin/settings";
    }

    @RequestMapping(value = "/admin/sales", method = RequestMethod.POST)
    public String salesView(ModelMap model) {
        //TODO add render sales
        return "/admin/sales";
    }

    @RequestMapping(value = "/admin/errors", method = RequestMethod.POST)
    public String ErrorsView(ModelMap model) {
        model.addAttribute("errors", errorEntityService.getAll());
        return "/admin/errors";
    }

    @RequestMapping(value = "/update-temperature-settings", method = RequestMethod.POST)
    @ResponseBody
    public ActionJsonResponse updateTemperatureSettings(Locale locale, TemperatureSettings temperatureSettings) {
        //TODO check correctness of data(temperature settings fields)
        temperatureSettingsService.editTemperatureSettings(temperatureSettings);
        return new ActionJsonResponse(
                messageSource.getMessage("temperature_settings_edited_successfully", null, locale),
                true);
    }

    @RequestMapping(value = "/update-snack-product", method = RequestMethod.POST)
    @ResponseBody
    public ActionJsonResponse updateSnackProduct(Locale locale, SnackProduct snackProduct) {
        //TODO check correctness of data(snack product fields)
        snackProductService.editSnackProduct(snackProduct);
        return new ActionJsonResponse(
                messageSource.getMessage("product_edited_successfully", new Object[]{snackProduct.getId()}, locale),
                true);
    }

    @RequestMapping(value = "/update-coffee-product", method = RequestMethod.POST)
    @ResponseBody
    public ActionJsonResponse updateCoffeeProduct(@RequestParam(value = "coffeeProductId")String coffeeProductId) {
        //TODO update coffee product

        return new ActionJsonResponse("", false);
    }

    @RequestMapping(value = "/error-mark-as-solved", method = RequestMethod.POST)
    @ResponseBody
    public ActionJsonResponse errorMarkAsSolved(Locale locale, @RequestParam(value = "errorId")long errorId) {
        try {
            errorEntityService.markAsSolved(errorId);
        } catch(EntityNotFoundException e) {
            //TODO log exception to logger.
            return new ActionJsonResponse(
                    messageSource.getMessage("unexpected_error", null, locale),
                    false);
        }
        return new ActionJsonResponse(
                messageSource.getMessage("error_marked_as_solved_successfully", null, locale),
                true);
    }

}
