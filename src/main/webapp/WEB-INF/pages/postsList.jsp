<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Users</title>
</head>
<body>
 <center>

  <div style="color: teal; font-size: 30px">Форумы</div>

  <c:if test="${!empty postObject}">
   <table border="1" bgcolor="black" width="600px">
    <c:forEach items="${postObject}" var="posts">
     <tr
      style="background-color: white; color: black; text-align: center;"
      height="30px">
       <td>
       <a href="post?id=${posts.id}">${posts.title}</a><br>
      </td>
     </tr>
    </c:forEach>
   </table>
  </c:if>


  <a href="create">создать новую тему</a>
 </center>
</body>
</html>