package sky.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
/**
 * callable接口实现多线程
 * 该接口实现多线程的好处是
 * 1.可以得到有返回值的线程
 * 2.可以处理异常
 * @author Administrator
 *
 */
public class CallableThreadTest {

	public static void main(String[] args) {
		CallableThread ct= new CallableThread();//创建callable对象
		FutureTask<Integer> ft = new FutureTask<Integer>(ct);//使用futuretask包装callable对象
		for (int i = 0; i < 100; i++) {
			if (i ==20) {
				new Thread(ft, "有返回值的线程").start();
			}
		}
		try {
			System.out.println("子线程的返回值：" +ft.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

}
