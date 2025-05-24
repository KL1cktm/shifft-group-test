package by.korona.sub.repo.subscriptiondetails;

import by.korona.sub.model.subscripriondetails.SubscriptionDetails;

import java.util.Optional;

public interface SubscriptionDetailRepository<T extends SubscriptionDetails> {

    T save(T subscriptionDetail);

    Optional<T> findActiveSubscription(Long userId, Long channelId);
}
