package class1107;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class MyCallable implements Callable<String> {

	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		String str = "this count is :";

		int sum = 0;
		for (int i = 1; i <= 50; i++) {
			sum += i;
		}
		str += sum;

		return str;
	}

}

public class Exe3 {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		MyCallable mc = new MyCallable();
		FutureTask<String> task = new FutureTask<>(mc);
		Thread t = new Thread(task);
		t.start();
		System.out.println(task.get());

	}
}
