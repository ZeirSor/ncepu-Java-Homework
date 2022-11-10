package class1107;

import java.util.Date;

class MyThreadA extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		for (int i = 0; i < 100; i++) {
			Date now = new Date();
//			创建对象会耗时
			System.out.println("MyThreadA_1: " + i + " " + now.toString());
			System.out.println("MyThreadA_2: " + i);
		}
	}
//	public void run() {
//		for (int i = 0; i < 100; i++) {
//			System.out.println("myThread: " + i);
//		}
//	}

}

class MyThreadB implements Runnable {

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

public class Exe1 {
	public static void main(String[] args) {
//		new MyThread().run();
//		new MyThread().start();
//		MyThreadA mt = new MyThreadA();
//		mt.start();
//		for (int i = 0; i < 100; i++) {
//			System.out.println("Main: " + i);
//		}
//
//		System.out.println("-----------------------");
//
//		MyThreadB mt2 = new MyThreadB();
//		Thread td = new Thread(mt2);
//		td.start();

		MyThreadA mta = new MyThreadA();
		MyThreadB mtb = new MyThreadB();
		Thread th = new Thread(mtb);
		mta.start();
		th.start();

		System.out.println("-------------------");

		Date now = new Date();

		for (int i = 0; i < 100; i++) {
			System.out.println("Main: " + i + " " + now.toString());
		}

//		取 转 原子操作

	}
}
