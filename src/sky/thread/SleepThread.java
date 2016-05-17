package sky.thread;
/**
 * 测试thread的sleep方法
 * sleep使线程进入阻塞状态
 * yield让线程进入就绪状态（不推荐）须设置优先级
 * @author Administrator
 *
 */
public class SleepThread extends Thread{
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(getName()+" "+i);
		}
		super.run();
	}
	public static void main(String[] args)  {
		SleepThread sleepThread = new SleepThread();
		for (int i = 0; i < 20; i++) {
			if(i == 10){
				sleepThread.start();
				try {
					sleepThread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName()+i);
		}
	}
}
