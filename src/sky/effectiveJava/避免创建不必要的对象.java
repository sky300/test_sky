package sky.effectiveJava;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * 
 * @classname: 避免创建不必要的对象
 * @description: 测试long和Long对象做加法运算的性能差距，结论--》运算一定要用基本数据类型，而不用封装对象
 */
public class 避免创建不必要的对象 {

    private static final Date BOOM_START;

    private static final Date BOOM_END;

//    private final Date birthDay;
    static {// 1946到1964年出生的人
        Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        gmtCal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
        BOOM_START = gmtCal.getTime();
        gmtCal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
        BOOM_END = gmtCal.getTime();
    }

    public boolean isBabyBoomer(Date birthDay) {
        return birthDay.compareTo(BOOM_START) >= 0 && birthDay.compareTo(BOOM_END) < 0;

    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        // sumInt();//706毫秒
        sumInt2();// 大约7秒
        long end = System.currentTimeMillis();
        System.out.println("耗时--->" + (end - start));
    }

    public static void sumInt() {
        long sum = 0l;
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        System.out.println("long的性能--->" + sum);
    }

    public static void sumInt2() {
        Long sum = 0l;
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        System.out.println("Long的性能--->" + sum);
    }

}
