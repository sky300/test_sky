package sky.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import sky.utils.StringUtil;

public class TestIO {
    public static final int WINDOW_SIZE = 61;
    public static final String FILE = "d:\\aaa.txt";
    private static final int SIZE = 60;

    public static void main(String[] args) {
        // foo();
        inputstream();
        // fileReader();
    }

    /**
     * 读取文本
     */
    public static void foo() {
        File f = new File(FILE);
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String s;
            int i = 0;
            int line = 0;
            while (br.ready() && i < line + 1000) {
                i++;
                s = i + ":   " + br.readLine();
                while (s.length() > WINDOW_SIZE) {
                    int flag = s.lastIndexOf("\n");
                    if ((s.length() - flag) > WINDOW_SIZE) {
                        s = s.substring(0, flag + WINDOW_SIZE) + "\n" + s.substring(flag + WINDOW_SIZE);
                    } else {
                        break;
                    }
                }
                if (line == 0 || line <= i) {
                    System.out.println(s);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * fileInputStream fileOutputStream
     */
    public static void inputstream() {
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        FileOutputStream fos = null;
        OutputStreamWriter osw = null;
        File file = new File("d:\\bb.txt");
        try {
            file.createNewFile();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        try {
            fis = new FileInputStream("D:\\aaa.txt");
            isr = new InputStreamReader(fis, "GBK");
            br = new BufferedReader(isr);
            fos = new FileOutputStream(file, true);// 是否追加文件末尾
            osw = new OutputStreamWriter(fos, "utf-8");
            // char[] buffer = new char[32];
            // int hasRead = 0;
            // while ((hasRead = isr.read(buffer , 0 , buffer.length)) > 0) {
            // System.out.println(new String(buffer, 0 , hasRead));
            // }
            while (br.ready()) {
                osw.write(br.readLine() + StringUtil.NEW_LINE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
                isr.close();
                br.close();
                osw.flush();
                osw.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 测试fileReader
     */
    public static void fileReader() {
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader("D:\\bb.txt");
            br = new BufferedReader(fr);
            int i = 0;
            while (br.ready() && i < 10) {
                i++;
                System.out.println(i + "-" + br.readLine());
            }
            // char[] buff = new char[32];
            // int i = 0;
            // while ((i = fr.read(buff))>0) {
            // System.out.println(new String(buff,0,i));
            // }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
