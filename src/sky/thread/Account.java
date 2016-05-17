package sky.thread;
/**
 * 账户类
 * 提供账号，金额
 * @author Administrator
 *
 */
public class Account {
	private String accountNo;
	private double balance;
	private boolean flag = true;//是否存款
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public double getBalance() {
		return this.balance;
	}
	public Account(){}
	public Account(String accountNo,double balance){
		this.accountNo = accountNo;
		this.balance = balance;
	}
	/**
	 * 线程同步的即线程安全的
	 * 取钱的逻辑
	 * @param drawAmount 取钱的金额
	 */
	public synchronized void draw(double drawAmount) {
		try {
			if (!flag) {// 如果flag为假，说明没有存款进去，所以不能取钱
				wait();
			} else {
					System.out.println(Thread.currentThread().getName() + "取钱成功!金额为：" + drawAmount);

//					Thread.sleep(1000);// 休眠一秒钟

					balance -= drawAmount;
					System.out.println(Thread.currentThread().getName() + "账户余额为：" + balance);
				flag = false;//已取款标志
				notifyAll();//唤醒线程
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 存款方法
	 * @param depositAmount
	 */
	public synchronized void deposit(double depositAmount){
		try {
			if (flag) {// 如果flag为真，说明已经以有存款，所以不可以再次存款
				wait();
			} else {
					System.out.println(Thread.currentThread().getName() + "存款成功!金额为：" + depositAmount);

//					Thread.sleep(1000);// 休眠一秒钟

					balance += depositAmount;
					System.out.println(Thread.currentThread().getName()+ "账户余额为：" + balance);
				flag = true;//已存款标志
				notifyAll();//唤醒线程
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
