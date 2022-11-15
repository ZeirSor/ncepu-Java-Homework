package class1114.producer_consumer_model;

public class Producer implements Runnable {
	Shop shop;

	public Producer(Shop shop) {
		// TODO Auto-generated constructor stub
		this.shop = shop;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 6; i++) {
			Bread bread = new Bread(i);
			shop.push(bread);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
