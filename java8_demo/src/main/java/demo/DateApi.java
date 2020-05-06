package demo;

import sun.util.resources.LocaleData;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * Created by luwb on 2020/04/27.
 */
public class DateApi {

    public static void main(String[] args) {
        // LocalDate: 只有日期，不包括具体时间
        LocalDate today = LocalDate.now();
        System.out.println("today:"+today);
        // 获取今天日期：传统方式
        Date date = new Date();
        System.out.println("today:"+date);

        // 获取年、月、日
        int year = today.getYear();
        int monthValue = today.getMonthValue();
        int day = today.getDayOfMonth();
        System.out.printf("Year: %d Month: %d day: %d \n", year, monthValue, day);

        // 生成特定日期
        LocalDate date1 = LocalDate.of(2020, 4, 30);
        System.out.println("the special date is:" + date1);

        // 判断两个日期是否相等
        LocalDate today2 = LocalDate.now();
        LocalDate date2 = LocalDate.of(2020, 4, 30);
        System.out.println("are same date: "+today2.equals(date2));

        // 处理周期性的日期：如生日
        LocalDate dateOfBirth = LocalDate.of(1996, 10, 25);
        MonthDay birthday = MonthDay.of(dateOfBirth.getMonth(), dateOfBirth.getDayOfMonth());
        MonthDay currentMonthDay = MonthDay.from(today);
        if (currentMonthDay.equals(birthday)) {
            System.out.println("happy birthday!");
        } else {
            System.out.println("sorry.. today is not your birthday");
        }

        // 获取当前时间
        LocalTime time = LocalTime.now();
        System.out.println("local time now: " + time);

        // 增加两小时
        LocalTime newTime = time.plusHours(2);
        System.out.println("time after 2 hours: " + newTime);

        // 计算一周后的日期
        LocalDate nextWeek = today.plus(1, ChronoUnit.WEEKS);
        System.out.println("date after 1 week: " + nextWeek);

        // 计算一年前/一年后的日期
        LocalDate previousYear = today.minus(1, ChronoUnit.YEARS);
        System.out.println("date before 1 year: " + previousYear);
        LocalDate nextYear = today.plus(1, ChronoUnit.YEARS);
        System.out.println("date after 1 year: " + nextYear);

        // 判断日期的先后
        LocalDate tomorrow = LocalDate.of(2020, 5, 1);
        if (tomorrow.isAfter(today)) {
            System.out.println("tomorrow comes after today");
        }
        LocalDate yesterday = today.minusDays(1);
        if (yesterday.isBefore(today)) {
            System.out.println("yesterday is day before today ");
        }

        // 获取特定时区下的时间
        ZoneId america = ZoneId.of("Asia/Shanghai");
        LocalDateTime localDateTime = LocalDateTime.now();
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, america);
        System.out.println("在特定时区的日期与时间：" + zonedDateTime);

        // 使用YearMonth类处理特定日期
        YearMonth currentYearMonth = YearMonth.now();
        System.out.printf("days in month year %s: %d\n",currentYearMonth,currentYearMonth.lengthOfMonth());
        YearMonth creditCardExpiry = YearMonth.of(2028, Month.FEBRUARY);
        System.out.printf("your credit card expires on %s %n",creditCardExpiry);

        // 是否闰年
        if (today.isLeapYear()) {
            System.out.println("is leap year");
        } else {
            System.out.println("is not leap year");
        }

        // 计算两个日期间的天数和月数
        LocalDate java8Release = LocalDate.of(2018, 5, 14);
        Period period = Period.between(java8Release, today);
        System.out.println("months left between today and Java8 release: " + period.getMonths());

        // 日期格式化
        String dateStr = "20200430";
        LocalDate formatted = LocalDate.parse(dateStr, DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println("formatted: " + formatted);

    }

}
