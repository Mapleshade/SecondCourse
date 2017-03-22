<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1> Калькулятор </h1>

<%--<form action="/calculator" method="post">--%>

    <%--<label for="№1">первое число</label>--%>
    <%--<input name="FirstParam" type="text" id="№1">--%>

    <%--<label for="№2">второе число</label>--%>
    <%--<input name="SecondParam" type="text" id="№2"><br>--%>

    <%--<label for="№3">сложение</label>--%>
    <%--<input name="action" type="radio" value="+" id="№3"><br>--%>

    <%--<label for="№4">вычитание</label>--%>
    <%--<input name="action" type="radio" value="-" id="№4"><br>--%>

    <%--<label for="№5">умножение</label>--%>
    <%--<input name="action" type="radio" value="*" id="№5"><br>--%>

    <%--<label for="№6">деление</label>--%>
    <%--<input name="action" type="radio" value="/" id="№6"><br>--%>

    <%--<button type="submit">Посчитать</button>--%>

<%--</form>--%>



<sf:form action="/calculator" method="post" modelAttribute="command">

    <sf:label path="first">Первый параметр: </sf:label> <sf:input path="first"/> <sf:errors path="first"/> <br>
    <sf:label path="second">Второй параметр: </sf:label> <sf:input path="second"/> <sf:errors path="second"/><br>
    <%--<sf:label path="operand">Действие: </sf:label> <sf:input path="operand"/> <sf:errors path="operand"/><br>--%>
    <sf:radiobutton path="operand" value="+"/>Сложение<br>
    <sf:radiobutton path="operand" value="-"/>Вычитание<br>
    <sf:radiobutton path="operand" value="*"/>Умножение<br>
    <sf:radiobutton path="operand" value="/"/>Деление<br>
    <%--<sf:label path="age">Возвраст: </sf:label> <sf:input path="age"/> <sf:errors path="age"/><br>--%>
    <%--<sf:label path="password">Пароль: </sf:label> <sf:password path="password"/> <sf:errors path="password"/><br>--%>
    <input type="submit">Вычислить</input>


</sf:form>

<br><br>результат предыдущего действия ${result}

</body>
</html>
