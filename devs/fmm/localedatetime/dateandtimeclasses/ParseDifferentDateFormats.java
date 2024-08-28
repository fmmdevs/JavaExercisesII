package devs.fmm.localedatetime.dateandtimeclasses;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseDifferentDateFormats {
    /*
     *  2025‐10‐10
     *  2025‐12‐2
     *  1/3/1976
     *  1/3/25
     *  Tomorrow
     *  Today
     *  Yesterday
     *  1 day ago
     *  2234 days ago*/
    static Optional<LocalDate> parseDate(String string) {

        //  2025‐10‐10 we don't know for sure if is yyyy-mm-dd or yyyy-dd-mm, I'm going to prioritize yyyy-mm-dd
        if (string.matches("(\\d{4})[-/]([0][0-9]|1[012])[-/]([0-3][0-9])")) {
            String regex = "(\\d{4})[-/]([01][0-9])[-/]([0-3][0-9])";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(string);
            if (matcher.find()) {
                //System.out.printf("%s %s %s", matcher.group(1), matcher.group(2), matcher.group(3));
                return Optional.of(LocalDate.of(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)), Integer.parseInt(matcher.group(3))));
            }
        }

        if (string.matches("(\\d{4})[-/]([0-3]?[0-9])[-/]([01]?[0-9])")) {
            String regex = "(\\d{4})[-/]([01]?[0-9])[-/]([0-3]?[0-9])";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(string);
            if (matcher.find()) {
                //System.out.printf("%s %s %s", matcher.group(1), matcher.group(3), matcher.group(2));
                return Optional.of(LocalDate.of(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(3)), Integer.parseInt(matcher.group(2))));
            }
        }

        // 1/3/25 dd/mm/yy
        // 10/10/10 we don't know for sure if is mm/dd/yy or dd/mm/yy, I'm going to prioritize mm/dd/yy

        if (string.matches("([0]?[0-9]|1[012])[-/]([0-3]?[0-9])[-/](\\d{2})")) {
            String regex = "([0]?[0-9]|1[012])[-/]([0-3]?[0-9])[-/](\\d{2})";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(string);
            if (matcher.find()) {
                //System.out.printf("%s %s %s", matcher.group(1), matcher.group(2), matcher.group(3));
                return Optional.of(LocalDate.of(Integer.parseInt("20"+matcher.group(3)), Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2))));
            }
        }

        if (string.matches("([0-3]?[0-9])[-/]([0]?[0-9]|1[012])[-/](\\d{2})")) {
            String regex = "([0-3]?[0-9])[-/]([0]?[0-9]|1[012])[-/](\\d{2})";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(string);
            if (matcher.find()) {
                //System.out.printf("%s %s %s", matcher.group(1), matcher.group(3), matcher.group(2));
                return Optional.of(LocalDate.of(Integer.parseInt("20"+matcher.group(3)), Integer.parseInt(matcher.group(2)), Integer.parseInt(matcher.group(1))));
            }
        }

        if (string.equalsIgnoreCase("Tomorrow")) return Optional.of(LocalDate.now().plusDays(1));
        if (string.equalsIgnoreCase("Yesterday") || string.equalsIgnoreCase("1 day ago"))
            return Optional.of(LocalDate.now().minusDays(1));
        if (string.equalsIgnoreCase("Today")) return Optional.of(LocalDate.now());

        if (string.contains("days ago")) {
            String regex = "\\d+";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(string);
            if (matcher.find()) {
                //System.out.println(matcher.group());
                return Optional.of(LocalDate.now().minusDays(Integer.parseInt(matcher.group())));
            }
        }
        return Optional.empty();
    }

    public static void main(String[] args) {
        System.out.println(parseDate("12 days ago").get().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));

        System.out.println(parseDate("1232-12-12").get().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
        System.out.println(parseDate("1232/12/12").get().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
        System.out.println();
        System.out.println(parseDate("1232/15/12").get().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
        System.out.println(parseDate("1232/12/15").get().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));

        System.out.println(parseDate("1/3/34").get().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
        System.out.println(parseDate("13/3/34").get().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
        System.out.println(parseDate("13/12/34").get().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
        System.out.println(parseDate("12/13/34").get().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));


    }
}
