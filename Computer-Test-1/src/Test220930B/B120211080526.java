package Test220930B;
//题目B：

//超市物品管理系统
//超市可以进货各种商品，并且可以盘点商品信息。
//系统功能需求：
//（1）创建一个超市，可以指定超市中可容纳的最大商品数量（缺省为6）。
//（2）超市可以进货并上架小电器、食品等各类商品。进货时如果已经存在同类商品，则进货失败。
//（3）能够显示超市中所有商品的信息（食品：名称 + 单价+数量+保质期（天）；小电器：名称 + 单价 + 数量 +工作电压）。
//（4）按要求统计某一类商品的总价值。
//（5）依次盘点超市中所有商品的信息（输出：商品名称+“盘点完成”）。
//测试类中主方法的测试流程：（所有对象直接创建，不需要从键盘输入）
//（1）创建一个超市对象
//（2）进货食品：矿泉水 0  20  60   
//（3）进货食品：面包 0   10  7
//（4）进货小电器：风扇 0  5  220
//（5）进货食品：矿泉水0 15  60（应显示进货失败）
//（6）显示该超市所有商品的信息
//（7）查询该超市中食品的个数

import java.util.ArrayList;

public class B120211080526 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println("hello world!");
		Supermarket s = new Supermarket();
		System.out.println(s.getMaxCount());

		Supermarket supermarket = new Supermarket(100);

		System.out.println("超市最大容量" + supermarket.getMaxCount());

		Goods[] goods = new Goods[4];
		goods[0] = new Foods("矿泉水", 3.5, 20, 60);
		goods[1] = new Foods("面包", 5, 10, 7);
		goods[2] = new Electricals("风扇", 100, 5, 220);
		goods[3] = new Foods("矿泉水", 3.5, 15, 60);

		for (Goods g : goods) {
			supermarket.addGoods(g);
		}

		System.out.println("超市的商品信如下");
		supermarket.showAll();

		System.out.println("现有商品总量: " + supermarket.getCount());

		System.out.println("超市中食品的个数: " + supermarket.countFoods());

		System.out.println("矿泉水的总价值: " + supermarket.allPrice("矿泉水"));
		System.out.println("面包的总价值: " + supermarket.allPrice("面包"));
		System.out.println("风扇的总价值: " + supermarket.allPrice("风扇"));

		// 6
		// 超市最大容量100
		// 进货失败
		// 超市的商品信如下
		// Foods [name=矿泉水, price=3.5, count=20, qualityDays=60]
		// Foods [name=面包, price=5.0, count=10, qualityDays=7]
		// Electricals [name=风扇, price=100.0, count=5, workingU=220.0]
		// 现有商品总量: 35
		// 超市中食品的个数: 30
		// 矿泉水的总价值: 70.0
		// 面包的总价值: 50.0
		// 风扇的总价值: 500.0

	}

}

interface Stastic {
	double allPrice(String name);

	Goods findGoods(String name);

	void showAll();
}

class Supermarket implements Stastic {
	private int maxCount;

	private int count = 0;

	private ArrayList<Goods> goodsList = new ArrayList<>();

	public int countFoods() {
		int count = 0;
		for (Goods g : goodsList) {
			if (g instanceof Foods)
				count += g.getCount();
		}

		return count;
	}

	@Override
	public void showAll() {
		// TODO Auto-generated method stub
		goodsList.forEach(good -> {
			System.out.println(good.toString());
		});
	}

	@Override
	public Goods findGoods(String name) {
		// TODO Auto-generated method stub
		for (Goods g : goodsList) {
			if (g.getName().equals(name))
				return g;
		}
		return null;
	}

	@Override
	public double allPrice(String name) {
		// TODO Auto-generated method stub
		Goods find = findGoods(name);
		return find.getCount() * find.getPrice();
	}

	public boolean isContains(Goods good) {
		for (Goods g : goodsList) {
			if (good.getName().equals(g.getName()))
				return true;
		}
		return false;
	}

	public void addGoods(Goods goods) {
		if (isContains(goods)) {
			System.out.println("进货失败");
			return;
		}
		goodsList.add(goods);
		this.count += goods.getCount();
	}

	public int getMaxCount() {
		return maxCount;
	}

	public void setMaxCount(int maxCount) {
		this.maxCount = maxCount;
	}

	public Supermarket() {
		super();
		// TODO Auto-generated constructor stub
		this.maxCount = 6;
	}

	public Supermarket(int maxCount) {
		super();
		this.maxCount = maxCount;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}

abstract class Goods {
	private String name;
	private double price;
	private int count;

	public Goods() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Goods(String name, double price, int count) {
		super();
		this.name = name;
		this.price = price;
		this.count = count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "name=" + name + ", price=" + price + ", count=" + count;
	}

}

class Foods extends Goods {

	private int qualityDays;

	public Foods() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Foods(String name, double price, int count, int qualityDays) {
		super(name, price, count);
		// TODO Auto-generated constructor stub
		this.qualityDays = qualityDays;
	}

	public int getQualityDays() {
		return qualityDays;
	}

	public void setQualityDays(int qualityDays) {
		this.qualityDays = qualityDays;
	}

	@Override
	public String toString() {
		return "Foods [" + super.toString() + ", qualityDays=" + qualityDays + "]";
	}

}

class Electricals extends Goods {
	private double workingU;

	public Electricals() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Electricals(String name, double price, int count, double workingU) {
		super(name, price, count);
		// TODO Auto-generated constructor stub
		this.workingU = workingU;
	}

	public double getWorkingU() {
		return workingU;
	}

	public void setWorkingU(double workingU) {
		this.workingU = workingU;
	}

	@Override
	public String toString() {
		return "Electricals [" + super.toString() + ", workingU=" + workingU + "]";
	}

}
