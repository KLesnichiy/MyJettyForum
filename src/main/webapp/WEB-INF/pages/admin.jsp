<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<body bgcolor="#e8e8e8">
=======
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<body>
>>>>>>> 99ef70e01dc335e6bee1190972dd01ceacaf92d0
	<h1>Title : ${title}</h1>
	<h1>Message : ${message}</h1>

	<c:url value="/logout" var="logoutUrl" />
	<form action="${logoutUrl}" method="post" id="logoutForm">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
<<<<<<< HEAD

	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<h2>
			Вы зашли как: : ${pageContext.request.userPrincipal.name} | <button onclick="document.getElementById('logoutForm').submit();">ВЫХОД</button>
=======
	<script>
		function formSubmit() {
			document.getElementById("logoutForm").submit();
		}
	</script>

	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<h2>
			Welcome : ${pageContext.request.userPrincipal.name} | <a
				href="javascript:formSubmit()"> Logout</a>
>>>>>>> 99ef70e01dc335e6bee1190972dd01ceacaf92d0
		</h2>
	</c:if>

</body>
</html>