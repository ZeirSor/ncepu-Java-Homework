package Point;

import java.util.Scanner;

public class TestPoint {

	// * 编写测试类Test，在该类中定义对象，并调用相应的函数。

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Please enter the coordinate value:");

		Scanner sc = new Scanner(System.in);
		double x = sc.nextDouble();
		double y = sc.nextDouble();

		Point p = new Point(x, y);
		p.showInfo();

		p.moveRight(7.2);
		p.moveDown(2.7);
		p.showInfo();
		
		/*  Please enter the coordinate value:
		*	0 0
		*	(x, y) = (0.0, 0.0)
		*	Modify successfully! The new pointer (x, y) = (7.2, 0.0)
		*	Modify successfully! The new pointer (x, y) = (7.2, -2.7)
		*	(x, y) = (7.2, -2.7)
		*/
	}

}
