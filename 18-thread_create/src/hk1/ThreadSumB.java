package hk1;

import java.util.Date;

public class ThreadSumB extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		int sum = 0;
		// TODO Auto-generated method stub
		for (int i = 1; i <= 100; i++) {

			if (i % 7 == 0) {
				Date now = new Date();
				sum += i;
				System.out.println("ThreadSumB: " + i + " " + now.toString());
			}

		}
		System.out.println("B sum = " + sum);
	}

}
