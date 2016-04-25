package sky.test;

public class TestInner {

	/**
	 * 测试局部内部类
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// 创建一个局部内部类
		class InnerBase {
			int a;

		}

		// 创建一个InnerBase内部类的子类
		class InnerSub extends InnerBase {
			int b;
		}
		InnerSub is = new InnerSub();
		is.a = 1;
		is.b = 2;
		System.out.println("内部类的值为：" + is.a + "内部类的子类为：" + is.b);

		Thread thread = new Thread(runnable);
		Thread thread1 = new Thread(runnable1);
		thread.start();
		thread1.start();
		// 测试线程的一些问题
		System.out.println("主方法里的名字" + Thread.currentThread().getName()
				+ Thread.currentThread().getId());

	}

	static Runnable runnable = new Runnable() {

		@Override
		public void run() {
			System.out.println("线程里的名字" + Thread.currentThread().getName()
					+ Thread.currentThread().getId());
		}
	};
	static Runnable runnable1 = new Runnable() {

		@Override
		public void run() {
			System.out.println("线程里的名字" + Thread.currentThread().getName()
					+ Thread.currentThread().getId());
		}
	};

	public static void sky() {

		System.out.println(Thread.currentThread().getName());
	}
}
