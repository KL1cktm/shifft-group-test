package by.korona.sub.model.channel;

import by.korona.sub.model.User;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class TelegramChannel implements Channel {
    private List<User> subscribers;
    private Long id;
    private String name;

    @Override
    public void subscribeUser(User u) {
        //subscribers.add(u);
    }

    @Override
    public void unsubscribeUser(User u) {
        //subscribers.remove(u);
    }

    @Override
    public void getSubscriptions(Long id) {

    }
}
