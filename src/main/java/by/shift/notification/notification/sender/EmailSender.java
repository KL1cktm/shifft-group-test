package by.shift.notification.notification.sender;

import by.shift.notification.exception.MessageValidationException;
import by.shift.notification.localosation.Localisation;
import by.shift.notification.notification.NotificationType;
import by.shift.notification.notification.message.EmailMessage;
import by.shift.notification.notification.validator.Validator;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EmailSender implements NotificationSender<EmailMessage> {
    private final Validator<EmailMessage> validator;
    private final NotificationType notificationType = NotificationType.EMAIL;

    @Override
    public void sendNotification(EmailMessage message) {
        if (!validator.validate(message)) {
            throw new MessageValidationException(Localisation.getText("bad"));
        }
        System.out.println(message);
    }

    @Override
    public NotificationType getNotificationType() {
        return notificationType;
    }

}
