package Exe2;

public class Triangle extends Shape implements Draw {
	private float size_1;
	private float size_2;
	private float size_3;

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
		return size_1 + size_2 + size_3;
	}

	@Override
	public void drawShape() {
		// TODO Auto-generated method stub
		System.out.println("draw Triangle");

	}

	public Triangle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Triangle(float size_1, float size_2, float size_3, int line_width, String line_type) {
		super(line_width, line_type);
		// TODO Auto-generated constructor stub
		if (isStandard(size_1, size_2, size_3)) {
			this.size_1 = size_1;
			this.size_2 = size_2;
			this.size_3 = size_3;
		} else
			return;
	}

	public boolean isStandard(float size_1, float size_2, float size_3) {
		if (size_1 + size_2 > size_3 && size_2 + size_3 > size_1 && size_1 + size_3 > size_2) {
			return true;
		} else {
			System.out.println("not standard!");
			return false;
		}
	}

	public float getSize_1() {
		return size_1;
	}

	public void setSize_1(float size_1) {
		this.size_1 = size_1;
	}

	public float getSize_2() {
		return size_2;
	}

	public void setSize_2(float size_2) {
		this.size_2 = size_2;
	}

	public float getSize_3() {
		return size_3;
	}

	public void setSize_3(float size_3) {
		this.size_3 = size_3;
	}

	@Override
	public String toString() {
		return "Triangle [size_1=" + size_1 + ", size_2=" + size_2 + ", size_3=" + size_3 + "]";
	}

}
