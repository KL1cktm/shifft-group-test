package by.korona.sub.repo;

import by.korona.sub.model.User;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class DefaultUserRepo implements UserRepo {
    private final List<User> users;

    public DefaultUserRepo(List<User> users) {
        this.users = users;
        this.users.add(new User(1L, "1"));
        this.users.add(new User(2L, "2"));
        this.users.add(new User(3L, "3"));
        this.users.add(new User(4L, "4"));
    }

    //TODO вывод сообщение при отсутствии пользователя
    public User findById(Long userId) {
        return users.stream().filter(channel -> channel.getId().equals(userId)).findFirst().orElse(null);
    }
}
