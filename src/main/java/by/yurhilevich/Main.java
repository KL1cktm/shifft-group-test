package by.yurhilevich;

/*
 * написать проект, который будет отправлять нотфикации в разные мессенджеры
 * sms, telegram, email
 */


import by.yurhilevich.notification.decorator.NotificationSenderLoggingDecorator;
import by.yurhilevich.notification.fabric.NotificationAllSendersFabric;
import by.yurhilevich.notification.fabric.NotificationSendersFabric;
import by.yurhilevich.notification.message.Message;
import by.yurhilevich.notification.message.SmsMessage;
import by.yurhilevich.notification.resolver.NotificationSendersResolver;
import by.yurhilevich.notification.sender.NotificationSender;

import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
        Message message = SmsMessage.builder().setMessage("Привет").setTime(LocalDateTime.now()).setPhoneNumber(32312).build();

        NotificationSendersFabric notificationSendersFabric = new NotificationAllSendersFabric();

        NotificationSendersResolver resolver = new NotificationSendersResolver(notificationSendersFabric);
        NotificationSender<Message> notificationSender = resolver.getNotificationSender(message.getMessageType());

        NotificationSender<Message> decoratedNotificationSender = new NotificationSenderLoggingDecorator(notificationSender);
        decoratedNotificationSender.sendNotification(message);

    }
}