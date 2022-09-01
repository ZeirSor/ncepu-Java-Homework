package Complex;

public class TestComplex {

	// 在测试类中完成2个复数对象的构建完成相加并赋值给第3个复数对象。
	public static void main(String[] args) {
		Complex n1 = new Complex(2.7, 0);
		Complex n2 = new Complex(0, 7.2);

		n1.showInfo();
		n2.showInfo();

		Complex n3 = Complex.add(n1, n2);

		n3.showInfo();

		/*
		 *  Complex number: 2.7 + 0.0i
		 *	Complex number: 0.0 + 7.2i
		 *	Complex number: 2.7 + 7.2i
		 */

	}
}
