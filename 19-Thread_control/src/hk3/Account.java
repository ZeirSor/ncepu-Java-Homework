package hk3;

//	3、模拟2个线程取钱，每个线程取5次，每次取钱金额是0-100内随机整数，取钱包括减少金额，打印信息两个步骤

public class Account {
	private int money;

	public Account(int money) {
		super();
		this.money = money;
	}

	public boolean withdraw(int moneys) {
		if (this.money == 0) {

			return false;
		}
		synchronized (this) {
			if (this.money >= moneys) {
				this.money -= moneys;
				System.out.println(Thread.currentThread().getName() + " took " + moneys + " yuan.\t" + this.money
						+ " yuan left in the account");
				return true;
			} else {
				System.out.println(Thread.currentThread().getName() + " wants to take " + moneys
						+ " yuan.\tInsufficient account balance！ The account only has " + this.money + " yuan.");
				return false;
			}

		}
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

}
