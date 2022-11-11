package hk3;

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
