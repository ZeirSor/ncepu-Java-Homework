package Exe2;

public abstract class Shape {
	private int line_width;
	private String line_type;

	public abstract double getC();

	public Shape() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Shape(int line_width, String line_type) {
		super();
		this.line_width = line_width;
		this.line_type = line_type;
	}

	public int getLine_width() {
		return line_width;
	}

	public void setLine_width(int line_width) {
		this.line_width = line_width;
	}

	public String getLine_type() {
		return line_type;
	}

	public void setLine_type(String line_type) {
		this.line_type = line_type;
	}

	@Override
	public String toString() {
		return "Shape [line_width=" + line_width + ", line_type=" + line_type + "]";
	}

}
