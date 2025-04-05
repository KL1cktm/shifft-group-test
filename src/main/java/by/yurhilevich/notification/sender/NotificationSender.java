package by.yurhilevich.notification.sender;

import by.yurhilevich.notification.NotificationType;
import by.yurhilevich.notification.message.Message;

public interface NotificationSender <T extends Message> {
    void sendNotification(T message);
    NotificationType getNotificationType() ;
}
