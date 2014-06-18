package tonyb.java8.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import static java.util.Calendar.*;
import java.util.TimeZone;

public class DateTime {
    public static void main(String[] args) {

        final ZoneId TAHITI = ZoneId.of("Pacific/Tahiti");
        LocalDate today = LocalDate.parse("2014-06-13");
        LocalDate endOfTime = LocalDate.MAX;

        assert (today.isBefore(endOfTime));

        LocalDate machineSingularity = today.plus(2, ChronoUnit.DECADES);

        LocalDateTime now = LocalDateTime.now();

        ZonedDateTime timeInAMagicalPlace = now.atZone(TAHITI);

        Calendar builtCalendar =
                new Builder()
                        .set(YEAR, 2014)
                        .set(MONTH, JUNE)
                        .set(DAY_OF_MONTH, 13)
                        .setTimeZone(TimeZone.getTimeZone(TAHITI))
                        .set(HOUR, 9)
                        .set(MINUTE, 30)
                        .build();
    }
}
