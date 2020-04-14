package com.lietou.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

/**
 * 时间格式化工具
 */
public class DateFormatUtil {

    public static final String FORMAT_YYYY_MM_DD_WITH_LINE = "yyyy-MM-dd";
    public static final String FORMAT_YYYY_MM_DD_WITH_ZH = "yyyy年MM月dd日";
    public static final String FORMAT_YYYY_MM_DD_WITH_SLASH = "yyyy/MM/dd";
    public static final String FORMAT_YYYY_MM_DD_SS = "yyyy-MM-dd HH:mm:ss";
    public static final String FORMAT_YYYY_MM_DD_HH_mm = "yyyy-MM-dd HH:mm";
    public static final String FORMAT_YYYY_MM_DD_SS_NO_SPACE = "yyyyMMddHHmmss";
    public static final String FORMAT_YYYY_MM_DD_NO_SPACE = "yyyyMMdd";
    public static final String FORMAT_YYYY_MM_DD_NO_SPACE_HH_mm = "yyyyMMdd HH:mm";
    public static final String FORMAT_YYYY_MM_DD_SS_WITH_LINE = "yyyy.MM.dd HH:mm:ss";
    public static final String FORMAT_HH_MM_SS = "HH:mm:ss";
    public static final String FORMAT_HH_MM = "HH:mm";
    /**
     * yyyy.MM.dd
     */
    public static final String FORMAT_YYYY_MM_DD_WITH_POINT = "yyyy.MM.dd";
    public static final String FORMAT_YYYY_MM_WITH_LINE = "yyyy-MM";
    public static final String FORMAT_MM_DD_WITH_POINT = "MM.dd";

    /**
     *
     */
    public static final Map<String, Integer> WEEKDAYSTRMAP;

    static {
        WEEKDAYSTRMAP = new HashMap<String, Integer>();
        WEEKDAYSTRMAP.put("周日", 1);
        WEEKDAYSTRMAP.put("周一", 2);
        WEEKDAYSTRMAP.put("周二", 3);
        WEEKDAYSTRMAP.put("周三", 4);
        WEEKDAYSTRMAP.put("周四", 5);
        WEEKDAYSTRMAP.put("周五", 6);
        WEEKDAYSTRMAP.put("周六", 7);
    }

	public static String getDBNowDate() {
		return new SimpleDateFormat("yyyyMMdd").format(new Date());
	}
	
	public static String getDBNowDateTime() {
		return date2String(new Date(), FORMAT_YYYY_MM_DD_SS_NO_SPACE);
	}
	
    /**
     * 格式化输出日期
     *
     * @param date   日期
     * @param format 格式
     * @return 返回字符型日期
     */
    public static String date2String(java.util.Date date, String format) {
        String result = "";
        try {
            if (date != null) {
                java.text.DateFormat df = new java.text.SimpleDateFormat(format);
                result = df.format(date);
            }
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return result;
    }

    /**
     * 返回毫秒
     *
     * @param date 日期
     * @return 返回毫秒
     */
    public static long getMillis(java.util.Date date) {
        java.util.Calendar c = java.util.Calendar.getInstance();
        c.setTime(date);
        return c.getTimeInMillis();
    }

    /**
     * 格式化日期
     *
     * @param dateStr 字符型日期
     * @param format  格式
     * @return 返回日期
     */
    public static java.util.Date string2Date(String dateStr, String format) {
        java.util.Date date = null;
        if (StringUtils.isBlank(dateStr)) {
            return date;
        }
        try {
            java.text.DateFormat df = new java.text.SimpleDateFormat(format);
            String dt = dateStr.replaceAll("/", "-");
            /*if ((!dt.equals("")) && (dt.length() < format.length())) {
                dt += format.substring(dt.length()).replaceAll("[YyMmDdHhSs]", "0");
            }*/
            date = df.parse(dt);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 返回年份
     *
     * @param date 日期
     * @return 返回年份
     */
    public static int getYear(java.util.Date date) {
        java.util.Calendar c = java.util.Calendar.getInstance();
        c.setTime(date);
        return c.get(java.util.Calendar.YEAR);
    }

    /**
     * 返回季度
     *
     * @param date
     * @return
     */
    public static int getQuarter(Date date) {
        java.util.Calendar c = java.util.Calendar.getInstance();
        c.setTime(date);
        int month = c.get(java.util.Calendar.MONTH) + 1;
        switch (month) {
            case 1:
            case 2:
            case 3:
                return 1;
            case 4:
            case 5:
            case 6:
                return 2;
            case 7:
            case 8:
            case 9:
                return 3;
            case 10:
            case 11:
            case 12:
                return 4;
            default:
                return 0;
        }
    }

    /**
     * 返回月份
     *
     * @param date 日期
     * @return 返回月份
     */
    public static int getMonth(java.util.Date date) {
        java.util.Calendar c = java.util.Calendar.getInstance();
        c.setTime(date);
        return c.get(java.util.Calendar.MONTH) + 1;
    }

    /**
     * 返回日份
     *
     * @param date 日期
     * @return 返回日份
     */
    public static int getDay(java.util.Date date) {
        java.util.Calendar c = java.util.Calendar.getInstance();
        c.setTime(date);
        return c.get(java.util.Calendar.DAY_OF_MONTH);
    }

    /**
     * 返回小时
     *
     * @param date 日期
     * @return 返回小时
     */
    public static int getHour(java.util.Date date) {
        java.util.Calendar c = java.util.Calendar.getInstance();
        c.setTime(date);
        return c.get(java.util.Calendar.HOUR_OF_DAY);
    }

    /**
     * 返回分钟
     *
     * @param date 日期
     * @return 返回分钟
     */
    public static int getMinute(java.util.Date date) {
        java.util.Calendar c = java.util.Calendar.getInstance();
        c.setTime(date);
        return c.get(java.util.Calendar.MINUTE);
    }

    /**
     * 返回秒钟
     *
     * @param date 日期
     * @return 返回秒钟
     */
    public static int getSecond(java.util.Date date) {
        java.util.Calendar c = java.util.Calendar.getInstance();
        c.setTime(date);
        return c.get(java.util.Calendar.SECOND);
    }

    /**
     * 返回输入时间0点的时间
     *
     * @param date
     * @return
     */
    public static Date getDateZero(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    /**
     * 返回输入时间23点59分59秒的时间
     *
     * @param date
     * @return
     */
    public static Date getDateLast(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime();
    }

    /**
     * 判断时间是不是今天
     *
     * @param date
     * @return 0:是今天
     * -1:今天之前
     * 1:今天之后
     */
    public static int isSameDay(Date date) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        Calendar today = Calendar.getInstance();
        today.set(Calendar.HOUR_OF_DAY, 0);
        today.set(Calendar.MINUTE, 0);
        today.set(Calendar.SECOND, 0);
        today.set(Calendar.MILLISECOND, 0);

        return calendar.compareTo(today);
    }

    /**
     * 获取时间，昨天，明天
     *
     * @param date
     * @param interval 正数日期后移，负数日期前移
     * @return
     */
    public static Date getDate(Date date, int interval) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, interval);
        return calendar.getTime();
    }

    /**
     * 获取时间，小时
     *
     * @param date
     * @param interval 正数日期后移，负数日期前移
     * @return
     */
    public static Date getDateTime(Date date, int interval) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY, interval);
        return calendar.getTime();
    }

    /**
     * 获取前月的第一天
     *
     * @param date
     * @return
     */
    public static Date getFirstOfMonth(Date date) {
        // 获取前月的第一天
        Calendar cale = Calendar.getInstance();
        cale.setTime(date);
        cale.add(Calendar.MONTH, 0);
        cale.set(Calendar.DAY_OF_MONTH, 1);
        return cale.getTime();
    }

    /**
     * 获取前月的最后一天
     *
     * @param date
     * @return
     */
    public static Date getLastOfMonth(Date date) {
        // 获取前月的最后一天
        Calendar cale = Calendar.getInstance();
        cale.setTime(date);
        cale.add(Calendar.MONTH, 1);
        cale.set(Calendar.DAY_OF_MONTH, 0);
        return cale.getTime();
    }

    /**
     * 获取多少月之后，之前的第一天零点时间
     *
     * @param date
     * @param months
     * @return
     */
    public static Date getDateZeroOfMonths(Date date, int months) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, months);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取多少月之后，之前的最后一天的最后时间
     *
     * @param date
     * @param months
     * @return
     */
    public static Date getLastTimeOfMonths(Date date, int months) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, months + 1);
        calendar.set(Calendar.DAY_OF_MONTH, 0);
        calendar.add(Calendar.DATE, 0);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime();
    }

    /**
     * 获取多少天之后，之前的最后时间
     *
     * @param date
     * @param days
     * @return
     */
    public static Date getLastTimeOfDays(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, days);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime();
    }

    /**
     * 获取多少天之后，之前的零点时间
     *
     * @param date
     * @param days
     * @return
     */
    public static Date getDateZeroOfDays(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, days);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取当前时间是当年的第几周
     *
     * @param date
     * @return
     */
    public static int getWeekNumOfYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);
        return weekOfYear;
    }

    /**
     * 获取日期是星期几
     *
     * @param date
     * @return
     */
    public static int getDayOfWeekFromDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        return dayOfWeek;
    }
    
    /**
     * 获取日期是星期几
     *
     * @param date
     * @return
     */
    public static String getDayOfWeekStringFromDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        switch (dayOfWeek) {
			case 1: return "星期天";
			case 2: return "星期一";
			case 3: return "星期二";
			case 4: return "星期三";
			case 5: return "星期四";
			case 6: return "星期五";
			case 7: return "星期六";
			default: return "";
		}
    }

    /**
     * 时间长度格式化小时
     *
     * @param time
     * @return x.x小时
     */
    public static String longTimeFormat(Long time) {
        Long timeMiu = time / 1000 / 60;
        String hours = String.valueOf(timeMiu / 60);
        String subhours = String.valueOf(timeMiu % 60 / 6);
        return hours + "." + subhours;
    }

    /**
     * 日期的秒小于10的话，改为10
     *
     * @param date
     * @return
     */
    public static Date getDealSecondTo10(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        if (date.getSeconds() < 10) {
            calendar.set(Calendar.SECOND, 10);
        }

        return calendar.getTime();
    }

    public static String getTimeDiffLabel(Long time) {
        if (time == null) {
            return null;
        }
        StringBuffer sb = new StringBuffer();

        Date date = new Date(time);
        Date now = new Date();

        Long diff = now.getTime() - date.getTime();
        boolean isBefore = diff >= 0;

        if (diff < 5 * 60 * 1000) {
            sb = new StringBuffer();
            sb.append("刚刚");
            return sb.toString();
        }

        if (diff < 60 * 60 * 1000) {
            sb = new StringBuffer();
            sb.append(diff / (60 * 1000));
            sb.append("分钟");
            sb.append(isBefore ? "前" : "后");

            return sb.toString();
        }
        if (diff < 24 * 60 * 60 * 1000) {
            sb = new StringBuffer();
            sb.append(diff / (60 * 60 * 1000));
            sb.append("小时");
            sb.append(isBefore ? "前" : "后");
            return sb.toString();
        }

        if (diff < 7 * 24 * 60 * 60 * 1000) {
            sb = new StringBuffer();
            sb.append(diff / (24 * 60 * 60 * 1000));
            sb.append("天");
            sb.append(isBefore ? "前" : "后");
            return sb.toString();
        } else {
            sb = new StringBuffer();
            sb.append("一周");
            sb.append(isBefore ? "前" : "后");
            return sb.toString();
        }
    }
    /**
     * 获取上个月的第一天
     *
     * @param date
     * @return
     */
    public static Date getLastMonthOne(Date date) {
        // 获取前月的第一天
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DAY_OF_MONTH, 1);
        c.add(Calendar.MONTH, -1);
        return c.getTime();
    }

    /**
     * 获取上个月的最后一天
     *
     * @param date
     * @return
     */
    public static Date getLastMonthLast(Date date) {
        // 获取前月的最后一天
        Calendar cale = Calendar.getInstance();
        cale.setTime(date);
        cale.set(Calendar.DAY_OF_MONTH, 1);
        cale.add(Calendar.DATE, -1);
        return cale.getTime();
    }

    /**
	 * 根据传入日期获取上个月
	 * @param date 传入的格式"yyyyMMdd" 如："20171011"
	 * @return  返回格式"yyyyMM" 如："201709"
	 */
	public static String getLastMonth(String date){
		if(StringUtils.isBlank(date)){
			return date;
		}
		int Year=Integer.parseInt(date.substring(0, 4));
		int month=Integer.parseInt(date.substring(4, 6));
		String lastMonth="";
		if(month==1){
			Year--;
			month=12;
		}else{
			month--;
		}
		
		if(month>9){
			lastMonth=lastMonth+Year+month;
		}else{
			lastMonth=Year+"0"+month;
		}
		return lastMonth;
	}
	
	/**
	 * 获取传入月份的天数
	 * @param yearMonth  传入的格式"yyyyMM" 如："201710"
	 * @return
	 */
	public static String getDaysByMonth(String yearMonth){
		int year=Integer.parseInt(yearMonth.substring(0, 4));
		int month=Integer.parseInt(yearMonth.substring(4, 6));
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:	
		case 8:
		case 10:
		case 12:
			return "31";
		case 2:
			if((year%10==0&&year%100==0)||(year%10!=0&&year%4==0)){
				return "28";
			}else{
				return "29";
			}
		default:
			return "30";
		}
	}
	
	/**
	 * 获取传入月份的工作天数
	 * @param yearMonth  传入的格式"yyyyMM" 如："201710"
	 * @return 工作天数  
	 */
	public static int countWorkdayByMonth(String yearMonth){
		int year=Integer.parseInt(yearMonth.substring(0, 4));
		int month=Integer.parseInt(yearMonth.substring(4, 6));
		int count=0;
		Calendar calendar=Calendar.getInstance();
		calendar.set(year, month-1, 1);
		while(calendar.get(Calendar.MONTH)<month && calendar.get(Calendar.YEAR)<=year){
			if(!checkHoliday(calendar,null)){
				count++;
			}
			calendar.add(Calendar.DATE, 1);
		};
		return count;
	}
	
	/**
	 * 判断传入的日期是否是节假日
	 * @param calendar  需判断的日期
	 * @param holidayList 节假日数组，可为空（为空时，只判断是否是周末）
	 * @return
	 * 
	 */
	public static boolean checkHoliday(Calendar calendar,List<Calendar> holidayList) {
		if((calendar.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY)||(calendar.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY)){
			return true;
		}
		if(holidayList!=null){
			for(Calendar ca:holidayList){
				if(calendar.get(Calendar.YEAR)==ca.get(Calendar.YEAR) && calendar.get(Calendar.MONTH)==ca.get(Calendar.MONTH)
						&& calendar.get(Calendar.DAY_OF_MONTH)==ca.get(Calendar.DAY_OF_MONTH) ){
					return true;
				}
			}
		}
		return false;
	}
	
    public static void main(String[] args) {
        /*System.out.println(isSameDay(new Date()));
        System.out.println(isSameDay(new Date(System.currentTimeMillis() - 24 * 60 * 60 * 1000)));
        System.out.println(isSameDay(new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000)));
        System.out.println();
        System.out.println();
        Calendar c = Calendar.getInstance();
        System.out.println(c.get(Calendar.YEAR));
        System.out.println(c.get(Calendar.MONTH));
        System.out.println(c.get(Calendar.DAY_OF_MONTH));

        System.out.println(string2Date("2018-07-20 14:30:00", FORMAT_YYYY_MM_DD_SS));

        System.out.println();
        System.out.println(DateFormatUtil.date2String(DateFormatUtil.getDate(new Date(), 1), DateFormatUtil.FORMAT_MM_DD_WITH_POINT));
        System.out.println(DateFormatUtil.date2String(DateFormatUtil.getDate(new Date(), 0), DateFormatUtil.FORMAT_MM_DD_WITH_POINT));
        System.out.println(DateFormatUtil.date2String(DateFormatUtil.getDate(new Date(), -1), DateFormatUtil.FORMAT_MM_DD_WITH_POINT));


        System.out.println(string2Date("2018-07", DateFormatUtil.FORMAT_YYYY_MM_WITH_LINE));
        System.out.println(date2String(string2Date("2018-07", DateFormatUtil.FORMAT_YYYY_MM_WITH_LINE), DateFormatUtil.FORMAT_YYYY_MM_DD_SS));
        System.out.println(date2String(getFirstOfMonth(string2Date("2018-07", DateFormatUtil.FORMAT_YYYY_MM_WITH_LINE)), DateFormatUtil.FORMAT_YYYY_MM_DD_SS));
        System.out.println(date2String(getLastOfMonth(string2Date("2018-07", DateFormatUtil.FORMAT_YYYY_MM_WITH_LINE)), DateFormatUtil.FORMAT_YYYY_MM_DD_SS));

        System.out.println();
        System.out.println(longTimeFormat(10 * 60 * 1000L));
        System.out.println(longTimeFormat(11 * 60 * 1000L));
        System.out.println(longTimeFormat(12 * 60 * 1000L));
        System.out.println(longTimeFormat(62 * 60 * 1000L));
        System.out.println(longTimeFormat(72 * 60 * 1000L));
        System.out.println(longTimeFormat(73 * 60 * 1000L));*/
    	
    	/*System.out.println(date2String(getDateZeroOfDays(new Date(),-7), DateFormatUtil.FORMAT_YYYY_MM_DD_SS));
    	System.out.println(date2String(getLastTimeOfDays(new Date(),-1), DateFormatUtil.FORMAT_YYYY_MM_DD_SS));
    	System.out.println(date2String(getDateZeroOfMonths(new Date(),-3), DateFormatUtil.FORMAT_YYYY_MM_DD_SS));
    	System.out.println(date2String(getLastTimeOfMonths(new Date(),-1), DateFormatUtil.FORMAT_YYYY_MM_DD_SS));
    	System.out.println(getWeekNumOfYear(new Date()));
    	System.out.println(getQuarter(new Date()));*/
    	
    	/*System.out.println(date2String(getDealSecondTo10(string2Date("2018-07-20 14:30:11", FORMAT_YYYY_MM_DD_SS)),FORMAT_YYYY_MM_DD_SS));

        System.out.println(DateFormatUtil.date2String(new Date(), DateFormatUtil.FORMAT_YYYY_MM_DD_WITH_ZH));
        System.out.println(DateFormatUtil.date2String(new Date(), DateFormatUtil.FORMAT_HH_MM));
        
        String departureDateStr=DateFormatUtil.date2String(DateFormatUtil.string2Date("2018-07-27", DateFormatUtil.FORMAT_YYYY_MM_DD_WITH_LINE), DateFormatUtil.FORMAT_YYYY_MM_DD_WITH_LINE)
    			+" "+DateFormatUtil.date2String(DateFormatUtil.string2Date("23:00:03", DateFormatUtil.FORMAT_HH_MM_SS), DateFormatUtil.FORMAT_HH_MM_SS);
        System.out.println(departureDateStr);
        Long useCarTime = DateFormatUtil.string2Date(departureDateStr, DateFormatUtil.FORMAT_YYYY_MM_DD_SS).getTime();
        System.out.println(useCarTime);*/

//        String a1 = "{'departureTimeStart':'2019-03-21'}";
//        String a2 = "{'expectedDepartureDate':1552838400000}";
//        JSONObject oldJson = new JSONObject();
//        JSONObject newJson = new JSONObject();
//        oldJson.put("departureTimeStart", "2019-03-21");
//        newJson.put("expectedDepartureDate", 1552838400000L);
//
//        String newDepartureTimeStartStr = DateFormatUtil.date2String(newJson.getDate("departureTimeStart"), DateFormatUtil.FORMAT_YYYY_MM_DD_WITH_POINT);
//        String oldDepartureTimeStartStr = DateFormatUtil.date2String(oldJson.getDate("expectedDepartureDate"), DateFormatUtil.FORMAT_YYYY_MM_DD_WITH_POINT);
//        System.out.println(newDepartureTimeStartStr);
//        System.out.println(oldDepartureTimeStartStr);

        System.out.println(new Date().getTime());
        System.out.println(string2Date("20200210 08:07", FORMAT_YYYY_MM_DD_NO_SPACE_HH_mm).getTime());


        //星期二  3
    }
}
