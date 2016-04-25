package sky.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @classname: TestJAVA7
 * @description: 测试一些java7的新特性
 */
public class TestJAVA7 {

    /**
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        double aa = 3.14_1_59265_736456_456_4_6;// 支持下划线
        int bb = 0B1010;// 支持二进制
        System.out.println(aa);
        System.out.println(bb);
        testSwitch("A");// 测试switch是否支持String类型
        testCompare();
        TestJAVA7 java7= new TestJAVA7();
//        java7.read("D:/新建文本文档.txt");
    }

    private static void testSwitch(String str) {
        switch (str) {
            case "A":
                System.out.println("A");
                break;
            case "B":
                System.out.println("B");
                break;
            case "C":
                System.out.println("C");
                break;

            default:
                System.out.println("没有匹配");
                break;
        }
    }

    private static void testCompare() {
        Integer ina = 12;
        Integer inb = 12;
        System.out.println(ina == inb);
        System.out.println(ina.compareTo(inb));// 比较是否相等。等于0则相等

    }

    /**
     * @title: read
     * @description:在try（）里创建对象，可以自动关闭。不用再加finally里
     * @date 2015-5-7 上午9:52:16
     * @param filename
     * @throws IOException
     */
    public void read(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new BufferedReader(new InputStreamReader(new FileInputStream(
                filename), "GBK")))) {
            StringBuilder builder = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
                builder.append(String.format("%n"));
            }
            System.out.println(builder.toString());
            // return builder.toString();
        }
    }

    /**
     * @title: useVarargs
     * @description:当参数为不可具体化的类型时，如List，编译器将产生警告，需要使用@SuppressWarnings("unchecked")注解声明；
     * Java7中使用@SafeVarargs注解抑制编译器警告。
     * @date 2015-5-7 上午9:59:11
     * @param args
     */
    @SafeVarargs
    public static <T> T useVarargs(T... args) {
        return args.length > 0 ? args[0] : null;
    }
}
