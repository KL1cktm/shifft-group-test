package by.shift.notification.notification;

import by.shift.notification.answer.Answer;
import by.shift.notification.answer.SenderAnswer;
import by.shift.notification.notification.decorator.NotificationSenderLoggingDecorator;
import by.shift.notification.notification.fabric.NotificationAllSendersFabric;
import by.shift.notification.notification.fabric.NotificationSendersFabric;
import by.shift.notification.notification.message.EmailMessage;
import by.shift.notification.notification.message.Message;
import by.shift.notification.notification.resolver.NotificationSendersResolver;
import by.shift.notification.notification.sender.NotificationSender;

import java.time.LocalDateTime;


public class NotificationRunner {
    public Answer run() {
        Answer answer = new SenderAnswer();
        try {
            Message message = EmailMessage.builder().setMessage("f").setTime(LocalDateTime.now()).setLinkAddress("ggg@gmail.com").build();
            NotificationSendersFabric notificationSendersFabric = new NotificationAllSendersFabric();

            NotificationSendersResolver resolver = new NotificationSendersResolver(notificationSendersFabric);
            NotificationSender<Message> notificationSender = resolver.getNotificationSender(message.getMessageType());

            NotificationSender<Message> decoratedNotificationSender = new NotificationSenderLoggingDecorator(notificationSender);
            decoratedNotificationSender.sendNotification(message);
        } catch (Exception e) {
            answer.addException(e);
        }
        return answer;
    }
}
