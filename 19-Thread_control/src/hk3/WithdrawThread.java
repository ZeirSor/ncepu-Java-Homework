package hk3;

import java.util.Random;

public class WithdrawThread extends Thread {

	private Account account;

	private int freq;

	private Random r = new Random();

	public WithdrawThread(String name, Account account, int freq) {
		super(name);
		this.account = account;
		this.freq = freq;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < freq; i++) {
			if (account.getMoney() == 0) {
				System.out.println("Account balance is zero!!! Please recharge！！！");
				break;
			}
			account.withdraw(r.nextInt(0, 101));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + " finish!");
	}
}
