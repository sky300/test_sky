package sky.thread;

public class TestDraw {
	public static void main(String[] args) {
		Account account = new Account();
		new DrawAmountThread("取钱人甲", account, 800).start();
//		new DrawAmountThread("取钱人乙", account, 800).start();
//		new DrawAmountThread("取钱人丙", account, 800).start();
		new DepositAmountThread("存钱甲", account, 800).start();
//		new DepositAmountThread("存钱乙", account, 800).start();
//		new DepositAmountThread("存钱丙", account, 800).start();
	}
}
