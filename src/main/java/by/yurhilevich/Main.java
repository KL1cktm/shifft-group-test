package by.yurhilevich;

import by.yurhilevich.answer.Answer;
import by.yurhilevich.localosation.Localisation;
import by.yurhilevich.notification.NotificationRunner;

import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        Localisation.setLocalisation(Locale.of("ru", "RU"));
        NotificationRunner notificationRunner = new NotificationRunner();
        Answer answer = notificationRunner.run();
        if (answer.isFine()) {
            System.out.println(Localisation.getText("good"));
        } else {
            answer.getExceptions().forEach(e -> System.out.println(e.getMessage()));
        }
    }
}