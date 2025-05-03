package by.shift.notification.notification.callback;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DefaultNotificationCallback implements NotificationCallBack {

    @Override
    public void onComplete() {
        log.info("saved to db");
    }

    @Override
    public void onError(String errorMessage) {
        throw new RuntimeException(errorMessage);
    }
}