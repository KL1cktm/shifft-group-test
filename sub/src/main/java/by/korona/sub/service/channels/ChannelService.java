package by.korona.sub.service.channels;

import by.korona.sub.service.ChannelType;

public interface ChannelService {
    void subscribe(Long channelId, Long userId);

    void unSubscribe(Long channelId, Long userId);

    ChannelType getChannelType();
}
