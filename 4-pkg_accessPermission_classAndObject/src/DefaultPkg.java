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

		// output
//		Student [name=zhangshuo, id=120211080526, age=19]
//		Student [name=shuozhang, id=625080112021, age=20]
	}

}
