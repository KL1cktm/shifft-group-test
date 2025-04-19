package by.shift.multithreading.order;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class OrderRepository {
    private final List<String> list = new ArrayList<>();

    public void add(String order) {
        synchronized (list) {
            list.add(order);
            log.info("Gift is added {}", order);
        }
    }

    @SneakyThrows
    public void get() {
        synchronized (list) {
            if (!list.isEmpty()) {
                String first = list.getFirst();
                list.removeFirst();
                log.info("Gift {} is grab", first);
            }
        }
    }
}
