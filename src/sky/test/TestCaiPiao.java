package sky.test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class TestCaiPiao {
    /**
     * 1-33随机数
     */
    public static int random33() {
        Random rand33 = new Random();
        // nextInt(34)的取值范围是0-33
        int ret = rand33.nextInt(34);
        if (ret == 0) {
            return random33();
        }
        return ret;
    }

    /**
     * 1-16随机数
     * 
     * @return
     */
    public static int random16() {
        Random rand16 = new Random();
        int ret = rand16.nextInt(17);
        if (ret == 0) {
            return random16();
        }
        return ret;
    }

    /**
     * 去重
     * 
     * @param args
     */
    public static Set<Integer> quChong() {
        int one = random33();
        int two = random33();
        int three = random33();
        int four = random33();
        int five = random33();
        int six = random33();
        Set<Integer> set = new HashSet<Integer>();
        set.add(one);
        set.add(two);
        set.add(three);
        set.add(four);
        set.add(five);
        set.add(six);
        while (set.size() != 6) {
            return quChong();
        }
        return set;
    }

    public static String runStr(int total) {
        int a = total;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < a; i++) {
            int seven = random16();
            List<Integer> list = new ArrayList<Integer>();
            // 彩票去重
            Set<Integer> set = quChong();
            // 遍历set
            Iterator<Integer> it = set.iterator();
            while (it.hasNext()) {
                list.add(it.next());
            }
            // 从小到大排序
            Collections.sort(list);
            // 封装结果
            sb.append("梦幻五百万是--->");
            for (Integer value : list) {
                sb.append(value + " ");
            }
            sb.append("  " + seven + "\n");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        FileWriter fw = null;
        String result = runStr(10);
        System.out.println(result);
        try {
            fw = new FileWriter("c://aa.txt");
            fw.write(result);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
