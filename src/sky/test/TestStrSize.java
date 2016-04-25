package sky.test;

import java.io.UnsupportedEncodingException;

public class TestStrSize{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "ABCDEFGHIJ";
		String str1 = "一二三四五六七八九十";
		try {
			System.out.println("GBK编码大小：" + str.getBytes("GBK").length);
			System.out.println("GBK编码大小：" + str1.getBytes("GBK").length);
			
			System.out.println("Utf-8编码大小：" + str.getBytes("UTF-8").length);
			System.out.println("Utf-8编码大小：" + str1.getBytes("UTF-8").length);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		//字段名称，字符串，验证长度，编码
	}
	
	
	
}
