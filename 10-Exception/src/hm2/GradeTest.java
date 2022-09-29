package hm2;

import java.util.Scanner;

public class GradeTest {

//	在测试类中定义一个静态方法,参数是数组，功能用于计算数组元素的平均值，并可能抛出异常，
//	在主方法中定义一个成绩数组，调用静态方法，并捕获异常。

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("please input the total number ");
		int num = sc.nextInt();

		System.out.println("Please enter " + num + " numbers one by one");
		double[] grade = new double[num];
		for (int i = 0; i < num; i++) {
			grade[i] = sc.nextDouble();
		}

		try {
			double ave = calcAverage(grade);
			System.out.println("Average Grade :" + ave);

		} catch (GradeAverageFailsException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

	}

	public static double calcAverage(double[] grade) throws GradeAverageFailsException {
		double sum = 0;
		for (int i = 0; i < grade.length; i++) {
			sum += grade[i];
		}

		double ave = sum / grade.length;
		if (ave < 60)
			throw new GradeAverageFailsException(ave);
		return ave;
	}

	// output
//	please input the total number 
//	5
//	Please enter 5 numbers one by one
//	45
//	60
//	75
//	80
//	100
//	Average Grade :72.0

//	please input the total number 
//	5
//	Please enter 5 numbers one by one
//	45
//	56
//	67
//	65
//	36
//	Grade Average Fails Exception. Average Grade :53.80
}
