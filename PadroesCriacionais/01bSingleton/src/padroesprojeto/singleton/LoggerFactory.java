/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package padroesprojeto.singleton;

import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author ana
 */
public class LoggerFactory {

    public boolean isFileLoggingEnabled() {
        Properties p = new Properties();
        try {
            p.load(ClassLoader.getSystemResourceAsStream(
                    "logger.properties"));
            String fileLoggingValue =
                    p.getProperty("FileLogging");
            if (fileLoggingValue.equalsIgnoreCase("ON") == true) {
                return true;
            } else {
                return false;
            }
        } catch (IOException e) {
            return false;
        }
    }
    //Factory Method
    public Logger getLogger() {
        if (isFileLoggingEnabled()) {
            return FileLogger.getFileLogger();
        } else {
            return new ConsoleLogger();
        }
    }
}
