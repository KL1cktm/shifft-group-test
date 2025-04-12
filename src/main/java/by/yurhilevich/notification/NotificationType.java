package by.yurhilevich.notification;

import by.yurhilevich.notification.message.EmailMessage;
import by.yurhilevich.notification.message.SmsMessage;
import by.yurhilevich.notification.message.TelegramMessage;

public enum NotificationType {
    EMAIL(EmailMessage.class),
    SMS(SmsMessage.class),
    TELEGRAM(TelegramMessage.class);
    private final Class k;

    NotificationType(Class message) {
        this.k = message;
    }
}
