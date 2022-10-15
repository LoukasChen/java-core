package com.csp.java8.time;

import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

/**
 * @author csp
 * @date 2022/10/4
 */
public class LocalDateApi {

    public static void main(String[] args) {
        localDate();
        localTime();
    }

    private static void localDate() {
        // LocalDate 年月日
        LocalDate localDate = LocalDate.of(2022, 10, 4);
        System.out.println(localDate.getYear());
        System.out.println(localDate.getMonthValue());
        System.out.println(localDate.getDayOfMonth());
        System.out.println(localDate.get(ChronoField.YEAR));
        System.out.println(localDate.get(ChronoField.MONTH_OF_YEAR));
        System.out.println(localDate.get(ChronoField.DAY_OF_MONTH));

        LocalDate now = LocalDate.now();
        System.out.println(now);

        System.out.println(LocalDate.parse("2022-10-12"));
    }

    private static void localTime() {
        // LocalTime 时分秒
        LocalTime localTime = LocalTime.of(12, 17, 56);
        System.out.println(localTime.getHour());
        System.out.println(localTime.getMinute());
        System.out.println(localTime.getSecond());

        System.out.println(LocalTime.parse("13:23:45"));
    }

    private static void localDateTime() {
        LocalDateTime dt1 = LocalDateTime.of(2022, Month.OCTOBER, 10, 16, 32);
        LocalDate localDate = dt1.toLocalDate();
        LocalTime localTime = dt1.toLocalTime();
        LocalDateTime dt2 = LocalDateTime.of(localDate, localTime);
        LocalDateTime dt3 = localDate.atTime(localTime);
        LocalDateTime dt4 = localDate.atTime(13, 45, 23);
        LocalDateTime dt5 = localTime.atDate(localDate);
    }

    private static void duration() {
        Duration duration = Duration.between(LocalTime.now(), LocalTime.now());
        System.out.println(duration);
        Duration duration1 = Duration.ofMinutes(3);
        Duration duration2 = Duration.of(3, ChronoUnit.MINUTES);
    }

    private static void period() {
        Period period = Period.between(LocalDate.of(2017, 9, 11), LocalDate.of(2017, 9, 21));
        System.out.println(period);

        Period period1 = Period.ofDays(3);
        Period period2 = Period.ofWeeks(3);
        Period period3 = Period.of(2, 6, 1);
    }

    private static void withAttribute() {
        LocalTime localTime = LocalTime.now();
        LocalTime localTime1 = localTime.withHour(1);
    }
}
