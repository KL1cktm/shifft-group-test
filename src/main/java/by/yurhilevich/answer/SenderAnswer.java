package by.yurhilevich.answer;

import java.util.ArrayList;
import java.util.List;

public class SenderAnswer implements Answer {
    private final List<Exception> exceptionList = new ArrayList<>();

    @Override
    public boolean isFine() {
        return exceptionList.isEmpty();
    }

    @Override
    public List<Exception> getExceptions() {
        return exceptionList;
    }

    @Override
    public void addException(Exception e) {
        exceptionList.add(e);
    }
}
