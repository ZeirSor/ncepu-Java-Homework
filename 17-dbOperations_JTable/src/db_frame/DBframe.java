package db_frame;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

//1、将数据库中任意一张表中的内容在JTable中显示。
//2、自行设计表的增、删、改操作方式，并完成相应的功能。

public class DBframe implements ActionListener {

	private JFrame frame = null;
	private JPanel panel = null;
	private JTable table = null;

	private JPanel panel_text = null;
	private JTextField text_id = null;
	private JTextField text_name = null;
	private JTextField text_age = null;

	private JPanel panel_button = null;
	private JButton button_add = null;
	private JButton button_del = null;
	private JButton button_mod = null;
	private JButton button_showAll = null;

	private DefaultTableModel dtm = null;
	private JScrollPane sp = null;

	private Connection coon = DBOperations.connectDatabase();

	private Vector data = null;

	public DBframe() {
		frame = new JFrame("Frame-database operations");
		frame.setLocationRelativeTo(null);
		frame.setSize(500, 500);

		Vector<String> tableHead = new Vector<>();
		tableHead.add("id");
		tableHead.add("name");
		tableHead.add("age");

		dtm = new DefaultTableModel(null, tableHead);
		table = new JTable(dtm);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		sp = new JScrollPane(table);

		panel = new JPanel(new GridLayout(2, 1));

		panel_text = new JPanel();
		text_id = new JTextField(10);
		text_name = new JTextField(10);
		text_age = new JTextField(10);
		panel_text.add(text_id);
		panel_text.add(text_name);
		panel_text.add(text_age);
		panel.add(panel_text);

		panel_button = new JPanel();
		button_add = new JButton("add");
		button_add.addActionListener(this);
		button_del = new JButton("delete");
		button_del.addActionListener(this);
		button_mod = new JButton("modify");
		button_mod.addActionListener(this);
		button_showAll = new JButton("show all");
		button_showAll.addActionListener(this);
		panel_button.add(button_add);
		panel_button.add(button_del);
		panel_button.add(button_mod);
		panel_button.add(button_showAll);
		panel.add(panel_button);

		frame.add(panel, BorderLayout.SOUTH);
		frame.add(sp);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new DBframe();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == button_add) {
			System.out.println("button add is clicked");
			String id = text_id.getText();
			String name = text_name.getText();
			if (id.equals("") && name.equals("") && text_age.getText().equals(""))
				JOptionPane.showMessageDialog(frame,
						"The added information is incomplete, please return and complete it.", "Incomplete information",
						JOptionPane.INFORMATION_MESSAGE);
			else {
				int age = Integer.parseInt(text_age.getText());
				try {
					DBOperations.add(coon, id, name, age);
					data = new Vector<>();
					data.add(id);
					data.add(name);
					data.add(age);
					dtm.addRow(data);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} finally {
					text_id.setText("");
					text_name.setText("");
					text_age.setText("");
				}
			}

		}

		if (e.getSource() == button_del) {
			System.out.println("button del is clicked");
			int index;
			if ((index = table.getSelectedRow()) != -1) {

				String id = (String) dtm.getValueAt(index, 0);
				try {
					DBOperations.del(coon, id);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				dtm.removeRow(index);
			} else
				JOptionPane.showMessageDialog(frame, "Please select a row to delete.", "",
						JOptionPane.INFORMATION_MESSAGE);
		}

		if (e.getSource() == button_mod) {
			System.out.println("button mod is clicked");
			int index;
			if ((index = table.getSelectedRow()) != -1) {

				String oldId = (String) dtm.getValueAt(index, 0);
				try {
					DBOperations.mod(coon, oldId, text_id.getText(), text_name.getText(),
							Integer.parseInt(text_age.getText()));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else
				JOptionPane.showMessageDialog(frame, "Please select a row to modify.", "",
						JOptionPane.INFORMATION_MESSAGE);
		}

		if (e.getSource() == button_showAll) {
			System.out.println("button showAll is clicked");

			// clear the all table
			int count = dtm.getRowCount();
			for (int i = 0; i < count; i++)
				dtm.removeRow(0);

			try {
				ResultSet rs = DBOperations.showAll(coon);
				while (rs.next()) {
					String id = rs.getString("id");
					String name = rs.getString("name");
					int age = rs.getInt("age");
					System.out.println("age = " + age);
					data = new Vector<>();
					data.add(id);
					data.add(name);
					data.add(age);
					dtm.addRow(data);
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

}
