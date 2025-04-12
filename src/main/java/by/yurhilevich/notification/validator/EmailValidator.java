package by.yurhilevich.notification.validator;

import by.yurhilevich.notification.message.EmailMessage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator implements Validator<EmailMessage> {
    private static final String REGEX_EMAIL_GMAIL = "^[a-zA-Z0-9._%+-]+@gmail.com$";
    private static final Pattern PATTERN = Pattern.compile(REGEX_EMAIL_GMAIL);

    @Override
    public boolean validate(EmailMessage message) {
        Matcher matcher = PATTERN.matcher(message.getLinkAddress());
        return matcher.matches();
    }
}
