package by.korona.sub.model.channel;

import by.korona.sub.model.User;
import java.util.List;

public interface Observable {
    void subscribeUser(User u);

    void unsubscribeUser(User u);

    List<User> getSubscriptions(Long id);
}
