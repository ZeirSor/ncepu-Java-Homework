package class1114.producer_consumer_model;

public class Consumer implements Runnable {
	Shop shop;

	public Consumer(Shop shop) {
		// TODO Auto-generated constructor stub
		this.shop = shop;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 12; i++) {
			Bread bread = new Bread(0);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			shop.pop();
		}
	}
}
