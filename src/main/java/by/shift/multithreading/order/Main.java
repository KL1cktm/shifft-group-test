package by.shift.multithreading.order;


import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/// Есть склад товаров. Туда поступают товары и есть люди которые товары со склада забирают и
/// разносят по полкам.
/// Реализовать асинхронную очередь не используя коллекции из канкаренси.
/// Товары - строки.
/// Метод добавления и метод вычитывания.
/// Из мэин читаем и добавляем новые.
public class Main {

    private static final AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) {
        OrderRepository orderRepository = new OrderRepository();

        IntStream.rangeClosed(0, 9)
            .forEach(i -> {
                    Thread thread = new Thread(() -> {
                        while (true) {
                            orderRepository.get();
                        }
                    });
                    thread.setName("Thread reader %d".formatted(i));
                    thread.start();
                }
            );

        IntStream.rangeClosed(0, 100)
            .forEach(i ->
                {
                    Thread thread = new Thread(() -> {
                        int j = ThreadLocalRandom.current().nextInt(1, 10);
                        sleep(j);
                        orderRepository.add("\"Gift %d\"".formatted(atomicInteger.incrementAndGet()));
                    });
                    thread.setName("Thread writer %d".formatted(i));
                    thread.start();
                }
            );
    }

    private static void sleep(int secondsSleeping) {
        try {
            TimeUnit.SECONDS.sleep(secondsSleeping);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
