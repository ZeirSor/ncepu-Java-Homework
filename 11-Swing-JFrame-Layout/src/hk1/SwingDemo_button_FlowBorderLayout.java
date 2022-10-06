package hk1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SwingDemo_button_FlowBorderLayout {

//	1、在JFrame中添加5个按钮，分别使用FlowLayout和BorderLayout布局管理器。

	private JFrame frame;
	private JButton[] btn = { new JButton("Button 1"), new JButton("Button 2"), new JButton("Button 3"),
			new JButton("Button 4"), new JButton("Button 5"), };

	private JPanel[] panel = { new JPanel(), new JPanel() };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SwingDemo_button_FlowBorderLayout("Button Test");
	}

	public SwingDemo_button_FlowBorderLayout(String title) {
		frame = new JFrame(title);
		frame.setSize(400, 150);

		frame.setLayout(new FlowLayout());

		panel[0].setBackground(Color.RED);
		panel[0].setLayout(new FlowLayout());
		panel[0].add(btn[0]);
		panel[0].add(btn[1]);
		frame.add(panel[0]);

		panel[1].setBackground(Color.GREEN);
		panel[1].setLayout(new BorderLayout(70, 20));
		panel[1].add(btn[2], BorderLayout.EAST);
		panel[1].add(btn[3], BorderLayout.CENTER);
		panel[1].add(btn[4], BorderLayout.WEST);
		frame.add(panel[1]);

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
