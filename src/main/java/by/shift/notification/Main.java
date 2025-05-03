package by.shift.notification;

import by.shift.notification.answer.Answer;
import by.shift.notification.localosation.Localisation;
import by.shift.notification.notification.NotificationRunner;
import by.shift.notification.notification.callback.RetryCallBack;

import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        Localisation.setLocalisation(Locale.of("ru", "RU"));
        NotificationRunner notificationRunner = new NotificationRunner();
        Answer answer = notificationRunner.run(new RetryCallBack(3));
        if (answer.isFine()) {
            System.out.println(Localisation.getText("good"));
        } else {
            answer.getExceptions().forEach(e -> System.out.println(e.getMessage()));
        }
    }
}