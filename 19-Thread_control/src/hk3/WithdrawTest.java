package hk3;

public class WithdrawTest {
	public static void main(String[] args) {
		Account account = new Account(527);
		WithdrawThread th1 = new WithdrawThread("Xiao Hong", account, 5);
		WithdrawThread th2 = new WithdrawThread("Xiao Ming", account, 5);

		th1.start();
		th2.start();
	}
}
