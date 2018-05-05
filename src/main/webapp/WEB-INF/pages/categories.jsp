<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <title>форумы</title>
</head>
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
</body>
</html>