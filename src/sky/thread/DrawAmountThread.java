package sky.thread;

public class DrawAmountThread extends Thread{
	private Account account;
	private double drawBalance;
	public DrawAmountThread(String name,Account account,double drawBalance){
		super(name);
		this.account = account;
		this.drawBalance = drawBalance;
	}
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			account.draw(drawBalance);
			System.out.println("取款次数--》"+i);
		}
		
		super.run();
	}
	public static void main(String[] args) {
		Account account2 = new Account("F123456", 1000);
		new DrawAmountThread("甲", account2, 800).start();
		new DrawAmountThread("乙", account2, 800).start();
		
	}
}
