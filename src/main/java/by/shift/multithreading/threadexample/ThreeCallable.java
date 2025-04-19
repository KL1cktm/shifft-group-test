package by.shift.multithreading.threadexample;

import java.util.concurrent.Callable;

public class ThreeCallable implements Callable<String> {
    @Override
    public String call() {
        return "Some string";
    }
}
