package by.shift.notification.notification.sender;

import by.shift.notification.notification.NotificationType;
import by.shift.notification.notification.message.SmsMessage;

//getNotificationType
public class SmsSender implements NotificationSender<SmsMessage> {

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
