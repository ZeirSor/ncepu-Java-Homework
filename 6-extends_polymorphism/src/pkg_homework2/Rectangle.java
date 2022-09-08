package pkg_homework2;

//	2. （1）定义一个类，描述一个矩形，包含有长、宽两种属性，和计算面积方法。
//	   （2）编写一个类，继承自矩形类，该类描述长方体，具有长、宽、高属性，和计算体积的方法。
//	   （3）编写一个测试类，对以上两个类进行测试，创建一个长方体，定义其长、宽、高，输出其底面积和体积。

class Rectangle {
	private double width;
	private double length;
	
	public double calcArea() {
		return this.width * this.length;
	}
	
	public Rectangle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Rectangle(double width, double length) {
		super();
		this.width = width;
		this.length = length;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	@Override
	public String toString() {
		return "Rectangle [width = " + width + ", length = " + length + "]";
	}
	
	public void showInfo() {
		System.out.println(this.toString());
	}
	
}

class Cuboid extends Rectangle {
	private double height;

	public double calcVolume() {
		return super.calcArea() * this.height;
	}
	
	public Cuboid() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cuboid(double width, double length, double height) {
		super(width, length);
		// TODO Auto-generated constructor stub
		this.height = height;
	}

	@Override
	public String toString() {
		return "cuboid [width = " + super.getWidth() + ", length = " + super.getLength() + "height=" + height + "]";
	}
	
	public void showInfo() {
		System.out.println(this.toString());
	}
}

