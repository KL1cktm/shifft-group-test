package by.yurhilevich.notification.fabric;

import by.yurhilevich.notification.sender.EmailSender;
import by.yurhilevich.notification.sender.NotificationSender;
import by.yurhilevich.notification.sender.SmsSender;

import java.util.ArrayList;
import java.util.List;

public class NotificationTwoSendersFabric implements NotificationSendersFabric {
    @Override
    public List<NotificationSender> getNotificationSenders() {
        List<NotificationSender> senders = new ArrayList<>();
        senders.add(new SmsSender());
        senders.add(new EmailSender());
        return senders;
    }
}
