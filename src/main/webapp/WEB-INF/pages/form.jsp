<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Your name</title>
</head>
<body>
 <center>

  <div style="color: teal; font-size: 30px">Your name</div>



  <c:url var="userRegistration" value="saveUser.html" />
  <form:form id="registerForm" modelAttribute="user" method="post"
   action="register">
   <table width="400px" height="150px">
    <tr>
     <td><form:label path="username">username</form:label>
     </td>
     <td><form:input path="username" />
     </td>
    </tr>
    <tr>
     <td><form:label path="password">password</form:label>
     </td>
     <td><form:input path="password" />
     </td>
    </tr>
    <tr>
     <td></td>
     <td><input type="submit" value="Register" /></td>
    </tr>
   </table>
  </form:form>


  <a href="list">see User List</a><br>
  <a href="login">вход</a>
 </center>
</body>
</html>