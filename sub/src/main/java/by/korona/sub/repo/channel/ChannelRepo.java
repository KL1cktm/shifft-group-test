package by.korona.sub.repo.channel;

import by.korona.sub.model.channel.Channel;

import java.util.Optional;

public interface ChannelRepo<T extends Channel> {
    Optional<T> findById(Long channelId);
}
