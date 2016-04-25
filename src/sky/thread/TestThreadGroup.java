package sky.thread;

public class TestThreadGroup {

	public static void main(String[] args) {
		ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();//获取主线程的线程组
		System.out.println("主线程组的名字为："+threadGroup.getName());
		
		System.out.println("主线程组是否为后台线程组:"+ threadGroup.isDaemon());
		new TestThread("主线程组的线程--->").start();
		
		ThreadGroup tg = new ThreadGroup("新线程组");
		tg.setDaemon(true);//设置为精灵线程组
		System.out.println("新线程组是否为精灵线程组："+tg.isDaemon());
		Thread tt = new TestThread(tg, "新线程组的线程甲");
		tt.setDaemon(true);
		tt.start();
		System.out.println("新线程组的线程甲是否为精灵线程"+tt.isDaemon());
//		new TestThread(tg, "新线程组的线程乙").start();
		for (int i = 0; i < 5; i++) {
			System.out.println("主线程的名字为："+Thread.currentThread().getName());
		}
	}
}
