package sky.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AboutDate {

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // System.out.println(sdf.format(System.currentTimeMillis()));

        // Calenear 使用默认时区和语言环境获得一个日历。
        Calendar cal = Calendar.getInstance();
        System.out.println(cal.get(Calendar.YEAR));
        System.out.println(cal.get(Calendar.DAY_OF_YEAR));
        System.out.println(cal.get(Calendar.DAY_OF_WEEK));
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(sdf.format(date));
        testH("春", "夏", "秋", "冬");
    }

    public static void testH(String... str) {
        for (String string : str) {
            System.out.print(string);
        }
    }
}
