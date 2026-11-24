package gr.ihu.omada12.crypto.view;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

// Υλοποιεί: APP-09 (μορφοποίηση για εμφάνιση)

/** Μορφοποίηση αριθμών, μεγεθών, ημερομηνιών και χρόνων για εμφάνιση στη διεπαφή. */
public final class Formats {
    private static final DateTimeFormatter DATE_TIME = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    private static final String[] UNITS = {"B", "KB", "MB", "GB"};

    private Formats() { }

    public static String size(long bytes) {
        double value = bytes;
        int unit = 0;
        while (value >= 1024 && unit < UNITS.length - 1) {
            value /= 1024;
            unit++;
        }
        return unit == 0 ? bytes + " B" : String.format(Locale.ROOT, "%.1f %s", value, UNITS[unit]);
    }

    public static String dateTime(LocalDateTime t) { return t == null ? "" : DATE_TIME.format(t); }

    public static String number(double value, int decimals) {
        return String.format(Locale.ROOT, "%." + decimals + "f", value);
    }


}
