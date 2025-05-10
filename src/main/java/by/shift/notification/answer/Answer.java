package by.shift.notification.answer;

import java.util.List;

public interface Answer {
    boolean isFine();

    List<Throwable> getExceptions();

    void addException(Throwable e);
}
