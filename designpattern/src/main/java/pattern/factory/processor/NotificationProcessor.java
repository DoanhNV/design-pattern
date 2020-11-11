package pattern.factory.processor;

import pattern.factory.message.Notification;

public interface NotificationProcessor {

    public void sendMessage(Notification notification);
}
