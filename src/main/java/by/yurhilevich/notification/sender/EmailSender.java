package by.yurhilevich.notification.sender;

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
        if (validator.validate(message)) {
            System.out.println(message);
        } else {
            System.out.println("Wrong Adress");
        }
    }

    @Override
    public NotificationType getNotificationType() {
        return notificationType;
    }

}
