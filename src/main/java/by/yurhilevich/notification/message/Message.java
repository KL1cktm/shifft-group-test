package by.yurhilevich.notification.message;

import by.yurhilevich.notification.NotificationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
@AllArgsConstructor
public abstract class Message {
    private final String message;
    private final LocalDateTime time;

    public abstract NotificationType getMessageType();

    @Getter
    @Setter
    public abstract static class MessageBuilder<T extends MessageBuilder<T>> {
        private String message;
        private LocalDateTime time;

        public T setMessage(String message) {
            this.message = message;
            T result = (T) this;
            return result;
        }

        public T setTime(LocalDateTime time) {
            this.time = time;
            T result = (T) this;
            return result;
        }

        public abstract Message build();
    }
}
