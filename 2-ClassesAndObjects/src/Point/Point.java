package Point;

public class Point {
	/*
	 * 1．设计Point类用来定义平面上的一个点坐标，包含向右平移和向下平移的方法。
	 */

	private double x;
	private double y;

	public void moveRight(double dis) {
		this.x += dis;
		System.out.println("Modify successfully! The new pointer " + this.toString());
	}

	public void moveDown(double dis) {
		this.y -= dis;
		System.out.println("Modify successfully! The new pointer " + this.toString());
	}

	public Point() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Point(double x, double y) {
		super();
		this.x = x;
		this.y = y;
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

	@Override
	public String toString() {
		return "(x, y) = " + "(" + x + ", " + y + ")";
	}

	public void showInfo() {
		System.out.println(this.toString());
	}

}
