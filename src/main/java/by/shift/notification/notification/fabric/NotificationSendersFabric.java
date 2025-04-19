package by.shift.notification.notification.fabric;

import by.shift.notification.notification.sender.NotificationSender;

import java.util.List;

public interface NotificationSendersFabric {
    List<NotificationSender> getNotificationSenders();
}
