package by.shift.notification.notification.sender;

import by.shift.notification.notification.NotificationType;
import by.shift.notification.notification.message.TelegramMessage;

public class TelegramSender implements NotificationSender<TelegramMessage> {

    private final NotificationType notificationType = NotificationType.TELEGRAM;

    @Override
    public void sendNotification(TelegramMessage message) {
        System.out.println(message);
    }

    @Override
    public NotificationType getNotificationType() {
        return notificationType;
    }
}
