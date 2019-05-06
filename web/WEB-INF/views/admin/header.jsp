<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<header>
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
    <p class="greeting"><spring:message code="greeting_vending"/></p>
    <p class="greeting-admin"><spring:message code="admin_panel"/></p>
    <form action="<c:url value="/" />" method="GET">
        <button type="submit" class="btn btn-primary normal-mode">
            <spring:message code="normal_mode"/>
        </button>
    </form>

    <form action="<c:url value="/admin" />" method="POST">
        <button type="submit" class="btn btn-primary admin-login">
            <spring:message code="settings"/>
        </button>
    </form>

    <form action="<c:url value="/admin/sales" />" method="POST">
        <button type="submit" class="btn btn-primary admin-sales">
            <spring:message code="sales"/>
        </button>
    </form>
    <form action="<c:url value="/admin/errors" />" method="POST">
        <button type="submit" class="btn btn-primary admin-errors">
            <spring:message code="error_log"/>
        </button>
    </form>
</header>