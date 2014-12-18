
package utils;

import org.joda.time.Instant;
import org.joda.time.format.DateTimeFormat;

public class Utils {

    public static void log(final String msg) {
        System.out.println("[" + formatTime(Instant.now()) + "] " + msg);
    }

    public static String formatTime(final Instant i) {
        final String format = "HH:mm:ss";
        return i.toString(DateTimeFormat.forPattern(format));
    }

}
