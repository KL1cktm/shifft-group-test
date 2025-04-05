package by.yurhilevich.notification.message;

import by.yurhilevich.notification.NotificationType;
import lombok.Builder;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString(callSuper = true)
public class TelegramMessage extends Message {
    private final long chatId;

    public TelegramMessage(String message, LocalDateTime time, long chatId) {
        super(message, time);
        this.chatId = chatId;
    }

    @Override
    public NotificationType getMessageType() {
        return NotificationType.TELEGRAM;
    }

    public static TelegramMessageBuilder builder() {
        return new TelegramMessageBuilder();
    }

    public static class TelegramMessageBuilder extends MessageBuilder<TelegramMessageBuilder> {
        private long chatId;

        public TelegramMessageBuilder setChatId(long chatId) {
            this.chatId = chatId;
            return this;
        }

        @Override
        public Message build() {
            return new TelegramMessage(getMessage(), getTime(), chatId);
        }
    }
}
