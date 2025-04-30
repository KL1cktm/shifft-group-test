<%--
  Created by IntelliJ IDEA.
  User: bross
  Date: 30.04.2025
  Time: 20:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Регистрация</title>
</head>
<body>
<form action="login" method="POST">
    <div class="form-group">
        <label for="name">Введите имя:</label>
        <textarea id="name" name="name" rows="1"></textarea>
    </div>
    <button type="submit">Отправить</button>
</form>
</body>
</html>
