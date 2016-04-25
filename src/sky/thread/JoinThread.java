package sky.thread;

/**
 * 线程的控制
 * 测试join功能代码测试
 * @author Administrator
 *
 */
public class JoinThread implements Runnable{
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName()+"  "+i);
		}
		
	}
	public static void main(String[] args) throws InterruptedException {
		JoinThread joinThread = new JoinThread();
		Thread th2 = new Thread(joinThread,"子线程1");
		th2.start();
		th2.join();
		
		for (int i = 0; i < 100; i++) {
			if (i==20) {
				JoinThread joinThread2 = new JoinThread();
				Thread th = new Thread(joinThread2,"子线程2");
				th.start();
				th.join();
			}
			System.out.println(Thread.currentThread().getName()+"  "+i);
		}
	}
}
