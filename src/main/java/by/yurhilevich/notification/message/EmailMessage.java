package by.yurhilevich.notification.message;

import by.yurhilevich.notification.NotificationType;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString(callSuper = true)
public class EmailMessage extends Message {
    private final String linkAddress;

    public EmailMessage(String message, LocalDateTime time, String linkAddress) {
        super(message, time);
        this.linkAddress = linkAddress;
    }

    @Override
    public NotificationType getMessageType() {
        return NotificationType.EMAIL;
    }

    public static EmailMessageBuilder builder() {
        return new EmailMessageBuilder();
    }

    public static class EmailMessageBuilder extends MessageBuilder<EmailMessageBuilder> {
        private String linkAddress;

        public EmailMessage.EmailMessageBuilder setLinkAddress(String linkAddress) {
            this.linkAddress = linkAddress;
            return this;
        }

        @Override
        public Message build() {
            return new EmailMessage(getMessage(), getTime(), linkAddress);
        }
    }
}
