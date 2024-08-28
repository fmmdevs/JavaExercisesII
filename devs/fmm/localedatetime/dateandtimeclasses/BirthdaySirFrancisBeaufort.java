package devs.fmm.localedatetime.dateandtimeclasses;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;

public class BirthdaySirFrancisBeaufort {

    public static void main(String[] args) {

        LocalDate beaufortBDay = LocalDate.of(1774, Month.MAY, 27);
        LocalDate nowadays = LocalDate.of(Year.now().getValue(), beaufortBDay.getMonth(), beaufortBDay.getDayOfMonth());

        System.out.printf("This year Francis celebrates his birthday on %s.", nowadays.getDayOfWeek().name().toLowerCase());
    }
}
