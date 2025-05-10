package by.korona.sub.repo;

import by.korona.sub.model.channel.Channel;

public interface ChannelRepo {
    Channel findById(Long channelId);
}
