package sky.thread;

public class TestThread extends Thread{
	public  TestThread(String name){
		super(name);
	}
	public TestThread(ThreadGroup group,String name){
		super(group, name);
	}
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(getName() + "线程i的变量" + i);
		}
		super.run();
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			new TestThread("测试").start();
			new TestThread("测试2").start();
		}
	}
}
