package sky.algorithm;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestPuke {
    
    /**
     * 算法，根据60秒判断属于什么值
     * @param i
     * @return
     */
    public static int timeNumber(int i) {
        if (0 < i && i <= 15) {
            return i;
        }
        if (15 < i && i <= 30) {
            return i - 15;
        }
        if (30 < i && i <= 45) {
            return i - 30;
        }
        if (45 < i && i <= 60) {
            return i - 45;
        }
        return 0;
    }

    /**
     * 输出牌面方法
     * @param timeNumber
     */
    public static void printNo(int timeNumber) {
        int no = timeNumber(timeNumber);
        if (no == 1) {
            System.out.println("这是A");
        }
        if (no == 2) {
            System.out.println("这是2");
        }
        if (no == 3) {
            System.out.println("这是3");
        }
        if (no == 4) {
            System.out.println("这是4");
        }
        if (no == 5) {
            System.out.println("这是5");
        }
        if (no == 6) {
            System.out.println("这是6");
        }
        if (no == 7) {
            System.out.println("这是7");
        }
        if (no == 8) {
            System.out.println("这是8");
        }
        if (no == 9) {
            System.out.println("这是9");
        }
        if (no == 10) {
            System.out.println("这是10");
        }
        if (no == 11) {
            System.out.println("这是J");
        }
        if (no == 12) {
            System.out.println("这是Q");
        }
        if (no == 13) {
            System.out.println("这是K");
        }
        if (no == 14) {
            System.out.println("这是小王");
        }
        if (no == 15) {
            System.out.println("这是大王");
        }
    }

    public static void main(String[] args) {
        Date date = new Date();
        // 取当前时间的秒
        SimpleDateFormat sdf = new SimpleDateFormat("ss");
        int tempNO = Integer.parseInt(sdf.format(date));
        if(tempNO == 0 ){
            System.out.println("您的速度 太快了，慢点吧!");
        }
        SimpleDateFormat sdfg = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(sdfg.format(date));
        printNo(tempNO);
    }

}
