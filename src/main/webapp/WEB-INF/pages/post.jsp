<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><c:out value="${post.title}" /></title>
</head>
<body>
 <center>

  <div style="color: teal; font-size: 30px"><c:out value="${post.title}" /></div>
   <br>
    <p align="center"><c:out value="${post.text}" /></p>

 </center>
</body>
</html>