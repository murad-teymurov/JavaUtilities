package org.example;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class DateUtilsTest {

    @Test
    public void getNextDayTest() {
        LocalDate date = DateUtils.getNextDay(LocalDate.now());
        System.out.println("Next Day :: " + date);
        assertNotNull(date);
    }

    @Test
    public void getPreviousDayTest() {
        System.out.println("Get Previous Day :: " + DateUtils.getPreviousDay(LocalDate.now()));
    }

    @Test
    public void getDayOfWeekTest() {
        System.out.println("Get Day Of Week :: " + DateUtils.getDayOfWeek(LocalDate.now()));
    }

    @Test
    public void getFirstDayOfMonthTest() {
        System.out.println("Get First day of Month :: " + DateUtils.getFirstDayOfMonth());
    }

    @Test
    public void getStartOfDayTest() {
        System.out.println("Get start of day :: " + DateUtils.getStartOfDay(LocalDate.now()));
    }

    @Test
    public void printCurrentDayMonthAndYearTest() {
        DateUtils.printCurrentDayMonthAndYear();
    }

    @Test
    public void checkDateEqualsTest() {
        assertTrue(DateUtils.checkDateEquals(LocalDate.now(), LocalDate.now()));
    }

    @Test
    public void getCurrentTime() {
        assertEquals(DateUtils.getCurrentTime(), LocalTime.now());
    }

    @Test
    public void addHoursToTime() {
        System.out.println("Added hours to time :: " + DateUtils.addHoursToTime(1));
    }

    @Test
    public void timeZoneTest() {
        System.out.println("Azerbaijan/Baku Zone :: " + DateUtils.timeZone("Asia/Baku"));
    }

    @Test
    public void leapYearTest() {
        System.out.println("Is current year leap :: " + DateUtils.checkLeapYear());
    }

    @Test
    public void getTimeStamp() {
        System.out.println("get time stamp ::" + DateUtils.getTimeStamp());
    }

    @Test
    public void getZonedDateTime() {
        System.out.println("" + DateUtils.getZonedDateTime(LocalDateTime.now(), ZoneId.of("Asia/Baku")));
    }

    @Test
    public void getDifferenceBetweenDates() {
        System.out.println("Difference between two dates :: "
                + DateUtils.getDifferenceBetweenDates(LocalTime.now(), LocalTime.now().plusHours(12)));
    }

    @Test
    public void convertDateToLocalDate() {
        System.out.println("Convert Date to LocalDate :: " + DateUtils.convertDateToLocalDate(new Date()));
    }

    @Test
    public void convertCalenderToLocalDateTest() {
        System.out.println("Convert Calender to LocalDate :: "
                + DateUtils.convertDateToLocalDate(Calendar.getInstance().getTime()));
    }
}
