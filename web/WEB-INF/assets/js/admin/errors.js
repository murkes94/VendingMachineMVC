$(document).ready(function() {

    $(".btn.mark-as-solved").click(function () {

        var errorId = $(this).parent().children("input[name=error-id]").val();

        $.ajax({
            type: "POST",
            data: {
                errorId: errorId
            },
            url: "/error-mark-as-solved",
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