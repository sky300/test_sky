package sky.test;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestDate {
    public static void main(String[] args) {
        // 获取距离当前日期最近的周日日期
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        // 设置当前日期
        Calendar aCalendar = Calendar.getInstance();
        aCalendar.setTime(new Date());
        System.out.println("当前日期啊： " + df.format(aCalendar.getTime()));
        // 取当前日期是星期几(week:星期几)
        int week = aCalendar.get(Calendar.DAY_OF_WEEK);
        if (week == 1) {
            week = 7;
        } else if (week == 0) {
            week = 6;
        }
        /*
         * else if(week == 2){ week = }
         */
        else {
            week -= 1;
        }

        // 取距离当前日期最近的周日与当前日期相差的天数（count：相差的天数。正数：之后的周日，负数：之前的周日）
        int count = 0;
        // 星期一
        int monday = 0;
        int sunday = 0;
        if (week <= 3) {
            count = -week;
            monday = count + 1;
            sunday = count + 7;
        } else if (week >= 4) {
            count = 7 - week;
            monday = -(7 - (count + 1));
            sunday = count;
        }

        // 周日
        Calendar sund = Calendar.getInstance();
        // 周一
        Calendar mond = Calendar.getInstance();

        mond.add(Calendar.DAY_OF_WEEK, monday);
        sund.add(Calendar.DAY_OF_WEEK, sunday);
        String one = df.format(mond.getTime()).toString();
        String seven = df.format(sund.getTime()).toString();
        // 格式化并打印出距离当前日期最近的周日日期
        System.out.println("当前日期： " + df.format(aCalendar.getTime()) + '\n' + "最近周日： " + seven + '\n' + "最近的周一是" + one);
    }

    public static void testCalendear() {

        Calendar startTime = Calendar.getInstance();
        startTime.setTime(Timestamp.valueOf("2012" + "-" + "01" + "-01" + " 00:00:00"));
        startTime.set(Calendar.DATE, 1);
        startTime.roll(Calendar.DATE, -1);
        // startTime.roll(Calendar.MONTH, 2);//不进位
        // startTime.add(Calendar.MONTH, 2);//进位
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("----------" + sdf.format(startTime.getTime()));
        // startTime.setTime(Timestamp.valueOf("2011-12-12 00:00:00"));
        // Calendar endTime = Calendar.getInstance();
        // endTime.setTime(Timestamp.valueOf("2011-12-19 00:00:00"));

    }
}