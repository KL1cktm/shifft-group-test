package by.shift.notification.notification.sender;

import by.shift.notification.notification.NotificationType;
import by.shift.notification.notification.message.Message;
import by.shift.notification.response.Response;

public interface NotificationSender<T extends Message> {
    Response sendNotification(T message);

    NotificationType getNotificationType();
}