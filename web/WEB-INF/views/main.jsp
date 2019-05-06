<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<html>

    <head>
        <link rel="stylesheet" type="text/css" href="/webjars/bootstrap/css/bootstrap.min.css"/>
        <link rel="stylesheet" type="text/css" href="/webjars/font-awesome/css/all.css"/>
        <link rel="stylesheet" type="text/css" href="/assets/css/main.css"/>

        <script type="text/javascript" src="/webjars/jquery/jquery.min.js"></script>
        <script type="text/javascript" src="/webjars/jquery-i18n-properties/jquery.i18n.properties.js"></script>
        <script type="text/javascript" src="/webjars/bootstrap/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="/webjars/sockjs-client/sockjs.min.js"></script>
        <script type="text/javascript" src="/webjars/stomp-websocket/stomp.min.js"></script>

        <script type="text/javascript" src="/assets/js/main.js"></script>

        <meta name="_csrf" content="${_csrf.token}"/>
        <meta name="_csrf_header" content="${_csrf.headerName}"/>

        <script type="text/javascript">
            $(function() {
                jQuery.i18n.properties({
                    name: "language",
                    path: "/locale/",
                    mode: "both",
                    language: "${pageContext.response.locale}"
                });
            });
        </script>

        <title><spring:message code="main_title"/></title>

    </head>

<body>
    <header>
        <p class="greeting"><spring:message code="greeting_vending"/></p>
        <form action="<c:url value="/admin" />" method="POST">
            <button type="submit" class="btn btn-primary admin-login">
                <spring:message code="admin"/>
            </button>
        </form>
        <div class="websocket-status">
            <i class="fas fa-wifi"></i>
        </div>
        <div class="water-temp">
            <p><spring:message code="water"/></p>
            <p class="temp-value"><spring:message code="loading"/></p>
            <p>&deg;C</p>
        </div>
        <div class="freezer-temp">
            <p><spring:message code="fridge"/></p>
            <p class="temp-value"><spring:message code="loading"/></p>
            <p>&deg;C</p>
        </div>
    </header>

    <div class="row snack-products">
        <c:forEach var="snackProduct" items="${snackProducts}">
            <div class="col-xl-3 product">
                <p class="product-name"><c:out value="${snackProduct.name}"/></p>
                <input type="hidden" name="product-id" value="${snackProduct.id}"/>
                <input type="hidden" name="available-quantity" value="${snackProduct.availableQuantity}"/>
                <c:choose>
                    <c:when test="${snackProduct.availableQuantity > 0}">
                        <button type="button" class="btn btn-outline-success buy-product">
                            <fmt:formatNumber value="${snackProduct.price}" type="currency" currencySymbol="$"/>
                            &nbsp
                            <spring:message code="buy_product"/>
                        </button>
                    </c:when>
                    <c:otherwise>
                        <button type="button" class="btn btn-danger out-of-stock">
                            <fmt:formatNumber value="${snackProduct.price}" type="currency" currencySymbol="$"/>
                            &nbsp
                            <spring:message code="out_of_stock"/>
                        </button>
                    </c:otherwise>
                </c:choose>

            </div>

        </c:forEach>
    </div>

    <!-- Payment modal -->
    <div class="modal fade" id="buy-product-modal" tabindex="-1" role="dialog" aria-hidden="true">

        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">

                    </h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <spring:message code="commit_payment"/>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">
                        <spring:message code="cancel"/>
                    </button>
                    <button type="button" class="btn btn-primary pay">
                        <spring:message code="buy_product"/>
                    </button>
                </div>
            </div>
        </div>
    </div>

    <footer></footer>
</body>


</html>
