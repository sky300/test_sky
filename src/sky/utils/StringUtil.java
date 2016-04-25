package sky.utils;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class StringUtil {
    public static final String NEW_LINE = System.getProperty("line.separator");// 行分隔符（在UNIX系统中是“/n”）
    public static final String SEPARATOR = System.getProperty("file.separator");// 文件分隔符（在 UNIX系统中是“/”）
    public static final String PATH_SEPARTOR = System.getProperty("path.separator");// 路径分隔符（在UNIX系统中是“:”Windows是;）
    public static final String ENCODE = "GBK";

    // -----------------------------------------------计算文字大小并补齐空格
    /**
     * 插入空格
     * @param length
     * @param info
     * @return
     */
    private static StringBuilder insertSpace(int length) {

        StringBuilder spaceBuffer = new StringBuilder();
        for (int i = 0; i < length; i++) {
            spaceBuffer.append(" ");
        }
        return spaceBuffer;
    }

    /**
     * 对其排列一行数据
     * @param oneMap
     * @return
     */
    public static String transToString(int length, String info) {

        StringBuilder oneStringBuffer = new StringBuilder();
        if (isEmpty(info)) {
            oneStringBuffer = insertSpace(length);
            return oneStringBuffer.toString();
        }
        // UTF-8英文1个字节，中文3个字节，GBK全部是双字节
        try {
            StringBuilder beforeSpace = insertSpace(length - (info.getBytes("GBK").length)); // 前空格
            oneStringBuffer.append(beforeSpace + info); // 前半空格+字段+后半空格
        } catch (UnsupportedEncodingException e) {
            return oneStringBuffer.toString();
        }
        return oneStringBuffer.toString();
    }

    /**
     * 转换成URLEncoder"乱码"
     * @param content
     * @param encode
     * @return
     */
    public static String encoderToString(String content, String encode) {
        String ret = "";
        try {
            ret = URLEncoder.encode(content, encode);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return ret;
    }

    /**
     * "乱码"转换成URLDecoder
     * @param content
     * @param encode
     * @return
     */
    public static String decoderToString(String content, String encode) {
        String ret = "";
        try {
            ret = URLDecoder.decode(content, encode);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return ret;
    }

    /**
     * 判断字符串是否空
     * @param s
     * @return 为空返回true
     */
    public static boolean isEmpty(String s) {
        return s == null || s.length() == 0;
    }

    public static boolean isNotEmpty(String s) {
        return s != null && s.length() > 0;
    }

    /**
     * GBK编码文件转换UTF-8编码格式
     * @param srcFileName
     * @param destFileName
     * @param append
     * @throws IOException
     */
    public static void transferFile(String srcFileName, String destFileName, boolean append) throws IOException {

        String line_separator = System.getProperty("line.separator");
        FileInputStream fis = new FileInputStream(srcFileName);
        StringBuffer content = new StringBuffer();
        DataInputStream in = new DataInputStream(fis);
        BufferedReader br = new BufferedReader(new InputStreamReader(in, "GBK"));
        String line = null;
        while ((line = br.readLine()) != null) {
            content.append(line + line_separator);
        }
        br.close();
        in.close();
        fis.close();
        Writer ow = new OutputStreamWriter(new FileOutputStream(destFileName, append), "UTF-8");
        ow.write(content.toString());
        ow.close();
    }

    /**
     * 测试主方法
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(File.separator);
    }
}
