<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<<<<<<< HEAD
<body bgcolor="#e8e8e8">
=======
<body>
>>>>>>> 99ef70e01dc335e6bee1190972dd01ceacaf92d0
	<h1>HTTP Status 403 - Access is denied</h1>

	<c:choose>
		<c:when test="${empty username}">
<<<<<<< HEAD
			<h2>у вас нет прав доступа к этой странице!</h2>
		</c:when>
		<c:otherwise>
			<h2>Username : ${username} <br/>у вас нет прав доступа к этой странице!</h2>
=======
			<h2>You do not have permission to access this page!</h2>
		</c:when>
		<c:otherwise>
			<h2>Username : ${username} <br/>You do not have permission to access this page!</h2>
>>>>>>> 99ef70e01dc335e6bee1190972dd01ceacaf92d0
		</c:otherwise>
	</c:choose>

</body>
</html>