package by.korona.sub.repo;

import by.korona.sub.model.User;

import java.util.Optional;

public interface UserRepo {
    Optional<User> findById(Long channelId);
}
