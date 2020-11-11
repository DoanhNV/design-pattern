package pattern.factory.processor;

import pattern.factory.message.platform.AndroidNotification;
import pattern.factory.message.platform.DesktopNotification;
import pattern.factory.message.platform.IOSNotification;
import pattern.factory.processor.platform.AndroidNotificationProcessor;
import pattern.factory.processor.platform.DesktopNotificationProcessor;
import pattern.factory.processor.platform.IOSNotificationProcessor;
import pattern.factory.processor.platform.WebNotificationProcessor;

import java.util.HashMap;
import java.util.Map;

public class NotificationProcessorFactory {

    private static final Map<Class, NotificationProcessor> PROCESSOR_MAP = new HashMap<Class, NotificationProcessor>();

    static {
        PROCESSOR_MAP.put(AndroidNotification.class, new AndroidNotificationProcessor());
        PROCESSOR_MAP.put(IOSNotification.class, new IOSNotificationProcessor());
        PROCESSOR_MAP.put(DesktopNotification.class, new DesktopNotificationProcessor());
        PROCESSOR_MAP.put(WebNotificationProcessor.class, new WebNotificationProcessor());
    }

    public static NotificationProcessor getProcessor(Class notificationClass) {
        return PROCESSOR_MAP.get(notificationClass);
    }
}
