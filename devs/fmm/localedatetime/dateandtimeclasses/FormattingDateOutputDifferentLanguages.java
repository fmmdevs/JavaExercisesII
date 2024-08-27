package devs.fmm.localedatetime.dateandtimeclasses;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class FormattingDateOutputDifferentLanguages {

    public static void main(String[] args) {
        LocalDate pirateDay = LocalDate.of(Year.now().getValue(), Month.SEPTEMBER, 19);
        System.out.println(pirateDay);
        System.out.printf("%s%n%n", pirateDay);

        System.out.println(pirateDay.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)));
        System.out.println(pirateDay.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)));
        System.out.println(pirateDay.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)));
        System.out.println(pirateDay.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
        System.out.println();
        System.out.println(pirateDay.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).withLocale(Locale.ENGLISH)));
        System.out.println(pirateDay.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(Locale.ENGLISH)));
        System.out.println(pirateDay.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).withLocale(Locale.ENGLISH)));
        System.out.println(pirateDay.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(Locale.ENGLISH)));
        System.out.println();
        System.out.println(pirateDay.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).withLocale(Locale.ITALIAN)));
        System.out.println(pirateDay.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(Locale.ITALIAN)));
        System.out.println(pirateDay.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).withLocale(Locale.ITALIAN)));
        System.out.println(pirateDay.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(Locale.ITALIAN)));


    }
}
