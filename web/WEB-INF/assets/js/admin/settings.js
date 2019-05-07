$(document).ready(function() {

    //TODO update coffee products

    var tdEditable = $("td.editable");

    tdEditable.click(function() {
        $(this).closest("td").addClass("editable-focus");
    });

    tdEditable.on("focusout", function() {
        $(this).closest("td").removeClass("editable-focus");
    });

    //TODO check correctness of data input

    $(".btn.temperature-settings-update").click(function () {

        var temperatureType = $(this).parent().parent().children("input[name=temperature-type]").val();
        var minTemperature = $(this).parent().parent().children("td.min-temperature").text();
        var maxTemperature = $(this).parent().parent().children("td.max-temperature").text();

        //TODO check correctness of every field
        $.ajax({
            type: "POST",
            data: {
                type: temperatureType,
                minTemperature: minTemperature,
                maxTemperature: maxTemperature
            },
            url: "/update-temperature-settings",
            success: function (responseData) {
                if (!responseData.success) {
                    //TODO change alert() to bootstrap alert-success and alert-error
                    alert(responseData.message);
                    return;
                }
                //TODO change alert() to bootstrap alert-success and alert-error
                alert(responseData.message);
            },
            error: function () {
                //TODO change alert() to bootstrap alert-success and alert-error
                alert(jQuery.i18n.prop("unexpected_error"));
            }
        });
    });

    $(".btn.snack-product-update").click(function () {

        var snackProductId = $(this).parent().parent().children("td.snack-product-id").text();
        var snackProductName = $(this).parent().parent().children("td.snack-product-name").text();
        var snackProductPrice = $(this).parent().parent().children("td.snack-product-price").text();
        var snackProductAvailableQuantity = $(this).parent().parent()
            .children("td.snack-product-available-quantity").text();
        //TODO check correctness of every field
        $.ajax({
            type: "POST",
            data: {
                id: snackProductId,
                name: snackProductName,
                price: snackProductPrice,
                availableQuantity: snackProductAvailableQuantity
            },
            url: "/update-snack-product",
            success: function (responseData) {
                if (!responseData.success) {
                    //TODO change alert() to bootstrap alert-success and alert-error
                    alert(responseData.message);
                    return;
                }
                //TODO change alert() to bootstrap alert-success and alert-error
                alert(responseData.message);
            },
            error: function () {
                //TODO change alert() to bootstrap alert-success and alert-error
                alert(jQuery.i18n.prop("unexpected_error"));
            }
        });
    });

});