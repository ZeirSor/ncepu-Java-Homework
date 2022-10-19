package hk2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//2、用户从键盘输入若干字符串，将其中的数字删除后写入文件中。

public class EnterString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileWriter fileWriter = null;
		String filePath = "E:\\ncepu\\ncepu-Java-Homework\\14-fileStream\\src\\hk2\\EnterString.txt";

		String userInput = null;
		Scanner sc = new Scanner(System.in);

//		String test = "dneafv4g3qwt4567hb567ubh5bnj56nm9i5h5g24fiq34jrn234qr8934h";
//		test = test.replaceAll("\\d", "");
//		System.out.println(test);
		try {
			System.out.println("Please enter multiple sets of strings, enter a single \"#\" to stop inputting.");
			fileWriter = new FileWriter(filePath);
			while (!(userInput = sc.nextLine()).equals("#")) {
				fileWriter.write(userInput.replaceAll("\\d", "") + '\n');
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				fileWriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
