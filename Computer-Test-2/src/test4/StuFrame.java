package test4;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class StuFrame implements ActionListener {

	JFrame frame = null;

	JTable table = null;

	DefaultTableModel dtm = null;

	JButton button = null;

	public StuFrame() {
		frame = new JFrame("student info");
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);

//		String[] colName = { "id", "name", "age" };

		Vector vectorCol = new Vector();
		vectorCol.add("id");
		vectorCol.add("name");
		vectorCol.add("age");

//		Vector data = new Vector();
		Vector stu1 = new Vector();
		stu1.add("001");
		stu1.add("zhangsan");
		stu1.add(18);
//		data.add(stu1);

		dtm = new DefaultTableModel(null, vectorCol);

		table = new JTable(dtm);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JScrollPane sp = new JScrollPane(table);
//		frame.add(table);

		button = new JButton("OK");
		button.addActionListener(this);
		frame.add(BorderLayout.SOUTH, button);
		frame.add(sp);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new StuFrame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Vector data = new Vector();
		Vector stu1 = new Vector();
		stu1.add("001");
		stu1.add("zhangsan");
		stu1.add(18);
//		data.add(stu1);
		dtm.addRow(stu1);
	}
}
