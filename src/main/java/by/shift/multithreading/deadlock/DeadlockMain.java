package by.shift.multithreading.deadlock;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
/*
 * Несколько потоков согласованно увеличивали значение инта в одном из бакетов.
 * Должны быть потоки которые будут читать значение одновременно
 */
public class DeadlockMain {
    public static void main(String[] args) {

        /*ReentrantLock firstReentrantLock = new ReentrantLock();
        ReentrantLock secondReentrantLock = new ReentrantLock();
        ReentrantLock thirdReentrantLock = new ReentrantLock();*/


        Map<String, Integer> map = new ConcurrentHashMap<>(10, 2, 40);
        map.put("A", 1);
        List<Thread> threadList = IntStream.rangeClosed(1, 2000).mapToObj((i) ->
                new Thread(() -> {
                    for (int j = 0; j < 10000; j++) {
                        map.compute("A", (key, value) -> value == null ? 1 : value + 1);
                        /*map.put("A", map.get("A") + 1);*/
                    }
                })).toList();
        threadList.forEach(Thread::start);
        threadList.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        log.info(map.get("A").toString());

        /*Runnable firstRunnable = () -> {
            firstReentrantLock.lock();
            log.info("First thread get first lock");
            int i = ThreadLocalRandom.current().nextInt(1, 10);
            sleep(i);
            while (true) {
                if (secondReentrantLock.tryLock()) {
                    log.info("First thread acquired all locks");
                    firstReentrantLock.unlock();
                    secondReentrantLock.unlock();
                    break;
                } else {
                    firstReentrantLock.unlock();
                    int j = ThreadLocalRandom.current().nextInt(1, 10);
                    sleep(j);
                    while (firstReentrantLock.tryLock()) {
                        sleep(j);
                    }
                }
            }
        };*/

        /*Runnable secondRunnable = () -> {
            secondReentrantLock.lock();
            log.info("Second thread get second lock");
            int i = ThreadLocalRandom.current().nextInt(1, 10);
            sleep(i);
            boolean locked = thirdReentrantLock.tryLock();
            while (!locked) {
                if (secondReentrantLock.isHeldByCurrentThread()) {
                    secondReentrantLock.unlock();
                }
                if (thirdReentrantLock.isHeldByCurrentThread()) {
                    thirdReentrantLock.unlock();
                }
                int j = ThreadLocalRandom.current().nextInt(1, 10);
                sleep(j);
                locked = secondReentrantLock.tryLock() && thirdReentrantLock.tryLock();
            }
            log.info("Second thread acquired all locks");
            secondReentrantLock.unlock();
            thirdReentrantLock.unlock();
        };

        Runnable thirdRunnable = () -> {
            thirdReentrantLock.lock();
            log.info("Third thread get third lock");
            int i = ThreadLocalRandom.current().nextInt(1, 10);
            sleep(i);
            boolean locked = firstReentrantLock.tryLock();
            while (!locked) {
                if (firstReentrantLock.isHeldByCurrentThread()) {
                    firstReentrantLock.unlock();
                }
                if (thirdReentrantLock.isHeldByCurrentThread()) {
                    thirdReentrantLock.unlock();
                }
                int j = ThreadLocalRandom.current().nextInt(1, 10);
                sleep(j);
                locked = firstReentrantLock.tryLock() && thirdReentrantLock.tryLock();
            }
            log.info("Third thread acquired all locks");
            firstReentrantLock.unlock();
            thirdReentrantLock.unlock();
        };

        Runnable firstRunnable = () -> {
            firstReentrantLock.lock();
            log.info("First thread get first lock");
            int i = ThreadLocalRandom.current().nextInt(1, 10);
            sleep(i);
            boolean locked = secondReentrantLock.tryLock();
            while (!locked) {
                if (firstReentrantLock.isHeldByCurrentThread()) {
                    firstReentrantLock.unlock();
                }
                if (secondReentrantLock.isHeldByCurrentThread()) {
                    secondReentrantLock.unlock();
                }
                int j = ThreadLocalRandom.current().nextInt(1, 10);
                sleep(j);
                locked = firstReentrantLock.tryLock() && secondReentrantLock.tryLock();
            }
            log.info("First thread acquired all locks");
            firstReentrantLock.unlock();
            secondReentrantLock.unlock();
        };

        Thread firstThread = new Thread(firstRunnable);
        Thread secondThread = new Thread(secondRunnable);
        Thread thirdThread = new Thread(thirdRunnable);
        firstThread.start();
        secondThread.start();
        thirdThread.start();*/




        /*Thread deadlockThreadSecond = new Thread(() -> {
            secondReentrantLock.lock();
            int j = ThreadLocalRandom.current().nextInt(1, 10);
            sleep(j);
            log.info("Second thread want another lock");
            firstReentrantLock.lock();
            thirdReentrantLock.lock();
            secondReentrantLock.unlock();
            firstReentrantLock.unlock();
            thirdReentrantLock.unlock();
        });

        deadlockThreadFirst.start();
        deadlockThreadSecond.start();

        Thread deadlockThreadThird = new Thread(() -> {
            thirdReentrantLock.lock();
            int j = ThreadLocalRandom.current().nextInt(1, 10);
            sleep(j);
            log.info("First thread want another lock");
            firstReentrantLock.lock();
            secondReentrantLock.lock();
            *//*if (firstReentrantLock.tryLock()) {
                int i = ThreadLocalRandom.current().nextInt(1, 10);
                sleep(i);
            }else {
                firstReentrantLock.unlock();
                sleep();
            }*//*
            thirdReentrantLock.unlock();
            firstReentrantLock.unlock();
            secondReentrantLock.unlock();
        });*/
    }

    private static void sleep(int secondsSleeping) {
        try {
            TimeUnit.SECONDS.sleep(secondsSleeping);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
