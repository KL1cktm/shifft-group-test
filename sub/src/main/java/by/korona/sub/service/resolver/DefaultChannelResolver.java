package by.korona.sub.service.resolver;

import by.korona.sub.service.ChannelType;
import by.korona.sub.service.channels.ChannelService;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class DefaultChannelResolver implements ChannelServiceResolver {
    private final List<ChannelService> channelServices;

    public DefaultChannelResolver(List<ChannelService> channelServices) {
        this.channelServices = channelServices;
    }

    @Override
    public ChannelService resolveChannel(ChannelType channelType) {
        return channelServices.stream().filter(channel -> channel.getChannelType() == channelType).findFirst().orElseThrow(() -> new RuntimeException("Нет"));
    }
}
