package pkg_homework1;

import java.util.Scanner;

public class ComputerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		option();

		// output
//		please enter the type of the computer: 
//		 1. destop 
//		 2. laptop 
//		 0. exit
//		1
//		please enter the brand, price and processor:
//		ASUS
//		6599
//		i5
//		the imformation of the destop:
//		Destop [Brand = ASUS-destop, Price = 6599.0, Processor = i5]
//		The price level of this computer: B
//		2
//		please enter the brand, price and processor:
//		surface
//		8799
//		i7
//		the imformation of the laptop:
//		Destop [Brand = surface-Laptop, Price = 8799.0, Processor = i7]
//		The price level of this computer: A
//		1
//		please enter the brand, price and processor:
//		HUAWEI
//		13999
//		i9
//		the imformation of the destop:
//		Destop [Brand = HUAWEI-destop, Price = 13999.0, Processor = i9]
//		The price level of this computer: A
//		0
//		exit!
	}

	public static void option() {
		System.out.println("please enter the type of the computer: \n 1. destop \n 2. laptop \n 0. exit");
		Scanner sc = new Scanner(System.in);

		int opt;
		while ((opt = sc.nextInt()) != 0) {
			switch (opt) {
			case 1 -> {
				Destop des = new Destop();
				System.out.println("please enter the brand, price and processor:");
				String brand = sc.next();
				double price = sc.nextDouble();
				String processor = sc.next();
				des.setBrand(brand);
				des.setPrice(price);
				des.setProcessor(processor);
				des.showInfo();
				des.showPriceLevel();
			}

			case 2 -> {
				Laptop lap = new Laptop();
				System.out.println("please enter the brand, price and processor:");
				String brand = sc.next();
				double price = sc.nextDouble();
				String processor = sc.next();
				lap.setBrand(brand);
				lap.setPrice(price);
				lap.setProcessor(processor);
				lap.showInfo();
				lap.showPriceLevel();
			}
			
			default -> System.out.println("error, enter again please!");
			}
		}

		System.out.println("exit!");
	}

}
