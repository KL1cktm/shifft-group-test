package by.korona.sub.model.subscripriondetails;

import by.korona.sub.model.User;
import by.korona.sub.model.channel.Channel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class SubscriptionDetails<T extends Channel> {
    private Long id;
    private User user;
    private T channel;
    private LocalDateTime subscriptionAt;
    private LocalDateTime unsubscriptionAt;
    private boolean subscriptionStatus;
}
