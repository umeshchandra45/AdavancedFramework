package com.Forsys.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    public String currentMnthFstDate() {
        Calendar cal = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        Date startdate = cal.getTime();
        String currentStrDate = dateFormat.format(startdate);
        System.out.println("Current month Start Date: " + currentStrDate);
        return currentStrDate;
    }

    public String currentMnthLstDate() {
        Calendar cal = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        Date lastdate = cal.getTime();
        String currentLstrDate = dateFormat.format(lastdate);
        System.out.println("Current month Last Date: " + currentLstrDate);
        return currentLstrDate;
    }

    public String currentFirstDateNextMonth(int nextMonth) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar today = Calendar.getInstance();
        Calendar next = Calendar.getInstance();
        next.clear();
        next.set(Calendar.YEAR, today.get(Calendar.YEAR));
        next.set(Calendar.MONTH, today.get(Calendar.MONTH) + nextMonth);
        next.set(Calendar.DAY_OF_MONTH, 1); // optional, default: 1, our need

        System.out.println("Current month Start Date: " + dateFormat.format(next.getTime()));
        return dateFormat.format(next.getTime());
    }

    public String currentLastDateNextMonth(int nextMonth) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar today = Calendar.getInstance();
        Calendar next = Calendar.getInstance();
        next.clear();
        next.set(Calendar.YEAR, today.get(Calendar.YEAR));
        next.set(Calendar.MONTH, today.get(Calendar.MONTH) + nextMonth);
        next.set(Calendar.DAY_OF_MONTH, next.getActualMaximum(Calendar.DATE)); // optional, default:
                                                                               // 1, our need

        System.out.println("Current month End Date: " + dateFormat.format(next.getTime()));
        return dateFormat.format(next.getTime());
    }

    public String prevMonthCurrDate() {
        Calendar cal = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        cal.add(Calendar.MONTH, -1);
        Date nextMonthFirstDay = cal.getTime();
        String nextMnthStrDate = dateFormat.format(nextMonthFirstDay);
        System.out.println("Previous month current Date: " + nextMnthStrDate);
        return nextMnthStrDate;
    }

    public String nextMnthFstDate() {
        Calendar cal = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        cal.add(Calendar.MONTH, 1);
        cal.set(Calendar.DATE, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        Date nextMonthFirstDay = cal.getTime();
        String nextMnthStrDate = dateFormat.format(nextMonthFirstDay);
        System.out.println("Next month Start Date: " + nextMnthStrDate);
        return nextMnthStrDate;
    }

    public java.sql.Date hubNextMnthFstDate() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, 1);
        c.set(Calendar.DATE, c.getActualMinimum(Calendar.DAY_OF_MONTH));
        java.sql.Date nxtMnth = new java.sql.Date(c.getTime().getTime());
        System.out.println(" HUB Next month Start Date: " + nxtMnth);
        return nxtMnth;
    }

    public java.sql.Date hubNextMnthLstDate() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, 1);
        c.set(Calendar.DATE, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        java.sql.Date nxtMnth = new java.sql.Date(c.getTime().getTime());
        System.out.println(" HUB Next month end Date: " + nxtMnth);
        return nxtMnth;
    }

    public java.sql.Date hubPrevMnthCurrDate() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, -1);
        // c.set(Calendar.DATE, c.getTime());
        java.sql.Date nxtMnth = new java.sql.Date(c.getTime().getTime());
        System.out.println(" HUB previous month current date: " + nxtMnth);
        return nxtMnth;
    }

    public java.sql.Date hubCurrMnthFstDate() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DATE, c.getActualMinimum(Calendar.DAY_OF_MONTH));
        java.sql.Date nxtMnth = new java.sql.Date(c.getTime().getTime());
        System.out.println(" HUB Next month Start Date: " + nxtMnth);
        return nxtMnth;
    }

    public java.sql.Date hubCurrMnthLstDate() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DATE, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        java.sql.Date nxtMnth = new java.sql.Date(c.getTime().getTime());
        System.out.println(" HUB Next month end Date: " + nxtMnth);
        return nxtMnth;
    }

    public java.sql.Date hubPrevMnthFstDate() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, -1);
        c.set(Calendar.DATE, c.getActualMinimum(Calendar.DAY_OF_MONTH));
        java.sql.Date nxtMnth = new java.sql.Date(c.getTime().getTime());
        System.out.println(" HUB previous month start date: " + nxtMnth);
        return nxtMnth;
    }

    public java.sql.Date hubPrevMnthLstDate() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, -1);
        c.set(Calendar.DATE, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        java.sql.Date nxtMnth = new java.sql.Date(c.getTime().getTime());
        System.out.println(" HUB previous month end date: " + nxtMnth);
        return nxtMnth;
    }

    public String currentMnthFirstDate() {
        Calendar cal = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        Date startdate = cal.getTime();
        String currentStrDate = dateFormat.format(startdate);
        System.out.println("Current month Start Date: " + currentStrDate);
        return currentStrDate;
    }

    public String currentMnthLastDate() {
        Calendar cal = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        Date lastdate = cal.getTime();
        String currentLstrDate = dateFormat.format(lastdate);
        System.out.println("Current month Last Date: " + currentLstrDate);
        return currentLstrDate;

    }

    public String prevMnthFstDate() {
        Calendar cal = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        cal.add(Calendar.MONTH, -1);
        cal.set(Calendar.DATE, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        Date nextMonthFirstDay = cal.getTime();
        String nextMnthStrDate = dateFormat.format(nextMonthFirstDay);
        System.out.println("Previous month Start Date: " + nextMnthStrDate);
        return nextMnthStrDate;
    }

    public String prevMnthLstDate() {
        Calendar cal = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        cal.add(Calendar.MONTH, -1);
        cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        Date nextMonthFirstDay = cal.getTime();
        String nextMnthStrDate = dateFormat.format(nextMonthFirstDay);
        System.out.println("Previous month Start Date: " + nextMnthStrDate);
        return nextMnthStrDate;
    }

    public String nextMnthFirstDate() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, 1);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        Date startdate = cal.getTime();
        String currentStrDate = dateFormat.format(startdate);
        System.out.println("Next month Start Date: " + currentStrDate);
        return currentStrDate;
    }

    public String nextMnthLastDate() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, 1);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        Date lastdate = cal.getTime();
        String currentLstrDate = dateFormat.format(lastdate);
        System.out.println("Next month Last Date: " + currentLstrDate);
        return currentLstrDate;

    }

    public java.sql.Date hubAprMnthFstDate() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, 3);
        c.set(Calendar.DATE, c.getActualMinimum(Calendar.DAY_OF_MONTH));
        java.sql.Date nxtMnth = new java.sql.Date(c.getTime().getTime());
        System.out.println(" HUB previous month start date: " + nxtMnth);
        return nxtMnth;
    }

    public java.sql.Date hubAprMnthLstDate() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, 3);
        c.set(Calendar.DATE, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        java.sql.Date nxtMnth = new java.sql.Date(c.getTime().getTime());
        System.out.println(" HUB previous month end date: " + nxtMnth);
        return nxtMnth;
    }
}
