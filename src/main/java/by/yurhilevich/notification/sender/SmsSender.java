package by.yurhilevich.notification.sender;

import by.yurhilevich.notification.NotificationType;
import by.yurhilevich.notification.message.SmsMessage;

public class SmsSender implements NotificationSender <SmsMessage> {

    private final NotificationType notificationType = NotificationType.SMS;

    @Override
    public void sendNotification(SmsMessage message) {
        System.out.println(message);
    }

    @Override
    public NotificationType getNotificationType() {
        return notificationType;
    }
}
