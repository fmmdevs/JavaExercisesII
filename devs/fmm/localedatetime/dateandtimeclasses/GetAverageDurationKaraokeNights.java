package devs.fmm.localedatetime.dateandtimeclasses;

import java.sql.SQLOutput;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetAverageDurationKaraokeNights {

    static Duration averageDuration(String durations) {
        String regexDate = "\\d\\d\\d\\d-\\d\\d-\\d\\d";
        String regexTime = "\\d\\d:\\d\\d";

        Pattern patternDate = Pattern.compile(regexDate);
        Matcher matcherDate = patternDate.matcher(durations);

        Pattern patternTime = Pattern.compile(regexTime);
        Matcher matcherTime = patternTime.matcher(durations);

        List<LocalDateTime> karaokeDateTime = new ArrayList<>();

        while (matcherDate.find() && matcherTime.find()) {
            System.out.printf("String : %s %s%n", matcherDate.group(), matcherTime.group());
            LocalDateTime dateTime = LocalDateTime.of(LocalDate.parse(matcherDate.group()), LocalTime.parse(matcherTime.group()));
            System.out.printf("LocalDateTime : %s%n%n", dateTime);
            karaokeDateTime.add(dateTime);
        }

        long sum = 0;
        int count = 0;
        for (int i = 0; i < karaokeDateTime.size() - 1; i += 2) {
            System.out.printf("Duration between %s and %s is %s%n%n", karaokeDateTime.get(i), karaokeDateTime.get(i + 1), Duration.between(karaokeDateTime.get(i), karaokeDateTime.get(i + 1)));
            sum += Duration.between(karaokeDateTime.get(i), karaokeDateTime.get(i + 1)).toSeconds();
            count++;
        }


        System.out.printf("The Average Duration of a Karaoke Night is %s", Duration.of(sum / count, ChronoUnit.SECONDS));
        return Duration.of(sum / count, ChronoUnit.SECONDS);
    }

    public static void main(String[] args) {
        String durations = "2025-03-12, 20:20 - 2025-03-12, 23:50\n" +
                "2025-04-01, 21:30 - 2025-04-02, 01:20";

        String durations1 = "2025-03-12, 20:20 - 2025-03-12, 23:50\n" +
                "2025-04-15, 19:30 - 2025-04-15, 22:00\n" +
                "2025-05-18, 21:00 - 2025-05-18, 23:45\n" +
                "2025-06-10, 18:45 - 2025-06-10, 23:30\n" +
                "2025-07-22, 20:15 - 2025-07-22, 23:55\n" +
                "2025-08-05, 19:50 - 2025-08-05, 23:20\n" +
                "2025-09-14, 21:10 - 2025-09-14, 23:40\n" +
                "2025-10-02, 18:30 - 2025-10-02, 22:30\n" +
                "2025-11-09, 20:00 - 2025-11-09, 23:15\n" +
                "2025-12-25, 19:00 - 2025-12-25, 23:00\n";

        averageDuration(durations);
        System.out.println("------------------------------");
        averageDuration(durations1);
    }
}
