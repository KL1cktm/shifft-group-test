package by.yurhilevich.notification.message;

import by.yurhilevich.notification.NotificationType;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString(callSuper = true)
public class SmsMessage extends Message {
    private final long phoneNumber;

    public SmsMessage(String message, LocalDateTime time, long phoneNumber) {
        super(message, time);
        this.phoneNumber = phoneNumber;
    }


    @Override
    public NotificationType getMessageType() {
        return NotificationType.SMS;
    }

    public static SmsMessageBuilder builder() {
        return new SmsMessageBuilder();
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
