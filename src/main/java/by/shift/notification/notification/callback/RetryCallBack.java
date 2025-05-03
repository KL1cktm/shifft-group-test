package by.shift.notification.notification.callback;

import by.shift.notification.notification.message.Message;
import by.shift.notification.notification.sender.NotificationSender;
import by.shift.notification.response.Response;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RetryCallBack implements NotificationCallBack {

    @Setter
    private Message message;

    @Setter
    private NotificationSender<Message> sender;

    private final int tries;

    private int counter = 1;

    public RetryCallBack(int tries) {
        this.tries = tries;
    }

    @Override
    public void onComplete() {
        log.info("saved to db");
    }

    @Override
    public void onError(String errorMessage) {
        while (counter <= tries) {
            log.info("resending notification, try number {}", counter++);
            Response response = sender.sendNotification(message);
            if (response.statusCode().equals("200")) {
                onComplete();
                return;
            }
        }
        /*log.warn("Failed to send notification");*/
        throw new RuntimeException("Failed to send notification");
    }
}