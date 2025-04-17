package by.yurhilevich.exception;

import lombok.Getter;

@Getter
public class MessageValidationException extends RuntimeException {
    public static final int exceptionCode = 1;

    public MessageValidationException(String m) {
        super(exceptionCode + m);
    }
}
