package sky.thread;

import java.util.concurrent.Callable;

public class CallableThread implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		int i =0;
		for ( ; i < 100; i++) {
			System.out.println(Thread.currentThread().getName()+"-->"+i);
		}
		return i;
	}

}
