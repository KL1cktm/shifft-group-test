package by.shift.notification.notification.sender;

import by.shift.notification.notification.NotificationType;
import by.shift.notification.notification.message.TelegramMessage;
import by.shift.notification.response.Response;

public class TelegramSender implements NotificationSender<TelegramMessage> {

    private final NotificationType notificationType = NotificationType.TELEGRAM;

    @Override
    public Response sendNotification(TelegramMessage message) {
        System.out.println(message);
        return new Response(message, "200");
    }

    @Override
    public NotificationType getNotificationType() {
        return notificationType;
    }
}
