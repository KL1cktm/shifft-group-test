package by.shift.multithreading.threadexample;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FirstThread extends Thread {
    @Override
    public void run() {
        log.info("work");
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName);
    }
}
