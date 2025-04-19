package by.shift.notification.exception;

import lombok.Getter;

@Getter
public class MessageValidationException extends RuntimeException {
    public static final int EXCEPTION_CODE = 1;

    public MessageValidationException(String m) {
        super(EXCEPTION_CODE + m);
    }
}
