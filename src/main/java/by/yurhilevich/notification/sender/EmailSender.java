package by.yurhilevich.notification.sender;

import by.yurhilevich.notification.NotificationType;
import by.yurhilevich.notification.message.EmailMessage;
import by.yurhilevich.notification.message.Message;
import by.yurhilevich.notification.message.TelegramMessage;

public class EmailSender implements NotificationSender <EmailMessage> {

    private final NotificationType notificationType = NotificationType.EMAIL;

    @Override
    public void sendNotification(EmailMessage message) {
        System.out.println(message);
    }

    @Override
    public NotificationType getNotificationType() {
        return notificationType;
    }

}
