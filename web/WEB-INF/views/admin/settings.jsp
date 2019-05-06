<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<html>

<head>
    <link rel="stylesheet" type="text/css" href="/webjars/bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="/webjars/font-awesome/css/all.css"/>
    <link rel="stylesheet" type="text/css" href="/assets/css/admin/admin.css"/>

    <script type="text/javascript" src="/webjars/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="/webjars/bootstrap/js/bootstrap.min.js"></script>

    <script type="text/javascript" src="/assets/js/admin/settings.js"></script>

    <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>

    <title><spring:message code="main_title"/></title>

</head>

<body>
    <jsp:include page="/WEB-INF/views/admin/header.jsp"></jsp:include>

    <div class="temperature-settings">

        <h2><spring:message code="temperature_settings"/></h2>

        <table class="table table-striped">
            <thead>
            <tr>
                <th><spring:message code="type"/></th>
                <th><spring:message code="min_temperature"/></th>
                <th><spring:message code="max_temperature"/></th>
                <th><spring:message code="action"/></th>
            </tr>
            </thead>
            <c:forEach var="temp" items="${temperatureSettings}">
                <tr>
                    <td><spring:message code="${temp.type}"/></td>
                    <input type="hidden" name="temperature-type" value="${temp.type}"/>
                    <td class="min-temperature">${temp.minTemperature}</td>
                    <td class="max-temperature">${temp.maxTemperature}</td>
                    <td>
                        <button class="btn btn-primary temperature-settings-update">
                            <spring:message code="update"/>
                        </button>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>

    <div class="snack-products">

        <h2><spring:message code="snack_products"/></h2>

        <table class="table table-striped">
            <thead>
            <tr>
                <th><spring:message code="id"/></th>
                <th><spring:message code="name"/></th>
                <th><spring:message code="price"/></th>
                <th><spring:message code="available_quantity"/></th>
                <th><spring:message code="action"/></th>
            </tr>
            </thead>
            <c:forEach var="snackProduct" items="${snackProducts}">
                <tr>
                    <td class="snack-product-id">${snackProduct.id}</td>
                    <td class="snack-product-name">${snackProduct.name}</td>
                    <td class="snack-product-price">${snackProduct.price}</td>
                    <td class="snack-product-available-quantity">${snackProduct.availableQuantity}</td>
                    <td>
                        <button class="btn btn-primary snack-product-update">
                            <spring:message code="update"/>
                        </button>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>

    <footer></footer>
</body>


</html>