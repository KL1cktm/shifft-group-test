package by.yurhilevich.notification.sender;

import by.yurhilevich.localosation.Localisation;
import by.yurhilevich.exception.MessageValidationException;
import by.yurhilevich.notification.NotificationType;
import by.yurhilevich.notification.message.EmailMessage;
import by.yurhilevich.notification.validator.Validator;
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
