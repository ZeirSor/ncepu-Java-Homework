package pkg_homework2;

public class RectangleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		编写一个测试类，对以上两个类进行测试，创建一个长方体，定义其长、宽、高，输出其底面积和体积。

		Rectangle rec = new Rectangle(3.14, 2.71);
		rec.showInfo();
		System.out.println("Area: " + rec.calcArea());

		Cuboid cub = new Cuboid(2.71, 3.14, 6.66);
		cub.showInfo();
		System.out.println("Area: " + cub.calcArea());
		System.out.println("Volume: " + cub.calcVolume());

		// output
//		Rectangle [width = 3.14, length = 2.71]
//		Area: 8.5094
//		cuboid [width = 2.71, length = 3.14height=6.66]
//		Area: 8.5094
//		Volume: 56.672604
	}

}
