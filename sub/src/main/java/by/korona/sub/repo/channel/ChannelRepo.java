package by.korona.sub.repo.channel;

import by.korona.sub.model.channel.Channel;

public interface ChannelRepo<T extends Channel> {
    T findById(Long channelId);
}
