package hk1;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//		1、在窗口中添加两个按钮，分别为“确定”和“取消”。
//		单击“确定”按钮，窗口标题栏显示“你单击了确定按钮”。
//		单击“取消”按钮，窗口标题栏显示“你单击了取消按钮”。
//		要求采用五种方式实现事件监听器：本类、外部类、内部类、匿名类、lambda表达式。

class EventListener implements ActionListener {
	MyFrame frame;

	public EventListener(MyFrame frame) {
		super();
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == frame.getButtonOK2())
			frame.getFrame().setTitle("你单击了确定按钮");
		else if (e.getSource() == frame.getButtonCancel2())
			frame.getFrame().setTitle("你单击了取消按钮");
	}

}

public class MyFrame implements ActionListener {

	private JFrame frame;
	private JButton buttonOK1;
	private JButton buttonOK2;
	private JButton buttonOK3;
	private JButton buttonOK4;
	private JButton buttonOK5;
	private JButton buttonCancel1;
	private JButton buttonCancel2;
	private JButton buttonCancel3;
	private JButton buttonCancel4;
	private JButton buttonCancel5;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel panel4;
	private JPanel panel5;

	public static void main(String[] args) {
		new MyFrame("Java-homework-12-1");
	}

	class InnerEventListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == getButtonOK3())
				getFrame().setTitle("你单击了确定按钮");
			else if (e.getSource() == getButtonCancel3())
				getFrame().setTitle("你单击了取消按钮");
		}
	}

	public MyFrame(String title) {
		frame = new JFrame(title);
		frame.setSize(777, 555);
		frame.setLayout(new FlowLayout());

		// 本类实现事件监听器
		panel1 = new JPanel(new FlowLayout());
		panel1.setBackground(Color.RED);
		buttonOK1 = new JButton("确定");
		buttonOK1.addActionListener(this);
		buttonCancel1 = new JButton("取消");
		buttonCancel1.addActionListener(this);
		panel1.add(buttonOK1);
		panel1.add(buttonCancel1);
		frame.add(panel1);

		// 外部类实现事件监听器
		panel2 = new JPanel(new FlowLayout());
		panel2.setBackground(Color.GREEN);
		buttonOK2 = new JButton("确定");
		buttonOK2.addActionListener(new EventListener(this));
		buttonCancel2 = new JButton("取消");
		buttonCancel2.addActionListener(new EventListener(this));
		panel2.add(buttonOK2);
		panel2.add(buttonCancel2);
		frame.add(panel2);

		// 内部类实现事件监听器
		panel3 = new JPanel(new FlowLayout());
		panel3.setBackground(Color.BLUE);
		buttonOK3 = new JButton("确定");
		buttonOK3.addActionListener(new InnerEventListener());
		buttonCancel3 = new JButton("取消");
		buttonCancel3.addActionListener(new InnerEventListener());
		panel3.add(buttonOK3);
		panel3.add(buttonCancel3);
		frame.add(panel3);

		// 匿名类实现事件监听器
		panel4 = new JPanel(new FlowLayout());
		panel4.setBackground(Color.ORANGE);
		buttonOK4 = new JButton("确定");
		buttonOK4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource() == getButtonOK4())
					frame.setTitle("你单击了确定按钮");
				else if (e.getSource() == getButtonCancel4())
					frame.setTitle("你单击了取消按钮");
			}
		});
		buttonCancel4 = new JButton("取消");
		buttonCancel4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource() == getButtonOK4())
					frame.setTitle("你单击了确定按钮");
				else if (e.getSource() == getButtonCancel4())
					frame.setTitle("你单击了取消按钮");
			}
		});
		panel4.add(buttonOK4);
		panel4.add(buttonCancel4);
		frame.add(panel4);

		// lambda表达式实现事件监听器
		panel5 = new JPanel(new FlowLayout());
		panel5.setBackground(Color.PINK);
		buttonOK5 = new JButton("确定");
		buttonOK5.addActionListener(e -> {
			if (e.getSource() == getButtonOK5())
				frame.setTitle("你单击了确定按钮");
			else if (e.getSource() == getButtonCancel5())
				frame.setTitle("你单击了取消按钮");
		});
		buttonCancel5 = new JButton("取消");
		buttonCancel5.addActionListener(e -> {
			if (e.getSource() == getButtonOK5())
				frame.setTitle("你单击了确定按钮");
			else if (e.getSource() == getButtonCancel5())
				frame.setTitle("你单击了取消按钮");
		});
		panel5.add(buttonOK5);
		panel5.add(buttonCancel5);
		frame.add(panel5);

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void addPanel(JPanel panel, JButton buttonOK, JButton buttonCancel) {
		panel = new JPanel(new FlowLayout());
		buttonOK = new JButton("确定");
		buttonCancel = new JButton("取消");
//		frame.add(panel);
	}

	// 本类实现事件监听器
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == buttonOK1)
			frame.setTitle("你单击了确定按钮");
		else if (e.getSource() == buttonCancel1)
			frame.setTitle("你单击了取消按钮");
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JButton getButtonOK1() {
		return buttonOK1;
	}

	public void setButtonOK1(JButton buttonOK1) {
		this.buttonOK1 = buttonOK1;
	}

	public JButton getButtonCancel1() {
		return buttonCancel1;
	}

	public void setButtonCancel1(JButton buttonCancel1) {
		this.buttonCancel1 = buttonCancel1;
	}

	public JButton getButtonOK2() {
		return buttonOK2;
	}

	public void setButtonOK2(JButton buttonOK2) {
		this.buttonOK2 = buttonOK2;
	}

	public JButton getButtonCancel2() {
		return buttonCancel2;
	}

	public void setButtonCancel2(JButton buttonCancel2) {
		this.buttonCancel2 = buttonCancel2;
	}

	public JPanel getPanel1() {
		return panel1;
	}

	public void setPanel1(JPanel panel1) {
		this.panel1 = panel1;
	}

	public JPanel getPanel2() {
		return panel2;
	}

	public void setPanel2(JPanel panel2) {
		this.panel2 = panel2;
	}

	public JButton getButtonOK3() {
		return buttonOK3;
	}

	public void setButtonOK3(JButton buttonOK3) {
		this.buttonOK3 = buttonOK3;
	}

	public JButton getButtonOK4() {
		return buttonOK4;
	}

	public void setButtonOK4(JButton buttonOK4) {
		this.buttonOK4 = buttonOK4;
	}

	public JButton getButtonOK5() {
		return buttonOK5;
	}

	public void setButtonOK5(JButton buttonOK5) {
		this.buttonOK5 = buttonOK5;
	}

	public JButton getButtonCancel3() {
		return buttonCancel3;
	}

	public void setButtonCancel3(JButton buttonCancel3) {
		this.buttonCancel3 = buttonCancel3;
	}

	public JButton getButtonCancel4() {
		return buttonCancel4;
	}

	public void setButtonCancel4(JButton buttonCancel4) {
		this.buttonCancel4 = buttonCancel4;
	}

	public JButton getButtonCancel5() {
		return buttonCancel5;
	}

	public void setButtonCancel5(JButton buttonCancel5) {
		this.buttonCancel5 = buttonCancel5;
	}

	public JPanel getPanel3() {
		return panel3;
	}

	public void setPanel3(JPanel panel3) {
		this.panel3 = panel3;
	}

	public JPanel getPanel4() {
		return panel4;
	}

	public void setPanel4(JPanel panel4) {
		this.panel4 = panel4;
	}

	public JPanel getPanel5() {
		return panel5;
	}

	public void setPanel5(JPanel panel5) {
		this.panel5 = panel5;
	}

}
