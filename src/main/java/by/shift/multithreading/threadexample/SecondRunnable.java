package by.shift.multithreading.threadexample;

public class SecondRunnable implements Runnable {
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name);
    }
}
