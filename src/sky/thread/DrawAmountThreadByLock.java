package sky.thread;

public class DrawAmountThreadByLock extends Thread{
	private AccountByLock account;
	private double drawBalance;
	public DrawAmountThreadByLock(String name,AccountByLock account,double drawBalance){
		super(name);
		this.account = account;
		this.drawBalance = drawBalance;
	}
	@Override
	public void run() {
		account.draw(drawBalance);
		super.run();
	}
	public static void main(String[] args) {
		AccountByLock account2 = new AccountByLock("F123456", 1000);
		new DrawAmountThreadByLock("甲", account2, 800).start();
		new DrawAmountThreadByLock("乙", account2, 800).start();
		
	}
}
