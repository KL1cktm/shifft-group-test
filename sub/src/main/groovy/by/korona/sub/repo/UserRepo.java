package by.korona.sub.repo;

import by.korona.sub.model.User;

public interface UserRepo {
    User findById(Long channelId);
}
