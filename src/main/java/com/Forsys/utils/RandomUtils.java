
package com.Forsys.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.RandomStringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.google.common.base.CharMatcher;

public class RandomUtils {

    /**
     * Generates random Number.
     * 
     * @param length length of random number to be generated
     */
    public static String randomInteger(Integer length) {
        return RandomStringUtils.randomNumeric(length);
    }

    /**
     * Generates random String.
     * 
     * @param length length of random characters to be generated
     */
    public static String randomString(Integer length) {
        return RandomStringUtils.random(length, true, false);
    }

    /**
     * Generates random alphanumeric String.
     * 
     * @param length length of random alphanumeric characters to be generated
     */
    public static String randomAlphanumeric(Integer length) {
        return RandomStringUtils.randomAlphanumeric(length);
    }

    /**
     * Generates random alphabetic String.
     * 
     * @param length length of random alphabetic characters to be generated
     */
    public static String randomAlphabetic(Integer length) {
        return RandomStringUtils.randomAlphabetic(length);
    }

    /**
     * Generates random UUID.
     * 
     * @param length length of random alphabetic characters to be generated
     */
    public static UUID randomUUID() {
        return UUID.randomUUID();
    }

    /**
     * Generates random emailaddress for @example.com domain in lower case
     * 
     * @param length length of random alphanumeric characters to be generated for the local part of
     *        email address
     */
    public static String randomEmailAddress(Integer length) {
        String email = randomAlphanumeric(length) + "@example.com";
        return email.toLowerCase();
    }

    public static DateTime randomAdultsDOB() {
        DateTime dateTime = new DateTime();
        dateTime = dateTime.minusYears((int) (18 + (Math.random() * ((50 - 18) + 1))));
        return dateTime.minusYears((int) (18 + (Math.random() * ((50 - 18) + 1))));
    }

    public static String formatDate(DateTime dateTime, String dateformat) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(dateformat);
        return dateTime.toString(dateTimeFormatter);
    }

    public static DateTimeFormatter dateFormatterWithLocale(Locale locale) {
        return DateTimeFormat.mediumDate().withLocale(locale);
    }

    public static String dateWithNoLeadingZero(String dateWithLeadingZero) {
        String dateWithNoLeadingZero;
        dateWithNoLeadingZero = CharMatcher.is('0').trimLeadingFrom(dateWithLeadingZero);
        return dateWithNoLeadingZero;
    }

    public static String randomFutureFormattedDate(String dateformat) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(dateformat);
        DateTime dateTime = new DateTime();
        final DateTime plusYears = dateTime.plusYears((int) (1 + Math.random() * (10 - 1)));
        return plusYears.toString(dateTimeFormatter);
    }

    public static String randomAsciiCharacters(Integer characterAmount) {
        return RandomStringUtils.random(characterAmount, 32, 127, false, false);
    }

    public static String replaceURLParams(String strURL, Map<String, String> params) {
        Pattern p = Pattern.compile("(\\{.*?\\})");
        Matcher m = p.matcher(strURL);
        while (m.find()) {
            String val1 = m.group().replace("{", "").replace("}", "");
            strURL = (strURL.replace(m.group(), params.get(val1)));
        }
        return strURL;
    }

    public String todayDate(String dateformat) {
        SimpleDateFormat df = new SimpleDateFormat(dateformat);
        String formatted = df.format(new Date());
        return formatted;
    }

    public String forwardYearDate() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, 1);
        cal.add(Calendar.DATE, -1);
        SimpleDateFormat format1 = new SimpleDateFormat("MM/dd/yyyy");
        String formatted = format1.format(cal.getTime());
        return formatted;
    }

    public String forwardYearMonthDate(int lessdate, int lessMonth, int forwardYear) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, lessdate);
        cal.add(Calendar.MONTH, lessMonth);
        cal.add(Calendar.YEAR, forwardYear);
        SimpleDateFormat format1 = new SimpleDateFormat("MM/dd/yyyy");
        String formatted = format1.format(cal.getTime());
        return formatted;
    }
}
