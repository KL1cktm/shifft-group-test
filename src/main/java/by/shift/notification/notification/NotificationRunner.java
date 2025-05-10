package by.shift.notification.notification;

import by.shift.notification.answer.Answer;
import by.shift.notification.answer.SenderAnswer;
import by.shift.notification.notification.callback.NotificationCallBack;
import by.shift.notification.notification.callback.RetryCallBack;
import by.shift.notification.notification.decorator.NotificationSenderLoggingDecorator;
import by.shift.notification.notification.fabric.NotificationAllSendersFabric;
import by.shift.notification.notification.fabric.NotificationSendersFabric;
import by.shift.notification.notification.message.EmailMessage;
import by.shift.notification.notification.message.Message;
import by.shift.notification.notification.resolver.NotificationSendersResolver;
import by.shift.notification.notification.sender.NotificationSender;
import by.shift.notification.response.Response;

import java.time.LocalDateTime;


public class NotificationRunner {

    public Answer run(NotificationCallBack callBack) {
        Answer answer = new SenderAnswer();
        try {
            Message message = EmailMessage.builder().setMessage("f").setTime(LocalDateTime.now()).setLinkAddress("ggg@gmail.com").build();
            NotificationSendersFabric notificationSendersFabric = new NotificationAllSendersFabric();

            NotificationSendersResolver resolver = new NotificationSendersResolver(notificationSendersFabric);
            NotificationSender<Message> notificationSender = resolver.getNotificationSender(message.getMessageType());

            NotificationSender<Message> decoratedNotificationSender = new NotificationSenderLoggingDecorator(notificationSender);
            RetryCallBack castedCallBack = (RetryCallBack) callBack;
            castedCallBack.setMessage(message);
            castedCallBack.setSender(decoratedNotificationSender);
            Runnable runnable = () -> {
                Response response = decoratedNotificationSender.sendNotification(message);
                if (response.statusCode().equals("200")) {
                    callBack.onComplete();
                } else {
                    callBack.onError(response.statusCode());
                }
            };
            Thread thread = new Thread(runnable);
            thread.setUncaughtExceptionHandler((t, e) -> answer.addException(e));
            thread.start();
        } catch (Throwable e) {
            answer.addException(e);
        }
        return answer;
    }
}
