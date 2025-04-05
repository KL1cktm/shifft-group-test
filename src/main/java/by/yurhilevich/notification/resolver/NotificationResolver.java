package by.yurhilevich.notification.resolver;

import by.yurhilevich.notification.NotificationType;
import by.yurhilevich.notification.sender.NotificationSender;

public interface NotificationResolver {
    NotificationSender getNotificationSender(NotificationType type);
}
