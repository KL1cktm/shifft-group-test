package by.yurhilevich.answer;

import java.util.List;

public interface Answer {
    boolean isFine();

    List<Exception> getExceptions();

    void addException(Exception e);
}
