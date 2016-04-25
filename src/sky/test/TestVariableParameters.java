package sky.test;

public class TestVariableParameters {

	/**
	 * 可变参数和方法的重载的区别
	 * @param args
	 */
	public static void test(int i ,String...animal ){
		for (String str : animal) {
			System.out.print(str);
		}
		System.out.println("\n" + "数量为" + i);
	}
	public static void main(String[] args) {
		test(3,"猫","狗","猪");
	}

	public static void hello(String aa){}
	public static void hello(int aa){}
	public static void hello(boolean aa){}
	
	
}
