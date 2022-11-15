package hk2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

//	2、使用定时器编写程序，每隔10秒钟读取文件data.txt，如果文件不为空就输出显示。

public class TimerReadFileDemo {

	public static void main(String[] args) {
		String filePath = "src\\data.txt";

		new Timer().schedule(new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				readFile(filePath);
			}

		}, 0, 10000);
	}

	public static void readFile(String filePath) {
		File file = new File(filePath);
		System.out.println(file.getAbsolutePath());

		String line = null;
		BufferedReader br = null;

		System.out.println(">>> read file: " + file.getName() + "    " + new Date().toString());

		try {
			br = new BufferedReader(new FileReader(file));

			while ((line = br.readLine()) != null) {
				System.out.println(line);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			System.out.println(">>> read file: " + file.getName() + " end!");
		}
	}
}
