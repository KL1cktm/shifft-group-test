package by.korona.sub.exception;

public class SubscriptionDetailsNotFoundException extends RuntimeException{
    public SubscriptionDetailsNotFoundException(String message) {
        super(message);
    }
}
