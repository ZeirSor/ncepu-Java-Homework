package class1107;

import java.util.Date;
//class SellTicket extends Thread {
//
//	private int tickets = 50;
//
//	@Override
//	public void run() {
//		// TODO Auto-generated method stub
//		super.run();
//		for (; tickets > 0; tickets--) {
//			System.out.println("sell tickets:" + tickets);
//		}
//	}
//}

class SellTicket implements Runnable {

	private int tickets = 50;

	@Override
	public void run() {
		// TODO Auto-generated method stub
//		super.run();
		for (; tickets > 0; tickets--) {
			System.out.println(Thread.currentThread().getName() + " sell tickets:" + tickets);
		}
	}
}

class th implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
//		线程体
		test();
	}

	public void test() {
		for (int i = 0; i < 100; i++) {
			Date now = new Date();
			System.out.println("MyThreadB: " + i + " " + now.toString());
		}
	}

}

public class Exe2 {
	public static void main(String[] args) {
//		SellTicket st = new SellTicket();
//		st.start();
//		st.start();
//		一个对象只能start一次

//		SellTicket st1 = new SellTicket();
//		SellTicket st2= new SellTicket();
//		SellTicket st3 = new SellTicket();
//		几个线程共享票 --> runnble()

		SellTicket st = new SellTicket();
		Thread t1 = new Thread(st);
		Thread t2 = new Thread(st);
		Thread t3 = new Thread(st);

		t1.start();
		t2.start();
		t3.start();

//		t1.setPriority(Thread.MIN_PRIORITY);
	}
}
