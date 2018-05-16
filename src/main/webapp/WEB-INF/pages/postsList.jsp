<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<<<<<<< HEAD
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
=======
>>>>>>> 99ef70e01dc335e6bee1190972dd01ceacaf92d0
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Users</title>
</head>
<<<<<<< HEAD
<body link="#222222" alink="#222222" vlink="#222222" bgcolor="#e8e8e8" >


  <c:url value="/logout" var="logoutUrl" />
 	<form action="${logoutUrl}" method="post" id="logoutForm">
 		<input type="hidden" name="${_csrf.parameterName}"
 			value="${_csrf.token}" />
 	</form>

 	<form action="/login" id="loginForm">
     </form>

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
=======
<body>
 <center>
>>>>>>> 99ef70e01dc335e6bee1190972dd01ceacaf92d0

  <div style="color: teal; font-size: 30px">Форумы</div>

  <c:if test="${!empty postObject}">
   <table border="1" bgcolor="black" width="600px">
<<<<<<< HEAD
    <tr style="background-color: white; color: black; text-align: center;"
              height="40px">

        <td>
            Автор
        </td>
        <td>
            Тема
        </td>
        <td>
            Коментариев
        </td>
        <td>
            Создан
        </td>

    </tr>

    <c:forEach items="${postObject}" var="posts">
     <tr style="background-color: white; color: black; text-align: center;"
      height="40px">
       <td>
                   ${posts.user.getUsername()}
              </td>
              <td>
            <a href="postAndComents?id_post=${posts.id}">${posts.title}</a><br>
       </td>
       <td>
            ${posts.coments.size()}
       </td>
       <td>
            ${posts.created}
       </td>
=======
    <c:forEach items="${postObject}" var="posts">
     <tr
      style="background-color: white; color: black; text-align: center;"
      height="30px">
       <td>
       <a href="post?id=${posts.id}">${posts.title}</a><br>
      </td>
>>>>>>> 99ef70e01dc335e6bee1190972dd01ceacaf92d0
     </tr>
    </c:forEach>
   </table>
  </c:if>

<<<<<<< HEAD
  <sec:authorize access="hasRole('ROLE_USER')">
    <a href="create?id=${id_cat}">создать новую тему</a>
    </br>
  </sec:authorize>
   <c:if test="${pageContext.request.userPrincipal.name == null}">
   		<h2>
   			Чтобы создать тему войдите под своим именем
   		</h2>
   </c:if>

  <a href="categories">назад</a>
=======

  <a href="create">создать новую тему</a>
>>>>>>> 99ef70e01dc335e6bee1190972dd01ceacaf92d0
 </center>
</body>
</html>