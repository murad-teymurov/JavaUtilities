package org.example;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public final class DateUtils {
    private DateUtils() {
        throw new IllegalStateException("DateUtils is a utility class and can't be instantiated");
    }

    /**
     * Returns the local date time in default format.
     *
     * @return - current local date and time.
     */
    public static LocalDateTime getCurrentDateTime() {
        return LocalDateTime.now();
    }

    /**
     * Returns the local date in default format.
     *
     * @return - current local date.
     */
    public static LocalDate getCurrentDate() {
        return LocalDate.now();
    }

    /**
     * Validates the given String for a given date time format.
     *
     * @param dateString    - Date string to be validated
     * @param dateFormatter - Date time format to be used for validation
     * @return boolean - true if valid date else false
     */
    public static boolean isValidDateString(String dateString, DateTimeFormatter dateFormatter) {
        try {
            LocalDate.parse(dateString, dateFormatter);
        } catch (DateTimeParseException e) {
            System.out.println("DateUtils | isValidDateString | Exception: " + e);
            return false;
        }
        return true;
    }

    /**
     * Returns the current local date time in the provided format.
     *
     * @param dateTimeFormatter - required date and/or time format
     * @return String - formatted date and/or time.
     */
    public static String getFormattedCurrentDateTime(DateTimeFormatter dateTimeFormatter) {
        LocalDateTime localDateTime = LocalDateTime.now();
        return dateTimeFormatter.format(localDateTime);
    }

    /**
     * Converts the given date into given format and returns the value as String
     * type.
     *
     * @param dateToBeFormatted - Date
     * @param format            - String
     * @return date - String
     */
    public static String dateToString(Date dateToBeFormatted, String format) {
        return new SimpleDateFormat(format, Locale.ROOT).format(dateToBeFormatted);
    }

    /**
     * Get next day.
     *
     * @param localDate
     * @return
     */
    public static LocalDate getNextDay(LocalDate localDate) {
        return localDate.plusDays(1);
    }

    /**
     * Get Previous Day.
     *
     * @param localDate
     * @return
     */
    public static LocalDate getPreviousDay(LocalDate localDate) {
        return localDate.minus(1, ChronoUnit.DAYS);
    }

    /**
     * Get day of the week.
     *
     * @param localDate
     * @return
     */
    public static DayOfWeek getDayOfWeek(LocalDate localDate) {
        return localDate.getDayOfWeek();
    }

    /**
     * Get first day of the Month.
     *
     * @return LocalDate
     */
    public static LocalDate getFirstDayOfMonth() {
        return LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
    }

    /**
     * Get start of the Day.
     *
     * @param localDate
     * @return
     */
    public static LocalDateTime getStartOfDay(LocalDate localDate) {
        return localDate.atStartOfDay();
    }

    /**
     * Print current time in day,month and year format.
     */
    public static void printCurrentDayMonthAndYear() {
        LocalDate today = LocalDate.now();
        int year = today.getYear();
        int month = today.getMonthValue();
        int day = today.getDayOfMonth();
        System.out.printf("Year : %d Month : %d day : %d \t %n", year, month, day);
    }

    /**
     * Check two dates are equals.
     *
     * @param date
     * @param today
     * @return
     */
    public static boolean checkDateEquals(LocalDate date, LocalDate today) {
        if (date.equals(today)) {
            System.out.printf("Today %s and date1 %s are same date %n", today, date);
            return true;
        }
        return false;
    }

    /**
     * Get current time.
     *
     * @return
     */
    public static LocalTime getCurrentTime() {
        LocalTime time = LocalTime.now();
        System.out.println("local time now : " + time);
        return time;
    }

    /**
     * Add hours to time.
     *
     * @param hours
     * @return
     */
    public static LocalTime addHoursToTime(int hours) {
        LocalTime time = LocalTime.now();
        LocalTime newTime = time.plusHours(hours); // adding two hours
        System.out.println("Time after 2 hours : " + newTime);
        return newTime;
    }

    /**
     * Get date and time by zone.
     *
     * @param timeZone
     * @return
     */
    public static ZonedDateTime timeZone(String timeZone) {
        ZoneId america = ZoneId.of(timeZone);
        LocalDateTime localtDateAndTime = LocalDateTime.now();
        ZonedDateTime dateAndTimeInNewYork = ZonedDateTime.of(localtDateAndTime, america);
        System.out.println("Current date and time in a particular timezone : " + dateAndTimeInNewYork);
        return dateAndTimeInNewYork;
    }

    /**
     * Check for leap year.
     */
    public static boolean checkLeapYear() {
        LocalDate today = LocalDate.now();
        if (today.isLeapYear()) {
            System.out.println("This year is Leap year");
        } else {
            System.out.println("current year is not a Leap year");
        }
        return today.isLeapYear();
    }

    /**
     * get time stamp.
     *
     * @return
     */
    public static Instant getTimeStamp() {
        Instant timestamp = Instant.now();
        System.out.println("What is value of this instant " + timestamp);
        return timestamp;
    }

    /**
     * Get Date by hour,minute and seconds.
     *
     * @param hour
     * @param min
     * @param seconds
     * @return
     */
    public static LocalTime getLocalTimeUsingFactoryOfMethod(int hour, int min, int seconds) {
        return LocalTime.of(hour, min, seconds);
    }

    /**
     * Get zone date time.
     *
     * @param localDateTime
     * @param zoneId
     * @return
     */
    public static ZonedDateTime getZonedDateTime(LocalDateTime localDateTime, ZoneId zoneId) {
        return ZonedDateTime.of(localDateTime, zoneId);
    }

    /**
     * Returns a copy of this time with the specified amount added.
     *
     * @param localTime
     * @param duration
     * @return
     */
    public static LocalTime modifyDates(LocalTime localTime, Duration duration) {
        return localTime.plus(duration);
    }

    /**
     * Obtains a Duration representing the duration between two temporal objects.
     *
     * @param localTime1
     * @param localTime2
     * @return
     */
    public static Duration getDifferenceBetweenDates(LocalTime localTime1, LocalTime localTime2) {
        return Duration.between(localTime1, localTime2);
    }

    /**
     * Convert Date to Java 8 LocalDate
     *
     * @param date
     * @return
     */
    public static LocalDateTime convertDateToLocalDate(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    /**
     * Convert Calender to LocalDate
     *
     * @param calendar
     * @return
     */
    public static LocalDateTime convertDateToLocalDate(Calendar calendar) {
        return LocalDateTime.ofInstant(calendar.toInstant(), ZoneId.systemDefault());
    }
}
