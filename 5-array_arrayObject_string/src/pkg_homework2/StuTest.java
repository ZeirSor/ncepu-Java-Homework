package pkg_homework2;

public class StuTest {

	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub

//		2.定义一个类，然后定义一个对象数组，并进行初始化（长度为3-5之间），
//		编写代码实现数组的克隆，
//		克隆后的数组具有自己的内存空间。

//		定义一个对象数组，并进行初始化（长度为3-5之间），
		Student[] stu = new Student[3];
		stu[0] = new Student("Zhangsan", "007", 18);
		stu[1] = new Student("Lisi", "008", 20);
		stu[2] = new Student("Wangwu", "009", 19);

		for (Student student : stu) {
			student.showInfo();
		}
		System.out.println();

//		编写代码实现数组的克隆
//		克隆后的数组具有自己的内存空间。		
		Student[] cpyStu = cloneStu(stu);
		
		//验证克隆后的数组具有自己的内存空间
		System.out.println("stu == cpyStu ? : " + (stu == cpyStu));
		for (int i = 0; i < cpyStu.length; i ++) {
			System.out.println("stu[" + i + "] == cpyStu[" + i + "]  ? : " + (stu[i] == cpyStu[i]));
		}
		System.out.println();
		
		// 修改cpyStu数组中的值，看看stu数组中的值会不会改变
		cpyStu[0].setAge(999);
		cpyStu[0].showInfo();
		stu[0].showInfo();

		System.out.println();
		cpyStu[1].setName("ZeirSor");
		cpyStu[1].showInfo();
		stu[1].showInfo();

		// output
//		Student [name = Zhangsan, id = 007, age = 18]
//		Student [name = Lisi, id = 008, age = 20]
//		Student [name = Wangwu, id = 009, age = 19]
//
//		stu == cpyStu ? : false
//		stu[0] == cpyStu[0]  ? : false
//		stu[1] == cpyStu[1]  ? : false
//		stu[2] == cpyStu[2]  ? : false
//
//		Student [name = Zhangsan, id = 007, age = 999]
//		Student [name = Zhangsan, id = 007, age = 18]
//
//		Student [name = ZeirSor, id = 008, age = 20]
//		Student [name = Lisi, id = 008, age = 20]
	}

//	编写代码实现数组的克隆
//	克隆后的数组具有自己的内存空间。
	public static Student[] cloneStu(Student[] origin) throws CloneNotSupportedException {
		Student[] newStu = new Student[origin.length];
		for (int i = 0; i < newStu.length; i++) {
			newStu[i] = (Student) origin[i].clone();
		}
		return newStu;
	}

}
