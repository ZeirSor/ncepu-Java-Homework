import se.chapter2.Student;

public class DefaultPkg {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Student s = new Student("zhangshuo", "120211080526", 19);
		s.showInfo();

		s.setName("shuozhang");
		s.setId("625080112021");
		s.setAge(20);
		s.showInfo();
	}

}
