package sky.test;


public class SubClass extends BaseClass {

	public String book = "我是子类哈！";

	public void sub() {
		System.out.println("我是子类的sub方法");
	}

	public void test() {
		System.out.println("我是子类的test方法，我将会覆盖父类的test方法");
	}

	public static void main(String[] args) {
		BaseClass bc = new BaseClass();
		System.out.println(bc.book);

		SubClass sc = new SubClass();
		System.out.println(sc.book);

		BaseClass testBC = new SubClass();
		System.out.println(testBC.book); // 输出父类的book信息
		testBC.base(); // 输出从父类继承的base()方法
		testBC.test(); // 输出子类覆盖父类的test()方法
		// 继承、重写、父类引用指向子类对象
	}
}
