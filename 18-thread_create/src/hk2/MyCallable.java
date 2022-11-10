package hk2;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

//	2、采用Callable方式创建线程，并返回100所有能够整除7的数字和，在主方法中显示结果。

public class MyCallable implements Callable<String> {

	private int n;

	public MyCallable(int n) {
		super();
		this.n = n;
	}

	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		int sum = 0;
		for (int i = 1; i <= 100; i++)
			if (i % 7 == 0)
				sum += i;

		return Thread.currentThread().getName() + " gets the result: " + sum;
	}

	public static void main(String[] args) {
		Callable<String> call = new MyCallable(100);
		FutureTask<String> task = new FutureTask<>(call);
		new Thread(task).start();

		try {
			System.out.println(task.get());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
