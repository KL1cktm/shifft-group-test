package by.korona.sub.service.channels;

public interface SubscriptionService {
    void processSubscription(String channelType, Long channelId, Long userId);

    void processUnSubscription(String channelType, Long channelId, Long userId);
}
