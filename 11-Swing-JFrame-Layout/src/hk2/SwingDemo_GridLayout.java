package hk2;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SwingDemo_GridLayout {

//	2、在JFrame中使用GridLayout添加4个面板，每个面板的背景设置为不同的颜色。

	private JFrame frame;

	private JPanel[] panel = { new JPanel(), new JPanel(), new JPanel(), new JPanel() };

	public SwingDemo_GridLayout(String string) {
		frame = new JFrame(string);
		frame.setSize(400, 100);

		frame.setLayout(new GridLayout(2, 2));

		panel[0].setBackground(Color.RED);
		frame.add(panel[0]);

		panel[1].setBackground(Color.GREEN);
		frame.add(panel[1]);

		panel[2].setBackground(Color.BLUE);
		frame.add(panel[2]);

		panel[3].setBackground(Color.ORANGE);
		frame.add(panel[3]);

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SwingDemo_GridLayout("GridLayout Test");
	}

}
