package by.korona.sub.repo;

import by.korona.sub.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class InMemoryUserRepository implements UserRepo {
    private final List<User> users;
    private final ObjectMapper objectMapper;


    //TODO вывод сообщение при отсутствии пользователя
    public Optional<User> findById(Long userId) {
        return users.stream()
            .filter(channel -> channel.getId().equals(userId))
            .findFirst();
    }

    @PostConstruct
    private void init() {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream("repository/users.json")))) {
            String collect = bufferedReader.lines().collect(Collectors.joining());
            List<User> list = objectMapper.readValue(collect, objectMapper.getTypeFactory().constructCollectionType(List.class, User.class));
            users.addAll(list);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
