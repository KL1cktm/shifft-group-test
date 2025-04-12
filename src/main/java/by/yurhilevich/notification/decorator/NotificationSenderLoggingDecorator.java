package by.yurhilevich.notification.decorator;

import by.yurhilevich.notification.NotificationType;
import by.yurhilevich.notification.message.Message;
import by.yurhilevich.notification.sender.NotificationSender;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class NotificationSenderLoggingDecorator implements NotificationSender<Message> {
    private final NotificationSender<Message> notificationSender;

    @Override
    public void sendNotification(Message message) {
        log.info("Sending notification");
        this.notificationSender.sendNotification(message);
        log.info("Notification sent successfully");
    }

    @Override
    public NotificationType getNotificationType() {
        log.trace("Getting notification type");
        return this.notificationSender.getNotificationType();
    }
}
