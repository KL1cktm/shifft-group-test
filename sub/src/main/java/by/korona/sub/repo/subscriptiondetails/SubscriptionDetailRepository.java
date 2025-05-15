package by.korona.sub.repo.subscriptiondetails;

import by.korona.sub.model.subscripriondetails.SubscriptionDetails;
import by.korona.sub.model.subscripriondetails.TelegramSubscriptionDetail;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionDetailRepository<T extends SubscriptionDetails> {

    void createNewSubscription(T subscriptionDetail);
}
