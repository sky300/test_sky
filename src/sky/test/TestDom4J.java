package sky.test;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * DOM4J解析XML
 * @author sky
 * 
 */

public class TestDom4J {

    /**
     * @param args
     * @throws Exception
     */

    public static void main(String[] args) throws Exception {
        parseTest();
        parseXML02();
    }

    @SuppressWarnings("rawtypes")
    public static void parseXML02() throws Exception {

        String path = TestDom4J.class.getResource("/").getPath();
        // 读取文件
        File file = new File(path + "XML02.xml");
        // 创建saxreader工厂
        SAXReader reader = new SAXReader();
        // 获取文件类
        Document doc = reader.read(file);
        // 获取全部节点
        Element root = doc.getRootElement();
        Element foo;
        // 第一层 循环
        for (Iterator i = root.elementIterator("PkgDef"); i.hasNext();) {
            foo = (Element) i.next();
            // 第二层循环
            for (Iterator it = foo.elementIterator("DataField"); it.hasNext();) {
                Element el = (Element) it.next();
                System.out.print("DataField   " + "Name=" + el.attributeValue("Name") + "  ");
                System.out.println("Vlaue=" + el.attributeValue("Value"));
            }
            // 第二层循环
            for (Iterator ite = foo.elementIterator("FormDef"); ite.hasNext();) {
                Element el2 = (Element) ite.next();
                System.out.print("FormDef  " + "Name=" + el2.attributeValue("Name"));
                System.out.println("FormDef  " + "Column=" + el2.attributeValue("Column"));
                // 第三层循环
                for (Iterator i3 = el2.elementIterator("PkgDef"); i3.hasNext();) {
                    Element el3 = (Element) i3.next();
                    System.out.println("PkgDef  " + "Name=" + el3.attributeValue("Name"));
                    // 第四层循环
                    for (Iterator i4 = el3.elementIterator("DataField"); i4.hasNext();) {
                        Element el4 = (Element) i4.next();
                        System.out.print("DataField  " + "Name=" + el4.attributeValue("Name"));
                        System.out.println("DataField  " + "Value=" + el4.attributeValue("Value"));
                    }
                }
            }
        }

    }

    public static void parseTest() throws Exception {
        String path = TestDom4J.class.getResource("/").getPath();
        // 读取文件
        File file = new File(path + "test.xml");
        // 创建saxreader工厂
        SAXReader reader = new SAXReader();
        // 获取文件类
        Document doc = reader.read(file);
        // 获取根节点
        Element root = doc.getRootElement();
        List<Element> childs = root.elements();
        for (int i = 0; i < childs.size(); i++) {
            System.out.print("车牌号为：" + ((Element) childs.get(i)).elementText("NO"));
            System.out.println("车主地址为：" + ((Element) childs.get(i)).elementText("ADDR"));
        }
    }
}
