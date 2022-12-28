package NamingSys;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

//1. 读取文件name_assets.txt录入学生姓名
//2. 点名程序，要求用可以通过点名按钮实现随机点名，并且点名出来的同学显示在界面中，点过的同学再没有清空界面之前要求不能第二次被点到（要求使用随机数来实现)
//3. 同时点名过程中要求实现在界面上显示抽签过程（名字动态变换），再次点击点名按钮后停止切换，将点名结果显示在界面上。
//4. 要求回答完毕问题后教师可以根据回答情况进行加分1-10分，最后可以显示答题情况总分排行榜
//5. 使用多线程进行自动注册报名，要求通过name_assets.txt中的内容，使用多线程完成同学的自动注册

public class NamingFrame implements ActionListener {

	public static void main(String[] args) {
		new NamingFrame();
	}

	private Student[] students;
	private Student temp;
	private int randomNum = 0;
	ArrayList<String> names = new ArrayList<>();
	private JFrame frame = new JFrame("random naming");
	private JPanel panel = new JPanel();
	private JButton buttonInit = new JButton("导入学生数据");
	private JTextArea textAreaInfo = new JTextArea(20, 20);
	private JScrollPane scrollPaneInfo = new JScrollPane(textAreaInfo);

	private JButton buttonNaming = new JButton("点名");
	private JLabel NameLabel = new JLabel("  -----  ");
	private boolean flag = false;

	private JButton buttonGiveScore = new JButton("回答打分");
	private JTextArea textAreaScore = new JTextArea(1, 5);

	private JButton buttonSort = new JButton("学生分数排序");
	private JTextArea textAreaSort = new JTextArea(20, 20);
	private JScrollPane scrollPaneSort = new JScrollPane(textAreaSort);

	private JButton buttonLog = new JButton("多线程实现学生信息注册");
	private JTextArea textAreaLog = new JTextArea(20, 20);
	private JScrollPane scrollPaneLog = new JScrollPane(textAreaLog);

	public NamingFrame() {
		frame.setSize(1500, 380);
		frame.setLocationRelativeTo(null);

		panel.add(buttonInit);
		textAreaInfo.setLineWrap(true);
		panel.add(scrollPaneInfo);
		buttonInit.addActionListener(e -> {
			try {
				readFileData();
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
			setTextAreaInfo();
		});

		panel.add(buttonNaming);
		panel.add(NameLabel);
//        动态点名，把刷新放在线程里执行，我也不知道为什么。
//        https://bbs.csdn.net/topics/290030577
		buttonNaming.addActionListener(e -> {
			flag = !flag;
			if (flag == true) {
				buttonNaming.setText("停止");
				new Thread() {
					@Override
					public void run() {
						randomNaming();
					}
				}.start();
			} else {
				buttonNaming.setText("开始");
			}
		});

		panel.add(buttonGiveScore);
		panel.add(textAreaScore);
		buttonGiveScore.addActionListener(this);

		panel.add(buttonSort);
		panel.add(scrollPaneSort);
		buttonSort.addActionListener(this);

		panel.add(buttonLog);
		textAreaLog.setLineWrap(true);
//        panel.add(textAreaLog);
		panel.add(scrollPaneLog);
		buttonLog.addActionListener(e -> threadLog());

		frame.add(panel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void threadLog() {
		LogThread lt = new LogThread(students, textAreaLog);
		Thread thread1 = new Thread(lt);
		Thread thread2 = new Thread(lt);
		Thread thread3 = new Thread(lt);

		thread1.start();
		thread2.start();
		thread3.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buttonGiveScore) {
			System.out.println("buttonGiveScore clicked!");
			giveScore();
		}
		if (e.getSource() == buttonSort) {
			System.out.println("buttonSort clicked!");
			sortScore();
		}
	}

	public void readFileData() throws IOException {
		File fileNameAssets = new File("src\\name_assets.txt");
		System.out.println(fileNameAssets.getAbsolutePath());
		BufferedReader br = new BufferedReader(new FileReader(fileNameAssets));
		String line = null;
		while ((line = br.readLine()) != null) {
			System.out.println(line);
			names.add(line);
		}
		System.out.println(fileNameAssets.getAbsolutePath());
		br.close();

		int num = names.size();
		this.students = new Student[num];
		for (int i = 0; i < num; i++) {
			students[i] = new Student(names.get(i));
		}
	}

	public void setTextAreaInfo() {
		for (Student student : students) {
			textAreaInfo.setText(textAreaInfo.getText() + student.toString() + '\n');
		}
	}

	public void randomNaming() {
		while (flag == true) {
			int r = (int) (Math.random() * students.length);
			this.randomNum = r;
			temp = students[randomNum];
			System.out.println(temp.getName() + "  " + r);
			NameLabel.setText("  " + temp.getName() + "  ");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			frame.setVisible(true);
		}
//        int r = (int) (Math.random() * students.length);
//        System.out.println(r);
//        if (r == this.randomNum) randomNaming();
//        else {
//            this.randomNum = r;
//            temp = students[randomNum];
//            System.out.println(temp.getName());
//            NameLabel.setText("  " + temp.getName() + "  ");
//        }
	}

	public void giveScore() {
		if (flag == true) {
			JOptionPane.showMessageDialog(frame, "请停止点名！！！", "打分错误", JOptionPane.WARNING_MESSAGE);
		} else if (textAreaScore.getText().equals("")) {
			JOptionPane.showMessageDialog(frame, "请打分！！！", "打分错误", JOptionPane.WARNING_MESSAGE);
		} else {
			int score = Integer.parseInt(textAreaScore.getText());
//        int score = (int) (Math.random() * 11);
			System.out.println("score:" + score);
			if (score >= 10 || score < 0) {
				JOptionPane.showMessageDialog(frame, "打分范围应该在0-10", "打分错误", JOptionPane.WARNING_MESSAGE);
			} else {
				temp.setScore(temp.getScore() + score);
				System.out.println(temp.toString());
				textAreaInfo.setText("");
				setTextAreaInfo();
			}
		}
	}

	private void sortScore() {
		Arrays.sort(students);
		for (int i = 0; i < students.length; i++) {
			String info = "" + (i + 1) + '\t' + students[i].getName() + '\t' + students[i].getScore();
			System.out.println(info);
			textAreaSort.setText(textAreaSort.getText() + '\n' + info);
		}
	}
}