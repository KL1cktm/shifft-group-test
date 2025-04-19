package by.shift.notification.notification.resolver;

import by.shift.notification.notification.NotificationType;
import by.shift.notification.notification.fabric.NotificationSendersFabric;
import by.shift.notification.notification.message.Message;
import by.shift.notification.notification.sender.NotificationSender;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NotificationSendersResolver implements NotificationResolver {

    private final Map<NotificationType, NotificationSender<Message>> senders;

    public NotificationSendersResolver(NotificationSendersFabric notificationSendersFabric) {
        List<NotificationSender> list = notificationSendersFabric.getNotificationSenders();
        this.senders = list.stream().collect(Collectors.toMap(NotificationSender::getNotificationType, sender -> sender));
    }

    public NotificationSender<Message> getNotificationSender(NotificationType type) {
        return senders.get(type);
    }
}

