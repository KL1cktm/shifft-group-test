package by.korona.sub.repo.channel;

import by.korona.sub.model.channel.TelegramChannel;
import by.korona.sub.model.channel.YouTubeChannel;
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
public class DefaultYouTubeChannelRepo implements ChannelRepo<YouTubeChannel> {
    private final List<YouTubeChannel> channels;
    private final ObjectMapper objectMapper;

    @Override
    public Optional<YouTubeChannel> findById(Long channelId) {
        return channels.stream()
            .filter(channel -> channel.getId().equals(channelId))
            .findFirst();
    }

    @PostConstruct
    private void init() {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream("repository/youtube-channels.json")))) {
            String collect = bufferedReader.lines().collect(Collectors.joining());
            List<YouTubeChannel> list = objectMapper.readValue(collect, objectMapper.getTypeFactory().constructCollectionType(List.class, TelegramChannel.class));
            channels.addAll(list);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
