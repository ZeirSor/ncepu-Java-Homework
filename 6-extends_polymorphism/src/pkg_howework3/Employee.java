package pkg_howework3;

public class Employee {
	private String name;
	private String id;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Employee(String name, String id) {
		super();
		this.name = name;
		this.id = id;
	}

	@Override
	public String toString() {
		return "Emploee [name = " + name + ", id = " + id + "]";
	}
	
	public void showInfo() {
		System.out.println(this.toString());
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
	
}

class Manager extends Employee{
	private String department;

	@Override
	public String toString() {
		return "Manager [name = " + super.getName() + ", id = " + super.getId() + ", department = " + department + "]";
	}

	@Override
	public void showInfo() {
		// TODO Auto-generated method stub
		System.out.println(this.toString());
	}

	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Manager(String name, String id, String department) {
		super(name, id);
		// TODO Auto-generated constructor stub
		this.department = department;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
}
