package hk2;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Frame_SwapButton implements ActionListener {

	private JFrame frame;

	private JButton buttonOK;

	private JButton buttonCancel;

//	2、在窗口中添加两个按钮，分别为“确定”和“取消”。
//	单击任何一个按钮时，两个按钮上的文字互换。

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String temp = buttonOK.getText();
		buttonOK.setText(buttonCancel.getText());
		buttonCancel.setText(temp);
		System.out.println("click!");
	}

	public Frame_SwapButton(String title) {
		frame = new JFrame(title);
		frame.setSize(777, 555);
		frame.setLayout(new FlowLayout());

		buttonOK = new JButton("确定");
		buttonOK.addActionListener(this);
		buttonCancel = new JButton("取消");
		buttonCancel.addActionListener(this);
		frame.add(buttonOK);
		frame.add(buttonCancel);

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Frame_SwapButton("java-homeword-12-2");
	}

}
