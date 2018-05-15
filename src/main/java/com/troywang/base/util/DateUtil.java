package com.troywang.base.util;

import static org.apache.commons.lang3.time.DateUtils.truncate;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.springframework.util.Assert;

/**
 * Created by troywang on 2018/5/15.
 */
public class DateUtil {

    public static final String SHORT_FORMAT = "yyyyMMdd";

    public static final String LONG_FORMAT = "yyyyMMddHHmmss";

    public static final String WEB_FORMAT = "yyyy-MM-dd";

    public static final String TIME_FORMAT = "HHmmss";

    public static final String MONTH_FORMAT = "yyyyMM";

    public static final String CHINA_FORMAT = "yyyy年MM月dd日";

    public static final String LONG_WEB_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static final String LONG_WEB_FORMAT_NO_SEC = "yyyy-MM-dd HH:mm";

    private static SimpleDateFormat dateFormat = null;

    static {
        // 指定日期格式为四位年/两位月份/两位日期，注意yyyy/MM/dd区分大小写；
        dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        // 设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
        dateFormat.setLenient(false);
    }

    /**
     * 检查日期格式是否正确
     *
     * @param s
     *
     * @return
     *
     * @Author wangzhijian02
     */
    public static boolean isValidDate(String s, String format) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(format);
            dateFormat.parse(s);
            return true;
        } catch (Exception e) {
            // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
            return false;
        }
    }

    public static boolean isValidDate(String s) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
            format.parse(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // 下面这个方法则可以将一个日期按照你指定的格式输出
    public static String formatDate(Date d) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        return format.format(d);
    }

    /**
     * 日期增加
     *
     * @param start   开始时间
     * @param minutes 分钟数
     *
     * @return
     */
    public static Date minusMinutes(Date start, int minutes) {
        DateTime newDate = new DateTime(start).minusMinutes(minutes);
        return newDate.toDate();
    }

    /**
     * 日期增加,用秒
     */
    public static Date minusSeconds(Date start, int seconds) {
        DateTime newDate = new DateTime(start).minusSeconds(seconds);
        return newDate.toDate();
    }

    /**
     * 日期对象解析成日期字符串基础方法，可以据此封装出多种便捷的方法直接使用
     *
     * @param date   待格式化的日期对象
     * @param format 输出的格式
     *
     * @return 格式化的字符串
     */
    public static String format(Date date, String format) {
        if (date == null || StringUtils.isBlank(format)) {
            return StringUtils.EMPTY;
        }
        return new DateTime(date).toString(format, Locale.SIMPLIFIED_CHINESE);
    }

    /**
     * 日期字符串格式化基础方法，可以在此封装出多种便捷的方法直接使用
     *
     * @param dateStr   日期字符串
     * @param formatIn  输入的日期字符串的格式
     * @param formatOut 输出日期字符串的格式
     *
     * @return 已经格式化的字符串
     *
     * @throws java.text.ParseException
     */
    public static String format(String dateStr, String formatIn, String formatOut) throws IllegalArgumentException {
        Date date = parse(dateStr, formatIn);
        return format(date, formatOut);
    }

    /**
     * 格式化当前时间
     *
     * @param format 输出的格式
     *
     * @return
     */
    public static String formatCurrent(String format) {
        if (StringUtils.isBlank(format)) {
            return StringUtils.EMPTY;
        }
        return new DateTime().toString(format, Locale.SIMPLIFIED_CHINESE);
    }

    /**
     * 日期字符串解析成日期对象基础方法，可以在此封装出多种便捷的方法直接使用
     *
     * @param dateStr 日期字符串
     * @param format  输入的格式
     *
     * @return 日期对象
     *
     * @throws java.text.ParseException
     */
    public static Date parse(String dateStr, String format) throws IllegalArgumentException {
        if (StringUtils.isBlank(dateStr)) {
            return null;
        }
        return DateTimeFormat.forPattern(format).withLocale(Locale.SIMPLIFIED_CHINESE).parseDateTime(dateStr).toDate();
    }

    /**
     * 日期字符串解析成日期对象基础方法，可以在此封装出多种便捷的方法直接使用
     *
     * @param dateStr 日期字符串
     *
     * @return 日期对象
     *
     * @throws java.text.ParseException
     */
    public static Date parseLongFormat(String dateStr) throws IllegalArgumentException {
        int formatLength = StringUtils.length(DateUtil.LONG_FORMAT);
        dateStr = StringUtils.rightPad(dateStr, formatLength, "0");
        return parse(dateStr, LONG_FORMAT);
    }

    /**
     * 把日期对象按照<code>yyyyMMdd</code>格式解析成字符串
     *
     * @param date 待格式化的日期对象
     *
     * @return 格式化的字符串
     */
    public static String formatShort(Date date) {
        return format(date, SHORT_FORMAT);
    }

    /**
     * 把日期字符串按照<code>yyyyMMdd</code>格式，进行格式化
     *
     * @param dateStr  待格式化的日期字符串
     * @param formatIn 输入的日期字符串的格式
     *
     * @return 格式化的字符串
     */
    public static String formatShort(String dateStr, String formatIn) throws IllegalArgumentException {
        return format(dateStr, formatIn, SHORT_FORMAT);
    }

    /**
     * 把日期对象按照<code>yyyy-MM-dd</code>格式解析成字符串
     *
     * @param date 待格式化的日期对象
     *
     * @return 格式化的字符串
     */
    public static String formatWeb(Date date) {
        return format(date, WEB_FORMAT);
    }

    /**
     * 把日期字符串按照<code>yyyy-MM-dd</code>格式，进行格式化
     *
     * @param dateStr  待格式化的日期字符串
     * @param formatIn 输入的日期字符串的格式
     *
     * @return 格式化的字符串
     *
     * @throws java.text.ParseException
     */
    public static String formatWeb(String dateStr, String formatIn) throws IllegalArgumentException {
        return format(dateStr, formatIn, WEB_FORMAT);
    }

    /**
     * 把日期对象按照<code>yyyyMM</code>格式解析成字符串
     *
     * @param date 待格式化的日期对象
     *
     * @return 格式化的字符串
     */
    public static String formatMonth(Date date) {

        return format(date, MONTH_FORMAT);
    }

    /**
     * 把日期对象按照<code>HHmmss</code>格式解析成字符串
     *
     * @param date 待格式化的日期对象
     *
     * @return 格式化的字符串
     */
    public static String formatTime(Date date) {
        return format(date, TIME_FORMAT);
    }

    /**
     * 获取yyyyMMddHHmmss+n位随机数格式的时间戳
     *
     * @return
     */
    public static String getTimestamp() {
        return formatCurrent(LONG_FORMAT);
    }

    /**
     * 根据日期格式返回昨日日期
     *
     * @param format
     *
     * @return
     */
    public static String getYesterdayDate(String format) {
        return format(DateTime.now().minusDays(1).toDate(), format);
    }

    /**
     * 验证是否超过设定时间(${checkDate}),${minutes} 分钟
     * <p>
     * 验证是否超过设定时间(${checkDate}),${minutes} 分钟
     * <li>例如：overMinutes(2014-08-06 21:39:00, 15) ，当前时间是否为 2014-08-06 21:54:00之后</li>
     * </p>
     *
     * @param settingDate
     * @param minutes
     *
     * @return
     */
    public static boolean overMinutes(Date settingDate, int minutes) {
        // 系统当前时间
        settingDate = truncate(settingDate, Calendar.MINUTE);
        Date date = truncate(minusMinutes(new Date(), minutes), Calendar.MINUTE);
        return date.getTime() - settingDate.getTime() > 0;
    }

    public static boolean overSeconds(Date settingDate, int seconds) {
        settingDate = truncate(settingDate, Calendar.SECOND);
        Date date = truncate(minusSeconds(new Date(), seconds), Calendar.SECOND);
        return date.getTime() - settingDate.getTime() > 0;
    }

    public static int daysBetweenTwoDate(Date startDate, Date endDate) {
        Calendar calst = Calendar.getInstance();
        Calendar caled = Calendar.getInstance();
        calst.setTime(startDate);
        caled.setTime(endDate);
        // 设置时间为0时
        calst.set(Calendar.HOUR_OF_DAY, 0);
        calst.set(Calendar.MINUTE, 0);
        calst.set(Calendar.SECOND, 0);
        caled.set(Calendar.HOUR_OF_DAY, 0);
        caled.set(Calendar.MINUTE, 0);
        caled.set(Calendar.SECOND, 0);
        // 得到两个日期相差的天数
        int days = ((int) (caled.getTime().getTime() / 1000) - (int) (calst.getTime().getTime() / 1000)) / 3600 / 24;
        return days;
    }

    public static Date addDays(Date now, Integer days) {
        Date targetDate = null;
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(now);
        // 把日期往后增加一天.整数往后推,负数往前移动
        calendar.add(calendar.DATE, days);
        // 这个时间就是日期往后推一天的结果
        targetDate = calendar.getTime();
        return targetDate;
    }

    /**
     * 判断日期date1是否在日期date2后面(判断年月日和时分秒)
     *
     * @param date1,date2
     *
     * @return boolean
     */
    public static boolean isAfterInSecond(Date date1, Date date2) {
        Assert.notNull(date1, "比较日期不能为空");
        Assert.notNull(date2, "比较日期不能为空");
        String date1Str = format(date1, LONG_FORMAT);
        String date2Str = format(date2, LONG_FORMAT);

        date1 = parse(date1Str, LONG_FORMAT);
        date2 = parse(date2Str, LONG_FORMAT);

        return new DateTime(date1).getMillis() > new DateTime(date2).getMillis();
    }

    /**
     * 判断日期date1是否在日期date2后面(判断年月日和时分秒)
     *
     * @param date1,date2
     *
     * @return boolean
     */
    public static boolean isBeforeInSecond(Date date1, Date date2) {
        Assert.notNull(date1, "比较日期不能为空");
        Assert.notNull(date2, "比较日期不能为空");
        String date1Str = format(date1, LONG_FORMAT);
        String date2Str = format(date2, LONG_FORMAT);

        date1 = parse(date1Str, LONG_FORMAT);
        date2 = parse(date2Str, LONG_FORMAT);

        return new DateTime(date1).getMillis() < new DateTime(date2).getMillis();
    }

    /**
     * 取特定日期的00:00:00
     */
    public static Date getDateStart(Date date) {
        // 这样能够取到59分59秒
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 取特定日期的23:59:59
     */
    public static Date getDateEnd(Date date) {
        if (null == date) {
            return null;
        }
        // 这样能够取到59分59秒
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 增加天数
     *
     * @param start
     * @param days
     *
     * @return
     */
    public static Date plusDays(Date start, int days) {
        DateTime newDate = new DateTime(start).plusDays(days);
        return newDate.toDate();
    }

    public static boolean isLargeTime(Date startTime, Date endTimes) {
        return startTime.getTime() < endTimes.getTime();
    }
}
