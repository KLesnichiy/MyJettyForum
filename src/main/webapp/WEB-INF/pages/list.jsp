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

  <div style="color: teal; font-size: 30px">Пользователи
List</div>

  <c:if test="${!empty userList}">
   <table border="1" bgcolor="black" width="600px">
    <tr
     style="background-color: teal; color: white; text-align: center;"
     height="40px">

     <td>User Name</td>
     <td>Password</td>

    </tr>
    <c:forEach items="${userList}" var="user">
     <tr
      style="background-color: white; color: black; text-align: center;"
      height="30px">

      <td><c:out value="${user.username}" />
      </td>
      <td><c:out value="${user.password}" />
      </td>

     </tr>
    </c:forEach>
   </table>
  </c:if>


  <a href="form">добавить нового Пользователя</a>
 </center>
</body>
</html>