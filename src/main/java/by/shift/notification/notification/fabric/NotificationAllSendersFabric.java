package by.shift.notification.notification.fabric;

import by.shift.notification.notification.sender.EmailSender;
import by.shift.notification.notification.sender.NotificationSender;
import by.shift.notification.notification.sender.SmsSender;
import by.shift.notification.notification.sender.TelegramSender;
import by.shift.notification.notification.validator.EmailValidator;

import java.util.ArrayList;
import java.util.List;

public class NotificationAllSendersFabric implements NotificationSendersFabric {

    public List<NotificationSender> getNotificationSenders() {
        List<NotificationSender> senders = new ArrayList<>();
        senders.add(new TelegramSender());
        senders.add(new SmsSender());
        senders.add(new EmailSender(new EmailValidator()));
        return senders;
    }
}
