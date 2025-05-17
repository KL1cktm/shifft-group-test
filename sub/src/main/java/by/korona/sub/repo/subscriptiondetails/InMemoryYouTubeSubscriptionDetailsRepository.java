package by.korona.sub.repo.subscriptiondetails;

import by.korona.sub.exception.SubscriptionDetailsNotFoundException;
import by.korona.sub.model.subscripriondetails.SubscriptionDetails;
import by.korona.sub.model.subscripriondetails.YouTubeSubscriptionDetails;
import by.korona.sub.utils.IdGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class InMemoryYouTubeSubscriptionDetailsRepository implements SubscriptionDetailRepository<YouTubeSubscriptionDetails> {

    private final IdGenerator idGenerator;
    private final List<YouTubeSubscriptionDetails> subscriptionDetails;

    @Override
    public YouTubeSubscriptionDetails save(YouTubeSubscriptionDetails subscriptionDetail) {
        synchronized (subscriptionDetails) {
            if (subscriptionDetail.getId() == null) {
                subscriptionDetail.setId(idGenerator.getId());
                subscriptionDetails.add(subscriptionDetail);
            } else {
                YouTubeSubscriptionDetails existingDetail = subscriptionDetails.stream()
                        .filter(s -> s.getId().equals(subscriptionDetail.getId()))
                        .findFirst()
                        .orElseThrow(() -> new SubscriptionDetailsNotFoundException("Id: %s not found".formatted(subscriptionDetail.getId())));
                subscriptionDetails.remove(existingDetail);
                subscriptionDetails.add(subscriptionDetail);
            }
        }
        return subscriptionDetail;
    }

    @Override
    public Optional<YouTubeSubscriptionDetails> findActiveSubscription(Long userId, Long channelId) {
        return subscriptionDetails.stream()
                .filter(s -> s.getUserId().equals(userId))
                .filter(s -> s.getChannelId().equals(channelId))
                .filter(SubscriptionDetails::isSubscriptionStatus)
                .findFirst();
    }
}
