package hk2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class ObjectStream_ {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		new ObjectStream_(
				"E:\\ncepu\\ncepu-Java-Homework\\15-decorateStream_fileDialog\\src\\hk2\\objectStreamTest.zs");
	}

	public ObjectStream_(String filePath) throws FileNotFoundException, IOException, ClassNotFoundException {
		writeObject(filePath);
		readObject(filePath);
	}

	private void writeObject(String filePath) throws FileNotFoundException, IOException {
		ObjectOutput oos = new ObjectOutputStream(new FileOutputStream(filePath));
		oos.writeObject(new Student("zhangsan", 18));
		oos.close();
	}

	private void readObject(String filePath) throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath));
		Object obj = ois.readObject();
		System.out.println(((Student) obj).toString());
		ois.close();
	}

}
