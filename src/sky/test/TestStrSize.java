package sky.test;

import java.io.UnsupportedEncodingException;

public class TestStrSize{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "ABCDEFGHIJ";
		String str1 = "һ�����������߰˾�ʮ";
		try {
			System.out.println("GBK�����С��" + str.getBytes("GBK").length);
			System.out.println("GBK�����С��" + str1.getBytes("GBK").length);
			
			System.out.println("Utf-8�����С��" + str.getBytes("UTF-8").length);
			System.out.println("Utf-8�����С��" + str1.getBytes("UTF-8").length);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		//�ֶ����ƣ��ַ�������֤���ȣ�����
	}
	
	
	
}
