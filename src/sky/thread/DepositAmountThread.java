package sky.thread;

public class DepositAmountThread extends Thread{
	private Account account;
	private double depositBalance;
	public DepositAmountThread(String name,Account account,double depositBalance){
		super(name);
		this.account = account;
		this.depositBalance = depositBalance;
	}
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			account.deposit(depositBalance);
			System.out.println("存款次数--》"+i);
		}
		super.run();
	}
	
}
