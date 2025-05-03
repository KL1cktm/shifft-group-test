package by.shift.notification.notification.decorator;

import by.shift.notification.notification.NotificationType;
import by.shift.notification.notification.message.Message;
import by.shift.notification.notification.sender.NotificationSender;
import by.shift.notification.response.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class NotificationSenderLoggingDecorator implements NotificationSender<Message> {
    private final NotificationSender<Message> notificationSender;

    @Override
    public Response sendNotification(Message message) {
        log.info("Sending notification");
        Response response=this.notificationSender.sendNotification(message);
        log.info(response.statusCode());
        return response;
    }

    @Override
    public NotificationType getNotificationType() {
        log.trace("Getting notification type");
        return this.notificationSender.getNotificationType();
    }
}
