package Complex;

public class Complex {

	// 编写复数类，为该类定义信息输出方法、两个复数相加的方法

	private double r;
	private double i;

	public Complex() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Complex(double r, double i) {
		super();
		this.r = r;
		this.i = i;
	}

	@Override
	public String toString() {
		return "Complex number: " + r + " + " + i + "i";
	}

	public void showInfo() {
		System.out.println(this.toString());
	}

	public static Complex add(Complex number1, Complex number2) {
		Complex newNumber = new Complex(0, 0);
		newNumber.r = number1.r + number2.r;
		newNumber.i = number1.i + number2.i;
		return newNumber;
	}

	public double getR() {
		return r;
	}

	public void setR(double r) {
		this.r = r;
	}

	public double getI() {
		return i;
	}

	public void setI(double i) {
		this.i = i;
	}

}
