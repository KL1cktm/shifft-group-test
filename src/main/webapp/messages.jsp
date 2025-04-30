<%@ page import="by.korona.communicationform.dto.Message" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.stream.Collectors" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Wall</title>
</head>
<body>
<%
    List<Message> messages=(List<Message>) application.getAttribute("messages");
    String messageWall=messages.stream().map((message)->{
        String time=message.creationTime().toString();
        String name=message.name();
        String textMessage=message.message();
        return name+" "+time+" "+textMessage;
    }).collect(Collectors.joining("</p><p>", "<p>", "</p>"));
%>
<h1><%= messageWall %></h1>
<form action="wall" method="POST">
    <div class="form-group">
        <label for="message">Сообщение:</label>
        <textarea id="message" name="message" rows="4"></textarea>
    </div>
    <button type="submit">Отправить</button>
</form>
</body>
</html>
