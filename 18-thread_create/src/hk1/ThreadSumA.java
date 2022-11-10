package hk1;

import java.util.Date;

public class ThreadSumA implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		getSum();
	}

	private void getSum() {
		int sum = 0;
		// TODO Auto-generated method stub
		for (int i = 1; i <= 100; i++) {

			if (i % 7 == 0) {
				Date now = new Date();
				sum += i;
				System.out.println("ThreadSumA: " + i + " " + now.toString());
			}

		}
		System.out.println("A sum = " + sum);
	}

}
