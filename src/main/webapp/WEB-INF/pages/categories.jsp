<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <title>форумы</title>
</head>
<<<<<<< HEAD
<body bgcolor="#e8e8e8" link="#222222" alink="#222222" vlink="#222222" >


    <c:if test="${not empty msg}">
	    <div class="msg">${msg}</div>
	</c:if>


    <c:url value="/logout" var="logoutUrl" />
	<form action="${logoutUrl}" method="post" id="logoutForm">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>

	<form action="/login" id="loginForm"></form>

    <c:if test="${pageContext.request.userPrincipal.name == null}">
		<h2>
			<button type="submit" form="loginForm">ВХОД</button>
		</h2>
	</c:if>

	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<h2>
			Вы зашли как: : ${pageContext.request.userPrincipal.name} | <button onclick="document.getElementById('logoutForm').submit();">ВЫХОД</button>
		</h2>
	</c:if>
    <center>
        <div style="color: teal; font-size: 30px">Категории</div>
        <font face="Comic Sans MS" size="3">
            <c:if test="${!empty listCategories}">
                <c:forEach items="${listCategories}" var="categor">
       		        <a href="posts?id=${categor.id}">"${categor.title}"</a><br>
       		        <font size="-1">"${categor.description}"</font><br><br>
                </c:forEach>
            </c:if>
        </font>
    </center>
=======
<body bgcolor="#e8e8e8" >
<font face="Monotype Corsiva" size="6"color="#ff0000">Форумы:</font><br>
<font face="Comic Sans MS" size="3">
       <c:if test="${!empty listCategories}">
           <c:forEach items="${listCategories}" var="categor">
       		<a href="posts?id=${categor.id}">"${categor.title}"</a><br>
       		<font size="-1">"${categor.description}"</font><br><br>
           </c:forEach>
       </c:if>
</font>
>>>>>>> 99ef70e01dc335e6bee1190972dd01ceacaf92d0
</body>
</html>