<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Your name</title>
</head>
<body bgcolor="#e8e8e8">
    <center>

    <div style="color: teal; font-size: 30px">РЕГИСТРАЦИЯ</div>



    <c:url var="userRegistration" value="saveUser.html" />
    <form:form id="registerForm" modelAttribute="user" method="post"
    action="register">
        <table width="400px" height="300px"  border="1" rules="none">
            <tr>
                <td><form:label path="username">ИМЯ ПОЛЬЗОВАТЕЛЯ:</form:label>
                </td>
                <td><form:input path="username" />
                </td>
            </tr>
            <tr>
                <td><form:label path="password">ПАРОЛЬ:</form:label>
                </td>
                <td><form:input path="password" />
                </td>
            </tr>
            <tr>
                <td><form:label path="mail">Введите адрес электронной почты:</form:label>
                </td>
                <td><form:input path="mail" />
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="gender"> Пожалуйста укажите ваш пол. </form:label>
                </td>
                    <td>
                        <form:select path="gender" >
                            <option value="man">мужской</option>
                            <option value="woman">женский</option>
                        </form:select>
                    </td>
            </tr>

            <tr>
                <form action="register">
                <td>
                    <label for="date">Пожалуйста, введите дату Вашего рождения:</label>
                </td>
                <td>
                    <input type="date" id="date" name="date" min="1950-01-01" max="2018-01-01">
                </td>
                </form>
            </tr>


            <tr>
                <td colspan =2><center><input type="submit" value="СОЗДАТЬ УЧЕТНУЮ ЗАПИСЬ" /></center></td>
            </tr>
            <tr>

                <td colspan =2>
                    <sec:authorize access="hasRole('ADMIN')">
                        <center><a href="list">СПИСОК ПОЛЬЗОВОТЕЛЕЙ</a>
                        </center>
                    </sec:authorize>
                </td>

            </tr>

            <tr>
                <td colspan =2><center><a href="login">Уже зарегистрированы? Нажмите чтобы войти!</a></center></td>
            </tr>
        </table>
  </form:form>

   </center>
</body>
</html>