package by.korona.sub.repo;

import by.korona.sub.model.channel.Channel;
import by.korona.sub.model.channel.TelegramChannel;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class DefaultChannelRepo implements ChannelRepo {
    private final List<Channel> channels;

    public DefaultChannelRepo(List<Channel> channels) {
        this.channels = channels;
        channels.add(new TelegramChannel(11L, "Топор"));
        channels.add(new TelegramChannel(22L, "Сливки"));
    }

    //TODO вывод сообщение при отсутствии канала
    public Channel findById(Long channelId) {
        return channels.stream().filter(channel -> channel.getId().equals(channelId)).findFirst().orElse(null);
    }
}
