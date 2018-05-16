<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<<<<<<< HEAD
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><c:out value="${post.title}" /></title>
    </head>
    <body bgcolor="#e8e8e8">

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
            <table width="640" height="200" cellpadding="15" cellspacing="2" border="1">
                <tr height="30%">
                    <td>
                        <div style="color: teal; font-size: 30px"><c:out value="${post.title}" /></div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <p align="center">${post.text}</p>
                    </td>
                </tr>
            </table>


        <c:if test="${!empty comentsList}">
                <table width="640" cellpadding="15" cellspacing="2" border="1">
                    <c:forEach items="${comentsList}" var="cList">
                    <tr style="background-color: white; color: black; text-align: center;" height="30px">
                        <td>
                            <c:out value="${cList.user.username}" />
                         </td>
                         <td>
                            <c:out value="${cList.created}" />
                            <hr>
                            <c:out value="${cList.text}" />
                         </td>
                    </tr>
                    </c:forEach>
               </table>
            </c:if>






        <form:form id="createForm" modelAttribute="coments" method="post" action="postAndComents?id_post=${post.id}">
                  <table width="640px" height="380px" cellpadding="15" cellspacing="4" border="1" rules="none">
                   <sec:authorize access="hasRole('ROLE_USER')">
                   <form:input type="hidden" path="user.username"
                      			value="${pageContext.request.userPrincipal.name}" />
                   <tr>
                       <td valign="top">
                           <form:label path="text">Оставить сообщение:</form:label>
                       </td>
                       <td>
                           <form:textarea path="text" rows="20" cols="60" placeholder="Оставить коментарий..." />
                           <input type="submit" value="Отправить" />
                       </td>
                   </tr>
                   </sec:authorize>

                   <c:if test="${pageContext.request.userPrincipal.name == null}">
                       <tr>
                           <td>
                               Оставить сообщение:
                           </td>
                           <td>
                              <button type="submit" form="loginForm">Войдите</button>
                           </td>
                       </tr>
                   </c:if>

                  </table>
        </form:form>


      <<  <a href="posts?id=${post.categories.id}"> перейти назад</a><br>
     </center>





    </body>
=======
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
>>>>>>> 99ef70e01dc335e6bee1190972dd01ceacaf92d0
</html>