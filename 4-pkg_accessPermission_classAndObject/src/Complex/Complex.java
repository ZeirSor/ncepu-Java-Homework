package Complex;


public class Complex {

	private double r;
	private double i;

	//为Complex类增加成员方法，返回共轭复数。
	public Complex conjugate() {
		Complex newNumber = new Complex();
		newNumber.r = this.getR();
		newNumber.i = -this.getI();
		return newNumber;
	}
	
	// 用来比较两个复数的模，返回比较结果
	public String cmp(Complex cmp) {
		double r_1 = this.getR() * this.getR();
		double i_1 = this.getI() * this.getI();
		
		double r_2 = cmp.getR() * cmp.getR();
		double i_2 = cmp.getI() * cmp.getI();
		
		if (r_1 + i_1 > r_2 + i_2)
			return "|" + this.toString() + "| > |" + cmp.toString() + "|";
		else if (r_1 + i_1 < r_2 + i_2)
			return "|" + this.toString() + "| < |" + cmp.toString() + "|";
		else
			return "|" + this.toString() + "| = |" + cmp.toString() + "|";
	}
	
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
		if (this.getI() >= 0)
			return r + " + " + i + "i";
		else
			return r + " - " + (-i) + "i";
	}

	public void showInfo() {
		System.out.println(this.toString());
	}

	public Complex add(Complex num) {
		Complex newNumber = new Complex(0, 0);
		newNumber.r = num.getR() + this.getR();
		newNumber.i = num.getI() + this.getI();
		return newNumber;
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
