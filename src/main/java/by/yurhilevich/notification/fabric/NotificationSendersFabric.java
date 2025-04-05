package by.yurhilevich.notification.fabric;

import by.yurhilevich.notification.message.Message;
import by.yurhilevich.notification.sender.NotificationSender;

import java.util.List;

public interface NotificationSendersFabric {
    List<NotificationSender> getNotificationSenders();
}
