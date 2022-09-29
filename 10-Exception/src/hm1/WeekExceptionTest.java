package hm1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class WeekExceptionTest {

//	1．输入一个1~7之间的整数表示星期几，输出对应的英文单词（表示星期几）。
//	要求捕获以下异常：
//		类型不匹配异常，如输入的是字符串等
//		输入的数值范围不合理，如>7或<1

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("----------Week Test----------");
		System.out.println("Please enter an integer from 1 to 7");

		int week;

		try {
			week = sc.nextInt();
			switch (week) {
			case 1 -> System.out.println("Monday");
			case 2 -> System.out.println("Tuesday");
			case 3 -> System.out.println("Wednesday");
			case 4 -> System.out.println("Thursday");
			case 5 -> System.out.println("Friday");
			case 6 -> System.out.println("Saturday");
			case 7 -> System.out.println("Sunday");
			default -> throw new IllegalArgumentException("Unexpected value: " + week);
			}
		} catch (InputMismatchException e) {
			// TODO: handle exception
			System.out.println(e);
			System.out.println("Exception: Input data types do not match.!");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			System.out.println("Exception: The input data must be an integer ranging from 1 to 7");
		} finally {
			System.out.println("exit!");
			sc.close();
			System.exit(0);
		}

//		----------Week Test----------
//		Please enter an integer from 1 to 7
//		0
//		java.lang.IllegalArgumentException: Unexpected value: 0
//		Exception: The input data must be an integer ranging from 1 to 7
//		exit!
//		----------Week Test----------
//		Please enter an integer from 1 to 7
//		4
//		Thursday
//		exit!
//		----------Week Test----------
//		Please enter an integer from 1 to 7
//		asdf
//		java.util.InputMismatchException
//		Exception: Input data types do not match.!
//		exit!
	}
}
