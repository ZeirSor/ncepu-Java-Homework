package hk3;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

//	3、有一个货架（大小200），有两个生产商品的线程分别生产100个物品（可以是一个随机的int型变量）并存在货架中，编写程序模拟这个过程。

public class ProductionThread implements Callable<String> {

	private Random r = new Random();
	private int productions = 0;
	private GoodsShelve gs;

	public ProductionThread(GoodsShelve gs) {
		super();
		this.gs = gs;
	}

	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub

		while (!this.gs.isFull()) {
			int randProductions = this.r.nextInt(1, 10);
			this.productions += randProductions;

			System.out.println(Thread.currentThread().getName() + " produced " + randProductions + " items.\n"
					+ Thread.currentThread().getName() + " has produced " + productions + " items.");

			if (this.productions >= 100) {
				this.gs.addGoods(randProductions);
				System.out.println(Thread.currentThread().getName() + " stop!(100)");
				break;
			}

			synchronized (this) {
				if (!this.gs.addGoods(randProductions))
					System.out.println(Thread.currentThread().getName() + " stop!");
			}
		}
		return Thread.currentThread().getName() + " stop!";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GoodsShelve gs = new GoodsShelve(200);
		Callable<String> call_1 = new ProductionThread(gs);
		Callable<String> call_2 = new ProductionThread(gs);

		FutureTask<String> task_1 = new FutureTask<>(call_1);
		FutureTask<String> task_2 = new FutureTask<>(call_2);

		Thread th_1 = new Thread(task_1);
		Thread th_2 = new Thread(task_2);

		th_1.start();
		th_2.start();

		try {
			System.out.println(task_1.get());
			System.out.println(task_2.get());
		} catch (InterruptedException | ExecutionException e) {
			throw new RuntimeException(e);
		}
	}
}
