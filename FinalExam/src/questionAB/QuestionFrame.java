package questionAB;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class QuestionFrame implements ActionListener {
	Question[] selectQuestions = { new Question("1．Java语言的特点是( )。"), new Question("2．Java的自动垃圾回收机制是(  )。"),
			new Question("3．关于抽象类，下面说法正确的是(  )。"), new Question("4．用于定义接口的关键字是(  )。"),
			new Question("5．异常分为检查型异常和(  )两种。"), new Question("6．异常处理过程包括异常的抛出和异常的(  )。"),
			new Question("7．人为抛出异常对象e的语句为(  )。"), new Question("8．创建图形用户界面的一般步骤为创建容器和组件、设置容器的布局管理器、添加组件、(  )。"),
			new Question("9．(  )是表中的一个字段，用于唯一地标识一条记录。"), new Question("10．SQL语句也称为(  )，是关系数据库的标准查询语言。"), };
	Question[] blankQuestions = { new Question("11．Java事件处理三要素包括事件、(  )、(  )。"), new Question("12．监听器类需要实现事件对应的(  )。"),
			new Question("13．Java语言中基于流的I/O类在(  )包中。"), new Question("14．所有字节流的类都是(  )类和OutputStream类的子类。"),
			new Question("15．所有字符流的类都是(  )类和Writer类的子类。"), new Question("16．关系数据库中的数据逻辑结构是(  )包中。"),
			new Question("17．面向对象的三大特性是(  )。"), new Question("18．类的( )变量是属于类的，是在所有对象间共享的。"),
			new Question("19．Statement对象的作用是(  )。"),
			new Question("20．实现Runnable接口和继承Thread类并覆盖其中的(  )方法可以用来创建一个新线程。"), };
	private JFrame frame;
	private JPanel panel;

	private JPanel panelLeft = new JPanel(new BorderLayout());
	private JLabel labelAllQuestions = new JLabel("试题");
	private JTextArea textAreaAllQuestions = new JTextArea(10, 10);
	private JButton buttonAllQuestions = new JButton("显示试题");

	private JPanel panelCenter = new JPanel(new BorderLayout());
	private JLabel labelA = new JLabel("A卷");
	private JTextArea textAreaA = new JTextArea(10, 10);
	private JButton buttonGenerate = new JButton("生成试卷");

	private JPanel panelRight = new JPanel(new BorderLayout());
	private JLabel labelB = new JLabel("B卷");
	private JTextArea textAreaB = new JTextArea(10, 10);
	private JButton buttonSave = new JButton("保存试卷");

	public QuestionFrame() {
		frame = new JFrame("组卷");
		frame.setSize(1200, 500);

//        用1 * 3的网格布局
		panel = new JPanel(new GridLayout(1, 3, 10, 10));

//        设置换行
		textAreaAllQuestions.setLineWrap(true);
		textAreaA.setLineWrap(true);
		textAreaB.setLineWrap(true);

//        添加事件监听
		buttonAllQuestions.addActionListener(this);
		buttonGenerate.addActionListener(this);
//        使用lambda表达式
		buttonSave.addActionListener(e -> {
			String textA = textAreaA.getText();
			String textB = textAreaB.getText();
			System.out.println("A卷:\n" + textA);
			System.out.println("B卷:\n" + textB);

			File fileA = new File("src\\A.txt");
			File fileB = new File("src\\B.txt");

			saveFile(fileA, textA);
			saveFile(fileB, textB);
		});

		panelLeft.add(labelAllQuestions, BorderLayout.NORTH);
		panelLeft.add(textAreaAllQuestions, BorderLayout.CENTER);
		panelLeft.add(buttonAllQuestions, BorderLayout.SOUTH);
		panel.add(panelLeft);

		panelCenter.add(labelA, BorderLayout.NORTH);
		panelCenter.add(textAreaA, BorderLayout.CENTER);
		panelCenter.add(buttonGenerate, BorderLayout.SOUTH);
		panel.add(panelCenter);

		panelRight.add(labelB, BorderLayout.NORTH);
		panelRight.add(textAreaB, BorderLayout.CENTER);
		panelRight.add(buttonSave, BorderLayout.SOUTH);
		panel.add(panelRight);

		frame.add(panel);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//        显示试题
		if (e.getSource() == buttonAllQuestions) {
			textAreaAllQuestions.setText("");
			for (Question selectQuestion : selectQuestions) {
				textAreaAllQuestions.setText(textAreaAllQuestions.getText() + selectQuestion.getDescription() + '\n');
			}
			for (Question blankQuestion : blankQuestions) {
				textAreaAllQuestions.setText(textAreaAllQuestions.getText() + blankQuestion.getDescription() + '\n');
			}
		}
//        生成A、B卷
		if (e.getSource() == buttonGenerate) {
//            初始化试题选择状态
			Question.initSelected(selectQuestions);
			Question.initSelected(blankQuestions);
//            初始化文本框内容
			textAreaA.setText("");
			textAreaB.setText("");

//            启动两个线程组卷
			ExtractThread eta = new ExtractThread(selectQuestions, blankQuestions, textAreaA);
			ExtractThread etb = new ExtractThread(selectQuestions, blankQuestions, textAreaB);
			Thread t1 = new Thread(eta, "A卷线程");
			Thread t2 = new Thread(etb, "B卷线程");
			t1.start();
			t2.start();
		}
	}

//    保存文件方法
	public void saveFile(File file, String str) {
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(file));
			bw.write(str);
			System.out.println("文件保存至:" + file.getAbsolutePath());
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if (bw != null)
					bw.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

	}

	public static void main(String[] args) {
		new QuestionFrame();
	}
}
