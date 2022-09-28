package Exe2;

public class Circle extends Shape implements Draw {
	private float radius;

	@Override
	public int compareTo(Shape o) {
		if (this.getC() < o.getC())
			return -1;
		else if (this.getC() > o.getC())
			return 1;
		else
			return 0;
	}

	@Override
	public double getC() {
		return 4 * Math.PI * radius;
	}

	@Override
	public void drawShape() {
		// TODO Auto-generated method stub
		System.out.println("draw circle");
	}

	public Circle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Circle(float radius, int line_width, String line_type) {
		// TODO Auto-generated constructor stub
		super(line_width, line_type);
		this.radius = radius;
	}

	@Override
	public String toString() {
		return "Circle [radius=" + radius + "]";
	}

	public float getRadius() {
		return radius;
	}

	public void setRadius(float radius) {
		this.radius = radius;
	}

}
