package by.shift.notification.response;

import by.shift.notification.notification.message.Message;

public record Response(
        Message message,
        String statusCode
) {
}
