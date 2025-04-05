package by.yurhilevich.notification.fabric;

import by.yurhilevich.notification.message.Message;
import by.yurhilevich.notification.sender.EmailSender;
import by.yurhilevich.notification.sender.NotificationSender;
import by.yurhilevich.notification.sender.SmsSender;
import by.yurhilevich.notification.sender.TelegramSender;

import java.util.ArrayList;
import java.util.List;

public class NotificationAllSendersFabric implements NotificationSendersFabric {

    public List<NotificationSender> getNotificationSenders() {
        List<NotificationSender> senders = new ArrayList<>();
        senders.add(new TelegramSender());
        senders.add(new SmsSender());
        senders.add(new EmailSender());
        return senders;
    }
}
