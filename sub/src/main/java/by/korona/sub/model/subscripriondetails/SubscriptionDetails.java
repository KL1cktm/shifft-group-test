package by.korona.sub.model.subscripriondetails;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@MappedSuperclass
public abstract class SubscriptionDetails {
    @EmbeddedId
    private SubscriptionDetailsPrimaryKey id;
    private LocalDateTime subscriptionAt;
    private LocalDateTime unsubscriptionAt;
    private boolean subscriptionStatus;
}
