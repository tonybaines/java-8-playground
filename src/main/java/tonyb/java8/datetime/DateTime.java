package tonyb.java8.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class DateTime {
    public static void main(String[] args) {

        LocalDate today = LocalDate.parse("2014-06-13");
        LocalDate endOfTime = LocalDate.MAX;

        assert (today.isBefore(endOfTime));

        LocalDate machineSingularity = today.plus(2, ChronoUnit.DECADES);

        LocalDateTime now = LocalDateTime.now();

        ZonedDateTime timeInAMagicalPlace = now.atZone(ZoneId.of("Pacific/Tahiti"));

    }
}
