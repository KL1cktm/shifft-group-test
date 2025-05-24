package by.korona.sub.model.subscripriondetails;


import jakarta.persistence.Entity;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Entity(name = "telegramsubscriptiondetails")
public class TelegramSubscriptionDetails extends SubscriptionDetails {
    public TelegramSubscriptionDetails() {
    }
}
