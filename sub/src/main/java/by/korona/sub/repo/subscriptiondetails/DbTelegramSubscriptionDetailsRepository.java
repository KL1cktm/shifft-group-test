package by.korona.sub.repo.subscriptiondetails;


import by.korona.sub.model.subscripriondetails.SubscriptionDetailsPrimaryKey;
import by.korona.sub.model.subscripriondetails.TelegramSubscriptionDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DbTelegramSubscriptionDetailsRepository extends JpaRepository<TelegramSubscriptionDetails, SubscriptionDetailsPrimaryKey> {
    Optional<TelegramSubscriptionDetails> findBySubscriptionStatusTrueAndId_UserIdAndId_ChannelId(Long userId, Long channelId);
}
