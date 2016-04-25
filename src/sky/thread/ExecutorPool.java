package sky.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/**
 * 数据库连接池的测试方法
 * @author Administrator
 *
 */
public class ExecutorPool implements Runnable{

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName()+"的i值为"+i);
		}
	}
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		//创建一个线程池，允许6条线程数
		ExecutorService executorService = Executors.newFixedThreadPool(6);
		Future<?> fu =  executorService.submit(new ExecutorPool());
		Future<Integer> fc = executorService.submit(new CallableThread());
		System.out.println(fu.get());
		System.out.println((Integer)fc.get());
		executorService.shutdown();
	}

}
