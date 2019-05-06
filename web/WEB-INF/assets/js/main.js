$(document).ready(function() {

    var temperatureLoading = $(".water-temp .temp-value").text();

    var socket = new SockJS("/websocket");
    var stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {

            $(".websocket-status .fa-wifi").css("color", "#20f720");
            stompClient.subscribe("/water-temp", function (response) {
                //set water temp received from server
                $(".water-temp .temp-value").text(response.body);
            });
            stompClient.subscribe("/freezer-temp", function (response) {
                //set freezer temp received from server
                $(".freezer-temp .temp-value").text(response.body);
            });
        }, function(error) {
            $(".websocket-status .fa-wifi").css("color", "red");
            $(".water-temp .temp-value").text(temperatureLoading);
            $(".freezer-temp .temp-value").text(temperatureLoading);

            //TODO try reconnect. Open connection when possible.
    });

    $(".buy-product").click(function () {

        var token = 0;//TODO spring security $("meta[name="_csrf"]").attr("content");
        var productId = $(this).parent().children("input[name=product-id]").val();
        var availableQuantityInput = $(this).parent().children("input[name=available-quantity]");
        var availableQuantity = availableQuantityInput.val();
        var name = $(this).parent().children(".product-name").text();

        $("#buy-product-modal .btn.pay").unbind("click");
        $("#buy-product-modal .btn.pay").click(function() {

            //some payment logic ... Check status, transaction, etc
            //send product request
            $.ajax({
                type: "POST",
                data: {
                    productId: productId,
                    token: token
                    //TODO add spring-security, csrf
                },
                url: "/buy-product",
                success: function (responseData) {
                    if (!responseData.success) {
                        //TODO change alert() to bootstrap alert-success and alert-error
                        alert(responseData.message);
                        return;
                    }
                    availableQuantityInput.val(availableQuantity--);
                    //TODO change alert() to bootstrap alert-success and alert-error
                    alert(responseData.message);
                },
                error: function () {
                    //TODO change alert() to bootstrap alert-success and alert-error
                    alert(jQuery.i18n.prop("unexpected_error"));
                }
            });
            $("#buy-product-modal").modal("hide");
        });

        $("#buy-product-modal .modal-title").text(name + $(this).text());
        $("#buy-product-modal").modal("show");

    });

});

