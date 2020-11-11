package pattern.sigleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApplicationLogger {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationLogger.class);

    private static ApplicationLogger applicationLogger;

    public static ApplicationLogger getInstance() {
        if (applicationLogger == null) {
            synchronized (ApplicationLogger.class) {
                if (applicationLogger == null) {
                    applicationLogger = new ApplicationLogger();
                }
            }
        }
        return applicationLogger;
    }

    public void info(String message) {
        LOGGER.info(message);
    }

    public void debug(String message) {
        LOGGER.debug(message);
    }

    public void error(String message) {
        LOGGER.error(message);
    }

    public void error(String message, Throwable t) {
        LOGGER.error(message, t);
    }
}
