package by.korona.sub.repo.subscriptiondetails;

import by.korona.sub.model.subscripriondetails.TelegramSubscriptionDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class TelegramSubscriptionDetailsRepository implements SubscriptionDetailRepository<TelegramSubscriptionDetail> {
    private List<TelegramSubscriptionDetail> subscriptionDetails;

    @Override
    public void createNewSubscription(TelegramSubscriptionDetail subscriptionDetail) {
        subscriptionDetails.add(subscriptionDetail);
    }
}
