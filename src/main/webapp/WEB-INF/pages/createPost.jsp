<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Your name</title>
</head>
<body bgcolor="#e8e8e8">
    <center>
        <div style="color: teal; font-size: 30px">Создать новую тему</div>

        <form:form id="createForm" modelAttribute="posts" method="post"
        action="createPost?id_cat=${categoria}">

            <form:input type="hidden" path="user.username"
   			value="${pageContext.request.userPrincipal.name}" />

            <table width="800px" height="600px">
                <tr>
                    <td><form:label path="title">Заголовок</form:label></td>
                    <td><form:input path="title" /></td>
                </tr>
                <tr>
                    <td><form:label path="text">Сообщение</form:label></td>
                    <td>
                        <form:textarea path="text" rows="20" cols="60" />
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Отправить" /></td>
                </tr>
            </table>
        </form:form>
        <a href="posts?id=${categoria}">назад</a>
    </center>
</body>
</html>