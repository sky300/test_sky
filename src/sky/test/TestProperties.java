package sky.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

public class TestProperties {

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        // Locale myLocal = Locale.getDefault();
        // ResourceBundle bundle = ResourceBundle.getBundle("mess" , myLocal);
        // System.out.println(bundle.getString("IP"));
        // System.out.println(TestProperties.class.getResource("/").getPath());
        write();
        // read();

    }

    public static void write() throws Exception {
        Properties pro = new Properties();
        pro.setProperty("hello", "你好");
        pro.setProperty("world", "世界");
        String path = TestProperties.class.getResource("/").getPath();
        System.out.println(path);
        FileOutputStream fos = new FileOutputStream(path + "/db.properties");
        pro.store(fos, "sky");
    }

    public static void read() throws Exception {
        Properties pro = new Properties();
        String path = TestProperties.class.getResource("/").getPath();
        FileInputStream fis = new FileInputStream(path + "db.properties");
        pro.load(fis);
        System.out.println(pro.getProperty("hello"));
        System.out.println(pro.getProperty("world"));
    }
}
