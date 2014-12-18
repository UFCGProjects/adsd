
package utils;

import org.joda.time.Instant;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * The Class WriteAnalysis.
 */
public class WriteUtils {

    private static String FILE_NAME_ANALYSIS;

    PrintWriter writerAnalysis;

    /**
     * Instantiates a new write analysis.
     *
     * @param algorithm the algorithm
     */
    public WriteUtils() {
        FILE_NAME_ANALYSIS = "adsd_escalonador_" + Utils.formatTime(Instant.now()) + ".txt";

        try {
            writerAnalysis = new PrintWriter(new BufferedWriter(new FileWriter(FILE_NAME_ANALYSIS,
                    true)));

        } catch (final FileNotFoundException e) {
            e.printStackTrace();
        } catch (final UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        writerAnalysis.close();
    }

    public void write(final String str) {
        writerAnalysis.println(str);
        writerAnalysis.flush();
    }
}
