package by.korona.sub.repo.subscriptiondetails;

import by.korona.sub.model.subscripriondetails.SubscriptionDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubscriptionDetailRepository<T extends SubscriptionDetails> {

    T save(T subscriptionDetail);

    Optional<T> findActiveSubscription(Long userId, Long channelId);
}
