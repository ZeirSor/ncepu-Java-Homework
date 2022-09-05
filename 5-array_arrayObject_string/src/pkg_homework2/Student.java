package pkg_homework2;

public class Student implements Cloneable {

//	定义一个Student类

	private String name;
	private String id;
	private int age;

	// 编写代码实现数组的克隆
	// 重写Object中的clone方法
	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		Student newStu = (Student) super.clone();
		newStu.name = this.name;
		newStu.id = this.id;
		newStu.age = this.age;

		return newStu;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String name, String id, int age) {
		super();
		this.name = name;
		this.id = id;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [name = " + name + ", id = " + id + ", age = " + age + "]";
	}

	public void showInfo() {
		System.out.println(this.toString());
	}

}