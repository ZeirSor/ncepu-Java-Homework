package FileCopyTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Test2 {
	public static void main(String[] args) throws IOException {
		File diskPath = new File("/");
		System.out.println(diskPath.getAbsolutePath());

		File rootAbsPath = new File(".");
		System.out.println(rootAbsPath.getAbsolutePath());

		String srcPath = rootAbsPath.getAbsolutePath().replace(".", "") + "src.txt";

		System.out.println(srcPath);
		String destPath = rootAbsPath.getAbsolutePath().replace(".", "") + "destFile.txt";
		System.out.println(destPath);

		String srcInit = "src file init string";
		BufferedWriter bw2 = new BufferedWriter(new FileWriter(srcPath));
		bw2.write(srcInit);
		bw2.close();

		BufferedReader br = new BufferedReader(new FileReader(srcPath));

		BufferedWriter bw = new BufferedWriter(new FileWriter(destPath));

		String line = null;
		while ((line = br.readLine()) != null) {
			bw.write(line);
			bw.newLine();
		}

		br.close();
		bw.close();
	}
}
