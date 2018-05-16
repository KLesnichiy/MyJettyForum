<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body bgcolor="#e8e8e8">
	<h1>HTTP Status 403 - Access is denied</h1>

	<c:choose>
		<c:when test="${empty username}">
			<h2>у вас нет прав доступа к этой странице!</h2>
		</c:when>
		<c:otherwise>
			<h2>Username : ${username} <br/>у вас нет прав доступа к этой странице!</h2>
		</c:otherwise>
	</c:choose>

</body>
</html>