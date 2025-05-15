package by.korona.sub.utils;

import org.springframework.stereotype.Service;

@Service
public class DefaultIdGenerator implements IdGenerator {
    private static Long id = 0L;

    @Override
    public synchronized Long getId() {
        return id++;
    }
}
