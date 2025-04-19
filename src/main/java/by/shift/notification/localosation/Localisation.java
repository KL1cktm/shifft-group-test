package by.shift.notification.localosation;

import java.util.Locale;
import java.util.ResourceBundle;

public class Localisation {
    private static final String LOCALISATION_FILE_NAME = "text";
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle(LOCALISATION_FILE_NAME, Locale.ROOT);


    public static void setLocalisation(Locale locale) {
        resourceBundle = ResourceBundle.getBundle(LOCALISATION_FILE_NAME, locale);
    }

    public static String getText(String key) {
        return resourceBundle.getString(key);
    }
}
