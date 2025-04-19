package by.shift.notification.notification.sender;

import by.shift.notification.notification.NotificationType;
import by.shift.notification.notification.message.Message;

public interface NotificationSender<T extends Message> {
    void sendNotification(T message);

    NotificationType getNotificationType();
}