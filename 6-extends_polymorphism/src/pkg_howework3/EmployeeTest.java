package pkg_howework3;

public class EmployeeTest {
	public static void main(String[] args) {
		Employee e = new Employee("zhangsan", "007");
		e.showInfo();

		Manager m = new Manager("lisi", "008", "Human Resources Department");
		m.showInfo();

		// output
//		Emploee [name = zhangsan, id = 007]
//		Manager [name = lisi, id = 008, department = Human Resources Department]
	}
}
