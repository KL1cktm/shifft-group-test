package by.shift.multithreading.threadexample;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final Integer LOCK = 0;
    private static int count = 0;
    private static AtomicInteger atomicCount = new AtomicInteger(0);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        /*
        CompletableFuture.runAsync(new SecondRunnable());

        FirstThread first = new FirstThread();
        first.setName("My name");
        first.start();

        Thread second = new Thread(new SecondRunnable());
        second.start();
        */

        Future<String> future = executorService.submit(new ThreeCallable());
        String futureText = future.get();
        executorService.shutdown();
        log.info("{}", futureText);

        //Lock lock = new ReentrantLock();
        IntStream.rangeClosed(1, 100)
            .forEach(i -> {
                Thread thread = new Thread(() -> IntStream.rangeClosed(1, 10)
                    .forEach(j -> {
                        //lock.lock();
                        //synchronized (/*Main.class*/LOCK){
                        log.info("Count: {}", count/*atomicCount*/);
                        //atomicCount.getAndIncrement();
                        count++;
                        //lock.unlock();
                        //}
                    })
                );
                thread.setName("Thread number %d".formatted(i));
                thread.start();
            });
        log.info("{}", count);
    }
}
