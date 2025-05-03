package by.shift.notification.notification.sender;

import by.shift.notification.notification.NotificationType;
import by.shift.notification.notification.message.SmsMessage;
import by.shift.notification.response.Response;

//getNotificationType
public class SmsSender implements NotificationSender<SmsMessage> {

    private final NotificationType notificationType = NotificationType.SMS;

    @Override
    public Response sendNotification(SmsMessage message) {
        System.out.println(message);
        return new Response(message, "200");
    }

    @Override
    public NotificationType getNotificationType() {
        return notificationType;
    }
}
