package com.shangxiazuoyou.springrun.utils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

/**
 * 日期工具类
 *
 * @author shangxiazuoyou
 */
public class DateUtils {

    public static LocalDate getLastDayOfMonth(int year, int month) {
        // 创建一个表示给定年月的LocalDate对象
        LocalDate firstDayOfMonth = LocalDate.of(year, month, 1);
        // 使用TemporalAdjusters的lastDayOfMonth来获取当月的最后一天
        return firstDayOfMonth.with(TemporalAdjusters.lastDayOfMonth());
    }

    public static String getCurrentYear() {
        LocalDate today = LocalDate.now();
        return today.getYear() + "";
    }

    public static String getCurrentMonth() {
        LocalDate today = LocalDate.now();
        return today.getMonthValue() + "";
    }

    public static String getCurrentDate() {
        LocalDate today = LocalDate.now();
        return today.getDayOfMonth() + "";
    }

    public static LocalDate getLastDayOfCurrentMonth() {
        LocalDate today = LocalDate.now();
        int year = today.getYear();
        int month = today.getMonthValue();
        // 创建YearMonth对象
        YearMonth yearMonth = YearMonth.of(year, month);
        // 使用TemporalAdjusters.lastDayOfMonth获取该月份的最后一天
        return yearMonth.atEndOfMonth();
    }

    public static String getCurrentDay() {
        LocalDate today = LocalDate.now();
        return today.getYear() + "" + today.getMonthValue() + today.getDayOfMonth();
    }

    public static String generateWxDate() {
        OffsetDateTime now = OffsetDateTime.now(ZoneOffset.ofHours(8));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        return now.format(formatter);
    }

    public static Date getStartDateOfWeek() {
        LocalDate today = LocalDate.now();
        LocalDate startOfWeek = today.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
        return Date.from(startOfWeek.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date getEndDateOfWeek() {
        LocalDate today = LocalDate.now();
        LocalDate endOfWeek = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
        return Date.from(endOfWeek.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date calculateStartDate() {
        // 获取当前日期
        LocalDate today = LocalDate.now();
        // 倒推7天
        LocalDate startDate = today.minusDays(7);
        // 转换为Date对象
        return Date.from(startDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public static Date calculateEndDate() {
        // 获取当前日期
        LocalDate today = LocalDate.now();
        // 当前时间为截止时间，转换为Date对象
        return Date.from(today.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public static void main(String[] args) {
        // 获取今天的开始时间（00:00:00）
        LocalDateTime startOfDay = LocalDateTime.now().toLocalDate().atStartOfDay();
        // 获取当前时间
        LocalDateTime now = LocalDateTime.now();

        // 定义日期时间格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // 格式化日期时间
        String formattedStartOfDay = startOfDay.format(formatter);
        String formattedNow = now.format(formatter);

        // 输出结果
        System.out.println("今天的开始时间是: " + formattedStartOfDay);
        System.out.println("当前时间是: " + formattedNow);
    }

}
