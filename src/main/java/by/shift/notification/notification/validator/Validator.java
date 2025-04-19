package by.shift.notification.notification.validator;

import by.shift.notification.notification.message.Message;

public interface Validator<T extends Message> {
    boolean validate(T s);
}
