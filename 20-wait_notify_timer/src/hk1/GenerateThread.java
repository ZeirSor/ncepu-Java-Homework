package hk1;

public class GenerateThread implements Runnable {
	private int nums;
	boolean flag = true;
	int flag2 = 0;
	GenerateNumber gn = null;

	public GenerateThread(int nums, GenerateNumber gn) {
		this.nums = nums;
		this.gn = gn;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < nums; i++) {
			gn.generateUnrepeatNumber(nums * 2);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		synchronized (this) {
			if (flag) {
				gn.getWin();
				flag = false;
			}
		}
	}

	public static void main(String[] args) {

//		1、  2个线程依次产生0-9的随机整数，共产生5组，然后输出10组数字中获胜次数较多的线程。
//			例如，随机产生的数字为：4，3，5，6，3，5，6，8，7，9，
//			其中4>3, 5<6, 3<5, 6<8, 7<9，所以第二个线程获胜。

		GenerateNumber gn = new GenerateNumber();
		Runnable gt = new GenerateThread(5, gn);
		Thread t1 = new Thread(gt, "Thread 1");
		Thread t2 = new Thread(gt, "Thread 2");

		t1.start();
		t2.start();
	}
}
