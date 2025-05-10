package by.korona.sub.model.channel;

import by.korona.sub.model.User;

public interface Observable {
    void subscribeUser(User u);
    void unsubscribeUser(User u);
    void getSubscriptions(Long id);
}
