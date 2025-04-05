package by.yurhilevich.notification.resolver;

import by.yurhilevich.notification.NotificationType;
import by.yurhilevich.notification.fabric.NotificationSendersFabric;
import by.yurhilevich.notification.message.Message;
import by.yurhilevich.notification.sender.NotificationSender;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NotificationSendersResolver implements NotificationResolver {

    private final Map<NotificationType, NotificationSender<Message>> senders;

    @SuppressWarnings("all")
    public NotificationSendersResolver(NotificationSendersFabric notificationSendersFabric) {
        List<NotificationSender> list = notificationSendersFabric.getNotificationSenders();
        this.senders = list.stream().collect(Collectors.toMap(NotificationSender::getNotificationType, sender -> sender));
    }

    public NotificationSender<Message> getNotificationSender(NotificationType type) {
        return senders.get(type);
    }
}

