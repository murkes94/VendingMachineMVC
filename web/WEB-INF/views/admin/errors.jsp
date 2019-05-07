<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<html>

<head>
    <jsp:include page="/WEB-INF/views/admin/header.jsp"></jsp:include>
    <script type="text/javascript" src="/assets/js/admin/errors.js"></script>
</head>

<body>
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
                        <c:if test="${error.solved == false}">
                            <button class="btn btn-primary mark-as-solved">
                                <spring:message code="mark_as_solved"/>
                            </button>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <footer></footer>
</body>

</html>