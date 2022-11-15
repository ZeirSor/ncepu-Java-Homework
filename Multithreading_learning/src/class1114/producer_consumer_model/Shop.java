package class1114.producer_consumer_model;

public class Shop {
	Bread[] breads = null;
	int index;

	public Shop() {
		breads = new Bread[3];
		index = 0;
	}

	public synchronized void push(Bread bread) {
		while (index == breads.length)
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		breads[index++] = bread;
		System.out.println(Thread.currentThread().getName() + " 生产了1个面包，当前面包数量为" + index);
		this.notify();

	}

	public synchronized Bread pop() {
		// TODO Auto-generated method stub
		while (index == 0)
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		index--;
		System.out.println(Thread.currentThread().getName() + "消费了1个面包，当前面包数量为" + index);
		this.notify();
		return breads[index];
	}
}
