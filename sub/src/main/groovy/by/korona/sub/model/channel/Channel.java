package by.korona.sub.model.channel;

import by.korona.sub.model.User;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public abstract class Channel implements Observable {
    private List<User> subscribers;
    private Long id;
    private String name;

    protected Channel(Long id, String name) {
        this.id = id;
        this.name = name;
        this.subscribers = new ArrayList<>();
    }

    @Override
    public void subscribeUser(User u) {
        log.info("Subscribing user {}", u);
        subscribers.add(u);
    }

    @Override
    public void unsubscribeUser(User u) {
        log.info("Unsubscribing user {}", u);
        subscribers.remove(u);
    }

    @Override
    public List<User> getSubscriptions(Long id) {
        return subscribers;
    }
}
