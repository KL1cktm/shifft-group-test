package by.yurhilevich.notification.sender;

import by.yurhilevich.notification.NotificationType;
import by.yurhilevich.notification.message.TelegramMessage;

public class TelegramSender implements NotificationSender <TelegramMessage> {

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
