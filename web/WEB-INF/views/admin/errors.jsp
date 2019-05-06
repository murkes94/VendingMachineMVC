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

    <script type="text/javascript" src="/assets/js/admin/errors.js"></script>

    <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>

    <title><spring:message code="main_title"/></title>
</head>

<body>
    <jsp:include page="/WEB-INF/views/admin/header.jsp"></jsp:include>

    <div class="error-log">
        <h2><spring:message code="error_log"/></h2>

        <table class="table table-striped">
            <thead>
            <tr>
                <th><spring:message code="type"/></th>
                <th><spring:message code="date"/></th>
                <th><spring:message code="status"/></th>
                <th><spring:message code="action"/></th>
            </tr>
            </thead>
            <c:forEach var="error" items="${errors}">
                <tr>
                    <td><spring:message code="${error.type}"/></td>
                    <td>${error.date}</td>
                    <td>
                        <c:choose>
                            <c:when test="${error.solved == true}">
                                <spring:message code="solved"/>
                            </c:when>
                            <c:otherwise>
                                <spring:message code="unsolved"/>
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>
                        <input type="hidden" name="error-id" value="${error.id}"/>
                        <button class="btn btn-primary mark-as-solved">
                            <spring:message code="mark_as_solved"/>
                        </button>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <footer></footer>
</body>

</html>