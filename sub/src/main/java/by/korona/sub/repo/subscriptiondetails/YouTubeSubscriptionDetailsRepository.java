package by.korona.sub.repo.subscriptiondetails;

import by.korona.sub.model.subscripriondetails.YouTubeSubscriptionDetails;

import java.util.List;

public class YouTubeSubscriptionDetailsRepository implements SubscriptionDetailRepository<YouTubeSubscriptionDetails> {
    private List<YouTubeSubscriptionDetails> subscriptionDetails;

    @Override
    public void createNewSubscription(YouTubeSubscriptionDetails subscriptionDetail) {
        subscriptionDetails.add(subscriptionDetail);
    }
}
