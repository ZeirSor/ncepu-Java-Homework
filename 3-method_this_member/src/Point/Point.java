package Point;

public class Point {
//	1．设计Point类用来定义平面上的一个点坐标，包含向右平移和向下平移的方法。）
//	补充：为Point类添加至少2个构造方法，并添加类成员变量来统计Point对象的个数。
	private double x;
	private double y;
	private static int count = 0;

	// 统计对象个数
	public static void showCount() {
		if (count == 0) {
			System.out.println("No object has been created.");
		} else if (count == 1) {
			System.out.println("1 object has been created.");
		} else {
			System.out.println(Point.count + " object has been created.");
		}

	}

	// 向右平移
	public void moveRight(double dis) {
		this.x += dis;
		System.out.println("Modify successfully! The new pointer " + this.toString());
	}

	// 向下平移
	public void moveDown(double dis) {
		this.y -= dis;
		System.out.println("Modify successfully! The new point " + this.toString());
	}

	public Point() {
		super();
		// TODO Auto-generated constructor stub
		count++;
	}

	public Point(double x, double y) {
		super();
		this.x = x;
		this.y = y;
		count++;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public static int getCount() {
		return count;
	}

	@Override
	public String toString() {
		return "(x, y) = " + "(" + x + ", " + y + ")";
	}

	public void showInfo() {
		System.out.println(this.toString());
	}

}
