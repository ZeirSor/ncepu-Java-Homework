package hm2;

//2．自定义一个异常类，用来表示成绩的平均值低于60分，

//要求具有一个无参和一个带有参数的构造方法，并覆盖getMessage方法。

public class GradeAverageFailsException extends Exception {

	@SuppressWarnings("unused")
	private double grade;

	public GradeAverageFailsException() {
	}

	public GradeAverageFailsException(double grade) {
		super();
		this.grade = grade;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Grade Average Fails Exception. Average Grade :" + String.format("%.2f", grade);
	}

}
