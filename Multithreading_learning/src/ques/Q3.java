package ques;

import java.util.Random;

/*3、模拟2个线程取钱，每个线程取5次，
 * 每次取钱金额是0-100内随机整数，
 * 取钱包括减少金额，打印信息两个步骤*/
class Money implements Runnable {
	@Override
	public void run() {
		// TODO Auto-generated method stub

		for (int i = 0; i < 5; i++) {

			synchronized (this) {
				Random random = new Random();
				int m = random.nextInt(0, 100);
				System.out.println(Thread.currentThread().getName() + "取出了" + m + "yuan");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}

}

public class Q3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Money m1 = new Money();
		Thread t1 = new Thread(m1);
		Thread t2 = new Thread(m1);
		t1.start();
		t2.start();

	}

}