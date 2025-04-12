package by.yurhilevich.notification.validator;

import by.yurhilevich.notification.message.Message;

public interface Validator<T extends Message> {
    boolean validate(T s);
}
