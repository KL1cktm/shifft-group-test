package by.shift.notification.notification.message;

import by.shift.notification.notification.NotificationType;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString(callSuper = true)
@Getter
public final class TelegramMessage extends Message {
    private final long chatId;

    public TelegramMessage(String message, LocalDateTime time, long chatId) {
        super(message, time);
        this.chatId = chatId;
    }

    public static TelegramMessageBuilder builder() {
        return new TelegramMessageBuilder();
    }

    @Override
    public NotificationType getMessageType() {
        return NotificationType.TELEGRAM;
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
