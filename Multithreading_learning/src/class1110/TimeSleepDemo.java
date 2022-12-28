package class1110;

import java.awt.Font;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class TimeSleepDemo {
	private JFrame frame = null;
	private JLabel label = null;

	public TimeSleepDemo() {
		frame = new JFrame();
		frame.setLocationRelativeTo(null);
		label = new JLabel("", JLabel.CENTER);

		Font oldFont = label.getFont();
		Font newFont = new Font(oldFont.getName(), oldFont.getStyle(), 30);
		label.setFont(newFont);

		frame.add(label);
		frame.setSize(200, 100);

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		while (true) {
			Calendar calendar = Calendar.getInstance();
			int hour = calendar.get(calendar.HOUR);
			int minute = calendar.get(calendar.MINUTE);
			int second = calendar.get(calendar.SECOND);
			int millSecond = calendar.get(calendar.MILLISECOND);

			label.setText(hour + ":" + minute + ":" + second + ":" + millSecond);

			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new TimeSleepDemo();
	}
}
