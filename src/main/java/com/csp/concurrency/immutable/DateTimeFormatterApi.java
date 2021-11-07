package com.csp.concurrency.immutable;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @desc: 不可变且线程安全的时间Api：DateTimeFormatter
 * @author: csp52872
 * @date: 2021/11/6
 */
public class DateTimeFormatterApi {

    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        DateTimeFormatterApi dateTimeFormatterApi = new DateTimeFormatterApi();
        dateTimeFormatterApi.format();
        dateTimeFormatterApi.parse();
    }

    private void format() {
        LocalDateTime localDateTime = LocalDateTime.of(2021, 11, 6, 14, 23, 56);
        System.out.println(dateTimeFormatter.format(localDateTime));
    }

    private void parse() {
        String str = "2021-11-06 14:23:56";
        LocalDateTime localDateTime = LocalDateTime.parse(str, dateTimeFormatter);
        System.out.println(localDateTime);
    }
}
