package by.korona.sub.service.resolver;

import by.korona.sub.service.ChannelType;
import by.korona.sub.service.channels.ChannelService;

public interface ChannelServiceResolver {
    ChannelService resolveChannel(ChannelType channelType);
}
