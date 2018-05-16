<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<body bgcolor="#e8e8e8">
	<h1>Title : ${title}</h1>
	<h1>Message : ${message}</h1>

	<c:url value="/logout" var="logoutUrl" />
	<form action="${logoutUrl}" method="post" id="logoutForm">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>

	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<h2>
			Вы зашли как: : ${pageContext.request.userPrincipal.name} | <button onclick="document.getElementById('logoutForm').submit();">ВЫХОД</button>
		</h2>
	</c:if>

</body>
</html>