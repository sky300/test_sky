package sky.thread;
/**
 * daemon 守护线程、精灵线程、后台线程 测试程序
 * @author Administrator
 *
 */
public class DaemonThread extends Thread{
	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println(Thread.currentThread().getName()+"  "+i);
		}
		super.run();
	}
	
	public static void main(String[] args) {
		DaemonThread daemonThread = new DaemonThread();
		daemonThread.setDaemon(true);//设置为后台线程
		daemonThread.setName("后台线程");
		daemonThread.start();
		Thread.currentThread().setName("主线程");//设置程序的主线程
		for (int i = 0; i < 20; i++) {
			System.out.println(Thread.currentThread().getName()+" "+i);
		}
	}

}
