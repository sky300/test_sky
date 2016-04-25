package sky.test;

import java.io.File;
import java.io.IOException;
import java.util.Stack;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class TestParseXML {
	public static void main(String[] args) throws ParserConfigurationException,
			SAXException, IOException {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		String path = TestParseXML.class.getResource("/").getPath();
		parser.parse(new File(path + "student.xml"),new MyHandler());
	}
}

class MyHandler extends DefaultHandler {

private Stack<String> stack = new Stack<String>();
	
	private String name;
	
	private String gender;
	
	private String age;
	/**
	 *<br>
	 * 方法说明：当遇到开始标记时调用 <br>
	 * 输入参数： <br>
	 * 返回类型：
	 */
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException
	{
		stack.push(qName);
		
		for(int i = 0; i < attributes.getLength(); i++)
		{
			String attrName = attributes.getQName(i);
			String attrValue = attributes.getValue(i);
			
			System.out.println(attrName + "=" + attrValue);
		}
	}
	@Override
	public void endDocument() throws SAXException {
		System.out.println("SAX解析XML结束");
		super.endDocument();
	}
	@Override
	public void startDocument() throws SAXException {
		System.out.println("SAX解析XML开始");
		super.startDocument();
	}
	/**
	 *<br>
	 * 方法说明：当分析器遇到无法识别为标记或者指令类型字符时调用 <br>
	 * 输入参数： <br>
	 * 返回类型：
	 */
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException
	{
		String tag = stack.peek();
		
		if("姓名".equals(tag))
		{
			name = new String(ch, start,length);
		}
		else if("性别".equals(tag))
		{
			gender = new String(ch, start, length);
		}
		else if("年龄".equals(tag))
		{
			age = new String(ch, start, length);
		}
	}
	/**
	 *<br>
	 * 方法说明：当遇到节点结束时调用 <br>
	 * 输入参数： <br>
	 * 返回类型：
	 */
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException
	{
		stack.pop(); //表示该元素已经解析完毕，需要从栈中弹出
		if("学生".equals(qName))
		{
			System.out.println("姓名：" + name);
			System.out.println("性别：" + gender);
			System.out.println("年龄：" + age);
			System.out.println();
		}
	}
}