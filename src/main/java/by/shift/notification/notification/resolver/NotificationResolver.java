package by.shift.notification.notification.resolver;

import by.shift.notification.notification.NotificationType;
import by.shift.notification.notification.sender.NotificationSender;

public interface NotificationResolver {
    NotificationSender getNotificationSender(NotificationType type);
}
