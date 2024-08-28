package devs.fmm.localedatetime.dateandtimeclasses;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;

public class FindAllFridayThe13 {

    public static void main(String[] args) {

        int year = Integer.parseInt(JOptionPane.showInputDialog("Introduce the year and I'll tell you all the Fridays the 13th"));

        LocalDate theYear = LocalDate.ofYearDay(year, 1);

        for (int i = 1; i <= theYear.lengthOfYear(); i++) {
            if (theYear.withDayOfYear(i).getDayOfWeek().getValue() == 5 && theYear.withDayOfYear(i).getDayOfMonth() == 13) {
                System.out.println(i);
                System.out.println(theYear.withDayOfYear(i).format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
            }
        }

        NextFriday13 nextFriday13 = new NextFriday13();

        System.out.printf("The next friday the 13th is %s.",nextFriday13.adjustInto(theYear));


    }


}
