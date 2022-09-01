package Complex;

public class TestComplex {

	// 在测试类中完成2个复数对象的构建完成相加并赋值给第3个复数对象。
	public static void main(String[] args) {
		Complex n1 = new Complex(2.7, 0);
		Complex n2 = new Complex(0, 7.2);

		n1.showInfo();
		n2.showInfo();

		Complex n3 = n1.add(n2);

		n3.showInfo();

		// 共轭复数test
		Complex n4 = n3.conjugate();
		n4.showInfo();

		System.out.println(n3.cmp(n4));

		Complex cmp1 = new Complex(1.1, 2.2);
		Complex cmp2 = new Complex(1.01, 2.02);
		System.out.println(cmp2.cmp(cmp1));

		Complex cmp3 = new Complex(2.1, 3.2);
		Complex cmp4 = new Complex(4.01, 4.02);
		System.out.println(cmp4.cmp(cmp3));

		// output
//		2.7 + 0.0i
//		0.0 + 7.2i
//		2.7 + 7.2i
//		2.7 - 7.2i
//		|2.7 + 7.2i| = |2.7 - 7.2i|
//		|1.01 + 2.02i| < |1.1 + 2.2i|
//		|4.01 + 4.02i| > |2.1 + 3.2i|

	}
}
