package pkg_homework1;

import java.util.Arrays;
import java.util.Scanner;

public class IntTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		1.编写一个整数数组（长度为5），
//		从键盘上依次输入所有的元素，
//		然后对数组进行排序，
//		最后使用foreach输出所有的元素。

		// 编写一个整数数组（长度为5）
		int[] arr = new int[5];

		// 从键盘上依次输入所有的元素，
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < arr.length; i++)
			arr[i] = sc.nextInt();

		// 然后对数组进行排序
		Arrays.sort(arr);
		
		// 最后使用foreach输出所有的元素。
		for (int x : arr)
			System.out.println(x);
			
		// imput
//		7
//		2
//		52
//		72
//		27
		
		//output
//		2
//		7
//		27
//		52
//		72

	}

}
