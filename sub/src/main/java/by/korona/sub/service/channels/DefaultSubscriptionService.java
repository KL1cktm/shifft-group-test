package by.korona.sub.service.channels;

import by.korona.sub.service.ChannelType;
import by.korona.sub.service.resolver.ChannelServiceResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DefaultSubscriptionService implements SubscriptionService {
    private final ChannelServiceResolver channelServiceResolver;

    public DefaultSubscriptionService(ChannelServiceResolver channelServiceResolver) {
        this.channelServiceResolver = channelServiceResolver;
    }

    @Override
    public void processSubscription(String channelType, Long channelId, Long userId) {
        ChannelService channelService = channelServiceResolver.resolveChannel(ChannelType.valueOf(channelType));
        channelService.subscribe(channelId, userId);
        log.info("Subscribed to channel {}", channelType);
    }

    @Override
    public void processUnSubscription(String channelType, Long channelId, Long userId) {
        ChannelService channelService = channelServiceResolver.resolveChannel(ChannelType.valueOf(channelType));
        channelService.unSubscribe(channelId, userId);
        log.info("UnSubscribed from channel {}", channelType);
    }
}
