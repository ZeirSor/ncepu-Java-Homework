package hk1;

//	1、分别采用Runnable和Thread方式创建线程完成100所有能够整除7的数字和，并显示。

public class ThreadSumTest {
	public static void main(String[] args) {
		ThreadSumA sma = new ThreadSumA();
		ThreadSumB smb = new ThreadSumB();

		Thread tha = new Thread(sma);
		tha.start();
		smb.start();
	}
}
