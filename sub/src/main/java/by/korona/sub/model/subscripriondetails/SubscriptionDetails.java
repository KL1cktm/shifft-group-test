package by.korona.sub.model.subscripriondetails;

import by.korona.sub.model.User;
import by.korona.sub.model.channel.Channel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public abstract class SubscriptionDetails {
    private Long id;
    private Long userId;
    private Long channelId;
    private LocalDateTime subscriptionAt;
    private LocalDateTime unsubscriptionAt;
    private boolean subscriptionStatus;
}
