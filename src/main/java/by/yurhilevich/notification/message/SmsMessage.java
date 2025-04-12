package by.yurhilevich.notification.message;

import by.yurhilevich.notification.NotificationType;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString(callSuper = true)
@Getter
public final class SmsMessage extends Message {
    private final long phoneNumber;

    private SmsMessage(String message, LocalDateTime time, long phoneNumber) {
        super(message, time);
        this.phoneNumber = phoneNumber;
    }

    public static NotificationType getSMS() {
        return NotificationType.SMS;
    }

    public static NotificationType getType() {
        return NotificationType.TELEGRAM;
    }

    public static SmsMessageBuilder builder() {
        return new SmsMessageBuilder();
    }

    @Override
    public NotificationType getMessageType() {
        return getType();
    }

    public static class SmsMessageBuilder extends MessageBuilder<SmsMessageBuilder> {
        private long phoneNumber;

        public SmsMessageBuilder setPhoneNumber(long phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        @Override
        public Message build() {
            return new SmsMessage(getMessage(), getTime(), phoneNumber);
        }
    }
}
