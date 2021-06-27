package com.praveen10.learn.java.LowLevelDesign.parkinglot;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    static boolean isWeekend(Date date){

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        return dayOfWeek == 1 || dayOfWeek == 7;
    }

    static boolean isWeekday(Date date){
        return !isWeekend(date);
    }

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(new Date().getTime() - (1000 * 60 * 60 * 24)));
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
    }
}
