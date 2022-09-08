package pkg_homework1;

//编程电脑类，然后派生台式机和笔记本两个子类，成员变量和成员方法自己定义。编程测试类分别创建3个类的对象，并调用所有的方法。

//电脑类
class Computer {
	private String brand;
	private double price;
	private String processor;

	public void showPriceLevel() {
		double p = this.price;
		if (this.price >= 2000 && this.price <= 4000) {
			System.out.println("The price level of this computer: D");
		} else if (this.price > 4000 && this.price <= 6000) {
			System.out.println("The price level of this computer: C");
		} else if (this.price >= 6000 && this.price <= 8000) {
			System.out.println("The price level of this computer: B");
		} else {
			System.out.println("The price level of this computer: A");
		}
	}
	
	public Computer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Computer(String brand, double price, String processor) {
		super();
		this.brand = brand;
		this.price = price;
		this.processor = processor;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getProcessor() {
		return processor;
	}

	public void setProcessor(String processor) {
		this.processor = processor;
	}
}

//台式机类
class Destop extends Computer {
	@Override
	public void setBrand(String brand) {
		// TODO Auto-generated method stub
		super.setBrand(brand + "-destop");
	}

	@Override
	public String toString() {
		return "Destop [Brand = " + getBrand() + ", Price = " + getPrice() + ", Processor = " + getProcessor() + "]";
	}

	public void showInfo() {
		System.out.println("the imformation of the destop:");
		System.out.println(this.toString());
	}

}

//笔记本类
class Laptop extends Computer {
	@Override
	public void setBrand(String brand) {
		// TODO Auto-generated method stub
		super.setBrand(brand + "-Laptop");
	}

	@Override
	public String toString() {
		return "Destop [Brand = " + getBrand() + ", Price = " + getPrice() + ", Processor = " + getProcessor() + "]";
	}

	public void showInfo() {
		System.out.println("the imformation of the laptop:");
		System.out.println(this.toString());
	}

}