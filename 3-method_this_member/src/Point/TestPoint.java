package Point;

import java.util.Scanner;

public class TestPoint {
//	编写测试类Test，在该类中定义对象，并调用相应的函数。
//	（本题为上一次作业题目，在此基础上完成本次作业）

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Point.showCount();

		Point p1 = new Point();
		p1.showInfo();
		Point.showCount();

		System.out.println("Please enter the coordinate value:");

		Scanner sc = new Scanner(System.in);
		double x = sc.nextDouble();
		double y = sc.nextDouble();

		Point p2 = new Point(x, y);
		p2.showInfo();
		p2.moveDown(5.2);
		p2.moveRight(6.6);
		Point.showCount();

		// output
//		No object has been created.
//		(x, y) = (0.0, 0.0)
//		1 object has been created.
//		Please enter the coordinate value:
//		3.14 2.71
//		(x, y) = (3.14, 2.71)
//		Modify successfully! The new point (x, y) = (3.14, -2.49)
//		Modify successfully! The new pointer (x, y) = (9.74, -2.49)
//		2 object has been created.
	}

}
