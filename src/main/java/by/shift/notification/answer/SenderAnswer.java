package by.shift.notification.answer;

import java.util.ArrayList;
import java.util.List;

public class SenderAnswer implements Answer {
    private final List<Throwable> exceptionList = new ArrayList<>();

    @Override
    public boolean isFine() {
        return exceptionList.isEmpty();
    }

    @Override
    public List<Throwable> getExceptions() {
        return exceptionList;
    }

    @Override
    public void addException(Throwable e) {
        exceptionList.add(e);
    }
}
