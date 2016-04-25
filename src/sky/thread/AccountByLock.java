package sky.thread;

import java.util.concurrent.locks.ReentrantLock;

public class AccountByLock {
	private String accountNo;
	private double balance;
	private final ReentrantLock lock = new ReentrantLock();
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public double getBalance() {
		return this.balance;
	}
	public AccountByLock(){}
	public AccountByLock(String accountNo,double balance){
		this.accountNo = accountNo;
		this.balance = balance;
	}
	/**
	 * 线程同步的即线程安全的
	 * 取钱的逻辑
	 * @param drawAmount 取钱的金额
	 */
	public void draw(double drawAmount){
		
		lock.lock();
		try {
			if(drawAmount <= balance){
				System.out.println(Thread.currentThread().getName()+"取钱成功!金额为："+drawAmount);
				try {
					Thread.sleep(1000);//休眠一秒钟
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				balance -= drawAmount;
				System.out.println(Thread.currentThread().getName()+"账户余额为："+balance);
			}else{
				System.out.println(Thread.currentThread().getName()+"取钱失败！");
			}
		} finally{
			lock.unlock();
		}
		
	}
}
