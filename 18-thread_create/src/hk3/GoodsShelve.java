package hk3;

//	3、有一个货架（大小200），有两个生产商品的线程分别生产100个物品（可以是一个随机的int型变量）并存在货架中，编写程序模拟这个过程。

public class GoodsShelve {
	private int size = 0;
	private int maxSize;

	public GoodsShelve(int maxSize) {
		super();
		this.maxSize = maxSize;
	}

	public synchronized boolean addGoods(int num) {
		this.size += num;
		if (!isFull()) {
			System.out.println(Thread.currentThread().getName() + " add " + num
					+ " goods into the shelves. now the size of the shelves is " + this.size);
		} else {
			int overSize = this.size - this.maxSize;
			System.out.println(Thread.currentThread().getName() + " Successfully add " + (num - overSize)
					+ " goods into the Shelve. There are " + overSize
					+ " items left that have not been added.\nThe Goods Shelve is full!");
			this.size = this.maxSize;
			return false;
		}

		return true;
	}

	public boolean isFull() {
		if (this.size >= this.maxSize)
			return true;
		else
			return false;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getMaxSize() {
		return maxSize;
	}

	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}
}
