package com.honghei.gank.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * 日期工具类
 */
public class DateUtils {

    public static boolean isSameDate(Date date1, Date date2) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(date1);
        Calendar selectedDate = Calendar.getInstance();
        selectedDate.setTime(date2);

        return cal.get(Calendar.DAY_OF_YEAR) == selectedDate.get(Calendar.DAY_OF_YEAR);
    }

    /**
     * 将long类date转换为String类型
     * @param date date
     * @return String date
     */
    public static String ZhihuDailyDateFormat(long date) {
        String sDate;
        Date d = new Date(date);
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        sDate = format.format(d);

        return sDate;
    }

}
