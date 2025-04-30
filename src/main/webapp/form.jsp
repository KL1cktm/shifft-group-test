<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Форма для заполнения</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            max-width: 500px;
            margin: 0 auto;
            padding: 20px;
        }
        .form-group {
            margin-bottom: 15px;
        }
        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }
        input, textarea, select {
            width: 100%;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        button {
            background-color: #4CAF50;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<h1>Анкета пользователя</h1>
<form action="/form" method="POST">
    <div class="form-group">
        <label for="name">Имя:</label>
        <input type="text" id="name" name="name" required>
    </div>

    <div class="form-group">
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required>
    </div>

    <div class="form-group">
        <label for="phone">Телефон:</label>
        <input type="tel" id="phone" name="phone" placeholder="+7 (XXX) XXX-XX-XX">
    </div>

    <div class="form-group">
        <label for="gender">Пол:</label>
        <select id="gender" name="gender">
            <option value="male">Мужской</option>
            <option value="female">Женский</option>
            <option value="other">Другой</option>
        </select>
    </div>

    <div class="form-group">
        <label for="message">Сообщение:</label>
        <textarea id="message" name="message" rows="4"></textarea>
    </div>

    <div class="form-group">
        <label>
            <input type="checkbox" name="subscribe" checked>
            Подписаться на рассылку
        </label>
    </div>

    <button type="submit">Отправить</button>
</form>
</body>
</html>