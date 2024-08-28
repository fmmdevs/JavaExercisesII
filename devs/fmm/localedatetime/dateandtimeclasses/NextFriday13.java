package devs.fmm.localedatetime.dateandtimeclasses;

import java.time.LocalDate;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;

public class NextFriday13 implements TemporalAdjuster {
    @Override
    public Temporal adjustInto(Temporal temporal) {
        LocalDate date = LocalDate.from(temporal);

        for (int i = date.getDayOfYear(); i < date.lengthOfYear(); i++) {
            if (date.withDayOfYear(i).getDayOfMonth() == 13 && date.withDayOfYear(i).getDayOfWeek().getValue() == 5) {
                return date.withDayOfYear(i);
            }
        }
        return null;

    }
}
