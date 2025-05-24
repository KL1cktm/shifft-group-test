package by.korona.sub.repo.subscriptiondetails;

import by.korona.sub.model.subscripriondetails.SubscriptionDetailsPrimaryKey;
import by.korona.sub.model.subscripriondetails.YouTubeSubscriptionDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DbYouTubeSubscriptionDetailsRepository extends JpaRepository<YouTubeSubscriptionDetails, SubscriptionDetailsPrimaryKey> {
    Optional<YouTubeSubscriptionDetails> findBySubscriptionStatusTrueAndId_UserIdAndId_ChannelId(Long userId, Long channelId);
}
