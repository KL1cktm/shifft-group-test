package by.korona.sub.model.subscripriondetails;

import jakarta.persistence.Entity;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Entity(name = "youtubesubscriptiondetails")
public class YouTubeSubscriptionDetails extends SubscriptionDetails {
    public YouTubeSubscriptionDetails() {
    }
}
