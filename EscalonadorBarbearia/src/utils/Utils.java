
package utils;

import org.joda.time.Instant;
import org.joda.time.format.DateTimeFormat;

public class Utils {

    private static WriteUtils writeUtils = new WriteUtils();

    public static String getStat(String msg) {
        msg = "[" + msg + "]";

        return String.format("%s\t", msg);
    }

    public static void log(final String... params) {

        String msg = "";

        for (final String param : params) {
            msg += getStat(param);
        }

        msg = "[" + formatTime(Instant.now()) + "] " + msg;

        System.out.println(msg);

        writeUtils.write(msg);
    }

    public static String formatTime(final Instant i) {
        final String format = "HH:mm:ss";
        return i.toString(DateTimeFormat.forPattern(format));
    }

}
