package by.korona.sub.service.resolver;

import by.korona.sub.exception.ChannelNotFoundException;
import by.korona.sub.service.ChannelType;
import by.korona.sub.service.channels.ChannelService;
import java.util.List;
import java.util.Map;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DefaultChannelResolver implements ChannelServiceResolver {
    private final Map<ChannelType, ChannelService> channelServices;

    @Override
    public ChannelService resolveChannel(ChannelType channelType) {
        return channelServices.get(channelType);
    }
}
