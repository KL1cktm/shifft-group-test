package by.korona.sub.model.subscripriondetails;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@EqualsAndHashCode
@Embeddable
@RequiredArgsConstructor
@AllArgsConstructor
public class SubscriptionDetailsPrimaryKey {
    private Long channelId;
    private Long userId;
}