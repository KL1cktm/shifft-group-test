package by.yurhilevich.notification;

import by.yurhilevich.answer.Answer;
import by.yurhilevich.answer.SenderAnswer;
import by.yurhilevich.notification.decorator.NotificationSenderLoggingDecorator;
import by.yurhilevich.notification.fabric.NotificationAllSendersFabric;
import by.yurhilevich.notification.fabric.NotificationSendersFabric;
import by.yurhilevich.notification.message.EmailMessage;
import by.yurhilevich.notification.message.Message;
import by.yurhilevich.notification.resolver.NotificationSendersResolver;
import by.yurhilevich.notification.sender.NotificationSender;

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
