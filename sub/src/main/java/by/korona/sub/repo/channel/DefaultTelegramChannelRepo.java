package by.korona.sub.repo.channel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import by.korona.sub.model.channel.TelegramChannel;
import by.korona.sub.utils.IdGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class DefaultTelegramChannelRepo implements ChannelRepo<TelegramChannel> {
    private final List<TelegramChannel> channels;
    private final ObjectMapper objectMapper;

    //TODO вывод сообщение при отсутствии канала
    public Optional<TelegramChannel> findById(Long channelId) {
        return channels.stream()
            .filter(channel -> channel.getId().equals(channelId))
            .findFirst();
    }

    @PostConstruct
    private void init(){
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream("repository/telegram-channels.json")))) {
            String collect = bufferedReader.lines().collect(Collectors.joining());
            List<TelegramChannel> list = objectMapper.readValue(collect, objectMapper.getTypeFactory().constructCollectionType(List.class, TelegramChannel.class));
            channels.addAll(list);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
