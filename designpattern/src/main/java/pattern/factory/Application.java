package pattern.factory;

import pattern.factory.message.Notification;
import pattern.factory.processor.NotificationProcessor;
import pattern.factory.processor.NotificationProcessorFactory;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        new Thread(() -> {

            List<Notification> notifications = getNotification();
            notifications.forEach(notification -> {
                NotificationProcessor processor = NotificationProcessorFactory.getProcessor(notification.getClass());
                processor.sendMessage(notification);
            });
        }).start();
    }


    private static List<Notification> getNotification() {
        // get notification form DB
        return null;
    }
}


