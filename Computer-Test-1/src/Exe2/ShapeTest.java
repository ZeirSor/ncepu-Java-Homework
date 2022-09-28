package Exe2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

public class ShapeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Draw[] d = new Draw[4];

		d[3] = new Triangle(3, 4, 5, 1, "line type");
		d[2] = new Triangle(1, 3, 3, 1, "line type");
		d[1] = new Circle(1, 1, "line type");
		d[0] = new Circle(2, 1, "line type");

		for (Draw draw : d) {
			System.out.println(draw.toString());
		}

		System.out.println("-----------ArrayList-----------");

		ArrayList<Draw> list = new ArrayList<>();

		for (Draw draw : d) {
			list.add(draw);
		}

		Iterator<Draw> iterator = list.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next().toString());
		}

		System.out.println("-------------array sort------------------");
		Arrays.sort(d);
		for (Draw draw : d) {
			System.out.println(draw);
		}

		System.out.println("--------------------sort test--------------------------");

		// 排序测试

		System.out.println("--------------------circle sort test--------------------------");

		// circle
		Draw[] d_sort_circle = new Draw[5];
		d_sort_circle[0] = new Circle(1, 1, "line type");
		d_sort_circle[1] = new Circle(5, 1, "line type");
		d_sort_circle[2] = new Circle(2, 1, "line type");
		d_sort_circle[3] = new Circle(4, 1, "line type");
		d_sort_circle[4] = new Circle(3, 1, "line type");

		ArrayList<Draw> list_circle = new ArrayList<>();

		for (Draw draw : d_sort_circle) {
			list_circle.add(draw);
		}

		list_circle.forEach(s -> System.out.println(s));

		System.out.println("--------------------circle after sort--------------------------");

		Arrays.sort(d_sort_circle);
		for (Draw draw : d_sort_circle) {
			System.out.println(draw);
		}

		System.out.println("--------------------triangle sort test--------------------------");

		// triangle
		Draw[] d_sort_triangle = new Draw[5];
		d_sort_triangle[0] = new Triangle(1, 3, 3, 1, "line type");
		d_sort_triangle[1] = new Triangle(6, 8, 10, 1, "line type");
		d_sort_triangle[2] = new Triangle(3, 4, 5, 1, "line type");
		d_sort_triangle[3] = new Triangle(1, 2, 2, 1, "line type");
		d_sort_triangle[4] = new Triangle(1, 1, 1, 1, "line type");

		ArrayList<Draw> list_triangle = new ArrayList<>();

		for (Draw draw : d_sort_triangle) {
			list_triangle.add(draw);
		}
		list_triangle.forEach(s -> System.out.println(s));

		System.out.println("--------------------triangle after sort--------------------------");

		Arrays.sort(d_sort_triangle);

//        Arrays.sort(d_sort_triangle, new Comparator<Draw>() {
//            @Override
//            public int compare(Draw o1, Draw o2) {
//                if (o1.getC() < o2.getC())
//                    return -1;
//                else if (o1.getC() > o2.getC())
//                    return 1;
//                else return 0;
//            }
//        });

		for (Draw draw : d_sort_triangle) {
			System.out.println(draw);
		}

		System.out.println("------------for list------------------");
		list_triangle.forEach(s -> System.out.println(s));
		System.out.println("---------- list after sort-----------");
		list.sort(new Comparator<Draw>() {
			@Override
			public int compare(Draw o1, Draw o2) {
				return Double.compare(o1.getC(), o2.getC());
			}
		});
		list.forEach(draw -> System.out.println(draw));

	}

//    Circle [radius=2.0]
//    Circle [radius=1.0]
//    Triangle [size_1=1.0, size_2=3.0, size_3=3.0]
//    Triangle [size_1=3.0, size_2=4.0, size_3=5.0]
//            -----------ArrayList-----------
//    Circle [radius=2.0]
//    Circle [radius=1.0]
//    Triangle [size_1=1.0, size_2=3.0, size_3=3.0]
//    Triangle [size_1=3.0, size_2=4.0, size_3=5.0]
//            -------------array sort------------------
//    Triangle [size_1=1.0, size_2=3.0, size_3=3.0]
//    Triangle [size_1=3.0, size_2=4.0, size_3=5.0]
//    Circle [radius=1.0]
//    Circle [radius=2.0]
//            --------------------sort test--------------------------
//            --------------------circle sort test--------------------------
//    Circle [radius=1.0]
//    Circle [radius=5.0]
//    Circle [radius=2.0]
//    Circle [radius=4.0]
//    Circle [radius=3.0]
//            --------------------circle after sort--------------------------
//    Circle [radius=1.0]
//    Circle [radius=2.0]
//    Circle [radius=3.0]
//    Circle [radius=4.0]
//    Circle [radius=5.0]
//            --------------------triangle sort test--------------------------
//    Triangle [size_1=1.0, size_2=3.0, size_3=3.0]
//    Triangle [size_1=6.0, size_2=8.0, size_3=10.0]
//    Triangle [size_1=3.0, size_2=4.0, size_3=5.0]
//    Triangle [size_1=1.0, size_2=2.0, size_3=2.0]
//    Triangle [size_1=1.0, size_2=1.0, size_3=1.0]
//            --------------------triangle after sort--------------------------
//    Triangle [size_1=1.0, size_2=1.0, size_3=1.0]
//    Triangle [size_1=1.0, size_2=2.0, size_3=2.0]
//    Triangle [size_1=1.0, size_2=3.0, size_3=3.0]
//    Triangle [size_1=3.0, size_2=4.0, size_3=5.0]
//    Triangle [size_1=6.0, size_2=8.0, size_3=10.0]
//            ------------for list------------------
//    Triangle [size_1=1.0, size_2=3.0, size_3=3.0]
//    Triangle [size_1=6.0, size_2=8.0, size_3=10.0]
//    Triangle [size_1=3.0, size_2=4.0, size_3=5.0]
//    Triangle [size_1=1.0, size_2=2.0, size_3=2.0]
//    Triangle [size_1=1.0, size_2=1.0, size_3=1.0]
//            ---------- list after sort-----------
//    Triangle [size_1=1.0, size_2=3.0, size_3=3.0]
//    Triangle [size_1=3.0, size_2=4.0, size_3=5.0]
//    Circle [radius=1.0]
//    Circle [radius=2.0]

}
