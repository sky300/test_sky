package sky.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class TestTest {
	transient int hashSeed = 0;
    public static void main(String[] args) throws Exception {
        // String aa= dateToString(Calendar.getInstance());
        // System.out.println(aa);
        // System.out.println(StringUtil.encoderToString("你好啊", "utf-8"));
        // System.out.println(StringUtil.decoderToString("%E4%BD%A0%E5%A5%BD%E5%95%8A",
        // "UTF-8"));
    //	inputstream();
        // inputstream();
//        parseXML();
        
//    	String str = HttpUtil.httpRequest("http://api.we7.cc/v1/simsimi.php?msg="+HttpUtil.urlEncodeUTF8("我饿了"));
//    	System.out.println(URLDecoder.decode("\u5403\u4e86\u624d\u51cf\u80a5\u5427"));
    	String aa = "hello";
    	System.out.println(aa.hashCode());
    	
    	ConcurrentHashMap<String, String> chm = new ConcurrentHashMap<String, String>();
    	chm.put("aaa", "bbb");
    	
    	List list = new ArrayList();
    	list.add(1);
    	list.add(2);
    	list.add(4);
    	list.add(21);
    	list.add(132);
    	list.forEach(obj -> System.out.println("www+"+obj));
    	HashMap<String, String> map = new HashMap<String, String>();
    	map.put(null, "hello");
    	map.put("a", "hello");
    	map.put("b", "hello");
    	map.put("c", "hello");
    	map.put("你", "hello");
    	map.put("好", "hello");
    	map.put("哈", "hello");
    	map.put("中", "hello");
    	map.put("国", "hello");
    	map.put("最", "hello");
    	map.put("牛", "hello");
    	map.put("牛逼", "hello");
    	map.put("牛逼而沃尔沃", "hello");
    	System.out.println(19031%16);
    	System.out.println(103%16);
    	System.out.println("中".hashCode());
    	System.out.println("a".hashCode());
    	
    }
    
    
    
    
    /**
     * 解析XML测试
     */
    public static void parseXML() throws Exception{
        SAXReader reader = new SAXReader();
        Document doc =reader.read(new File("c://test.xml"));
        Element root = doc.getRootElement();
        Element foo;
        for (Iterator i = root.elementIterator("VALUE"); i.hasNext();) {
            foo = (Element)i.next();
            System.out.println(foo.elementText("NO"));
            System.out.println(foo.elementText("ADDR"));
        }
    }

    /**
     * 测试写入properties
     * @throws FileNotFoundException
     */
    public static void write() throws Exception {
        Properties pro = new Properties();
        pro.put("hello", "你好");
        FileOutputStream fos = new FileOutputStream("c://hello.txt");
        pro.store(fos, "test sky");
    }

    /**
     * 测试读取 properties
     */
    public static void read() throws Exception {
        Properties pro = new Properties();
        FileInputStream fis = new FileInputStream("c://hello.txt");
        pro.load(fis);
        System.out.println(pro.getProperty("hello"));
    }

    /**
     * 日期转字符串
     * @param cal
     * @return
     */
    public static String dateToString(Calendar cal) {
        cal.add(Calendar.DATE, -1);
        // cal.add(Calendar.MONTH, -1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return sdf.format(cal.getTime());
    }

    /**
     * 输入流测试
     */
    public static void inputstream() {
    	int size = 20;//每行显示字数
    	int lineNo = 0;//行号
    	int startLine = 0;//从第几行开始读取
    	int endLine = 150;//一次读取行数
    	String filePath = "F:\\wdqk.txt";//文件路径
    	String fileEncoding ="GBK";//字符编码
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
            fis = new FileInputStream(filePath);//载入文件
            isr = new InputStreamReader(fis, fileEncoding);//设置字符编码
            br = new BufferedReader(isr);
            StringBuffer sb = new StringBuffer();
            while (br.ready() && lineNo < startLine + endLine ) { //已经读取的行数是否小于要求的行数
                lineNo++;
                String lineMax = br.readLine();//读取一行
                if(lineNo < startLine){//控制从第几行开始读取
                	continue;
                }
                while (lineMax.length() > size) {//是否大于每行显示的字数，如果大于则进行相关的数据处理
                		String temp = "";
                		temp = lineMax.substring(0, size) + "\n" ;
                		sb.append(temp);
                		lineMax = lineMax.substring(size);
                }
                sb.append(lineNo+lineMax+"\n");//小于每行字数时
            }
            sb.toString();
            System.out.println(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
                isr.close();
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void skyow() {

    }
}
