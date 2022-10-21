package hk3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

import hk2.Student;

public class ObjectArrayStream_ {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		Student[] students = { new Student("zhangsan", 18), new Student("lisi", 19), new Student("wanwu", 17),
				new Student("zhaoliu", 22), new Student() };
		String filePath = "E:\\ncepu\\ncepu-Java-Homework\\15-decorateStream_fileDialog\\src\\hk3\\objectArrayStreamTest.zs";
		new ObjectArrayStream_(filePath, students);
	}

	public ObjectArrayStream_(String filePath, Student[] students)
			throws FileNotFoundException, IOException, ClassNotFoundException {
		writeObjectArray(filePath, students);
		readObjectArray(filePath, students);
	}

	private void writeObjectArray(String filePath, Student[] students) throws FileNotFoundException, IOException {
		ObjectOutput oos = new ObjectOutputStream(new FileOutputStream(filePath));

		for (Student student : students) {
			oos.writeObject(student);
		}

		oos.close();
	}

	private void readObjectArray(String filePath, Student[] students)
			throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath));

		for (int i = 0; i < students.length; i++) {
			Object obj = ois.readObject();
			System.out.println(((Student) obj).toString());
		}

		ois.close();
	}

}
