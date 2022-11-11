package Example_Teacher;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

class MySQLDBOperation { /* ���ݿ������ */
	public static Connection conn = null;
	public static Statement stmt = null;
	public static ResultSet rs = null;

	// �������ݿ�
	public static Connection connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/smis";
			Connection conn = DriverManager.getConnection(url, "root", "123456");
			return conn;
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return null;
	}

	// �������ݿ�
	public static void update(String sql) {
		try {
			conn = connect();
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	// ��ѯ���ݿ�
	public static ResultSet query(String sql) {

		try {
			conn = connect();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}
		return rs;
	}

	// �ر����ݿ�
	public static void close() {
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}
	}

}

class StuManageGUI { /* ������ */
	public JFrame frame = null;
	public JPanel jP1 = null;
	public JPanel jP2 = null;
	public JPanel jP3 = null;
	public JPanel jP4 = null;
	public JPanel jP5 = null;
	public JTable jTable = null; // ������
	public DefaultTableModel dtm = null; // ���ģ��
	public JScrollPane jScrollPane = null; // �������
	public JButton jButtonInsert = null; // ���Ӱ�ť
	public JButton jButtonUpdate = null; // �޸İ�ť
	public JButton jButtonDelete = null; // ɾ����ť
	public JButton jButtonSearch = null; // ��ѯ��ť
	public JButton jButtonDisplay = null; // ��ʾȫ����ť
	public JTextField jTextFieldId = null; // ѧ���ı���
	public JTextField jTextFieldName = null; // �����ı���
	public JTextField jTextFieldBir = null; // ���������ı���
	public ButtonGroup bg = null;
	public JRadioButton jRadioButtonMale = null; // �Ա�ѡ��
	public JRadioButton jRadioButtonFemale = null; // �Ա�ѡ��
	public JLabel jLabelId = null;
	public JLabel jLabelName = null;
	public JLabel jLabelBir = null;

	public StuManageGUI() {
		super();
		// �������
		frame = new JFrame("ѧ����Ϣ����");
		jP1 = new JPanel();
		jP2 = new JPanel();
		jP3 = new JPanel();
		jP4 = new JPanel();
		jP5 = new JPanel();
		dtm = new DefaultTableModel();
		jTable = new JTable(dtm);
		jScrollPane = new JScrollPane(jTable);
		jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		jButtonInsert = new JButton("����");
		jButtonUpdate = new JButton("�޸�");
		jButtonDelete = new JButton("ɾ��");
		jButtonSearch = new JButton("��ѯ");
		jButtonDisplay = new JButton("��ʾȫ��");
		jTextFieldId = new JTextField(7);
		jTextFieldName = new JTextField(7);
		jTextFieldBir = new JTextField(7);
		bg = new ButtonGroup();
		jRadioButtonMale = new JRadioButton("��", true);
		jRadioButtonFemale = new JRadioButton("Ů");
		bg.add(jRadioButtonMale);
		bg.add(jRadioButtonFemale);
		jLabelId = new JLabel("ѧ��");
		jLabelName = new JLabel("����");
		jLabelBir = new JLabel("��������");
		// ����
		jP1.setLayout(new BorderLayout());
		jP2.setLayout(new BorderLayout());
		jP2.add(jScrollPane, BorderLayout.CENTER);
		jP3.setLayout(new FlowLayout());
		jP3.add(jLabelId);
		jP3.add(jTextFieldId);
		jP3.add(jLabelName);
		jP3.add(jTextFieldName);
		jP3.add(jRadioButtonMale);
		jP3.add(jRadioButtonFemale);
		jP3.add(jLabelBir);
		jP3.add(jTextFieldBir);
		jP1.add(jP2, BorderLayout.CENTER);
		jP1.add(jP3, BorderLayout.SOUTH);
		jP5.setLayout(new GridLayout(1, 6, 10, 10));
		jP5.add(jButtonInsert);
		jP5.add(jButtonUpdate);
		jP5.add(jButtonDelete);
		jP5.add(jButtonSearch);
		jP5.add(jButtonDisplay);
		frame.getContentPane().add(jP1, "Center");
		frame.getContentPane().add(jP5, "South");

		// ע���¼�����
		jTable.getSelectionModel().addListSelectionListener(new EventHandler(this));
		jButtonInsert.addActionListener(new EventHandler(this));
		jButtonUpdate.addActionListener(new EventHandler(this));
		jButtonDelete.addActionListener(new EventHandler(this));
		jButtonSearch.addActionListener(new EventHandler(this));
		jButtonDisplay.addActionListener(new EventHandler(this));

		// �������ݿ�����
		MySQLDBOperation.connect();
		// ����displayAll����
		new EventHandler(this).displayAll();
		frame.setSize(600, 250);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter() { // ���ڹر��¼�����
			public void windowClosing(WindowEvent e) {
				MySQLDBOperation.close(); // �ر����ݿ�
				System.exit(0);
			}
		});

	}
}

class EventHandler implements ActionListener, ListSelectionListener { /* �¼������� */
	StuManageGUI smg;

	public EventHandler(StuManageGUI smg) {
		super();
		this.smg = smg;

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == smg.jButtonInsert) {
			insert();

		} else if (e.getSource() == smg.jButtonUpdate) {
			update();
		} else if (e.getSource() == smg.jButtonDelete) {
			delete();
		} else if (e.getSource() == smg.jButtonSearch) {
			query();
		} else {
			displayAll();
		}

	}

	// �޸İ�ť�¼�����
	public void update() {
		int row = smg.jTable.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(null, "��ѡ��Ҫ�޸ĵļ�¼");
		} else {
			String id = (String) smg.jTable.getValueAt(row, 0);
			String name = smg.jTextFieldName.getText();
			String sex = "";
			if (smg.jRadioButtonMale.isSelected())
				sex = "��";
			else
				sex = "Ů";
			String bir = smg.jTextFieldBir.getText();
			if (id.length() < 1) {
				JOptionPane.showMessageDialog(null, "������ѧ��");
			} else {
				String sqlU = "update student  set sname='" + name + "' , gender='" + sex + "' , birthday='" + bir
						+ "' where sid='" + id + "'";
				MySQLDBOperation.update(sqlU);
				smg.dtm.setValueAt(id, row, 0);
				smg.dtm.setValueAt(name, row, 1);
				smg.dtm.setValueAt(sex, row, 2);
				smg.dtm.setValueAt(bir, row, 3);
				clear();
			}
		}
	}

	// ɾ����ť�¼�����
	public void delete() {
		int row = smg.jTable.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(null, "��ѡ��ɾ������");

		} else {
			int res;
			res = JOptionPane.showConfirmDialog(null, "ȷ��ɾ��?", "Confirm  Delete", JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE);
			if (res == JOptionPane.YES_OPTION) {
				String id = (String) smg.jTable.getValueAt(row, 0);
				String sqlU = "delete from student where sid='" + id + "'";
				MySQLDBOperation.update(sqlU);
				smg.dtm.removeRow(row);
			}
			clear();
		}
	}

	// ���Ӱ�ť�¼�����
	public void insert() {
		String id = smg.jTextFieldId.getText();
		String name = smg.jTextFieldName.getText();
		String sex = "";
		if (smg.jRadioButtonMale.isSelected())
			sex = "��";
		else
			sex = "Ů";
		String bir = smg.jTextFieldBir.getText();
		if (id.length() < 1) {
			JOptionPane.showMessageDialog(null, "������ѧ��");
		} else {
			String sqlQ = "select * from student  where sid='" + id + "'";
			try {
				ResultSet rs = MySQLDBOperation.query(sqlQ);
				if (rs.next()) {
					JOptionPane.showMessageDialog(null, "�Ѿ����ڵ�ѧ��");
				} else {
					String sqlU = "insert into student(sid,sname,gender,birthday) values('" + id + "','" + name + "','"
							+ sex + "','" + bir + "')";
					MySQLDBOperation.update(sqlU);
					Vector<String> row = new Vector<String>();
					row.add(id);
					row.add(name);
					row.add(sex);
					row.add(bir);
					smg.dtm.addRow(row);
					clear();
				}

			} catch (SQLException e1) {
				e1.printStackTrace();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

	}

	// ��ѯ��ť�¼�����
	public void query() {
		String id = smg.jTextFieldId.getText();
		String name = smg.jTextFieldName.getText();
		String sex = "";
		if (smg.jRadioButtonMale.isSelected())
			sex = "��";
		else
			sex = "Ů";
		String bir = smg.jTextFieldBir.getText();
		String sqlQ = "";
		if (bir.equals("")) {
			sqlQ = "select * from student  where sid like '%" + id + "%' and sname like '%" + name
					+ "%' and gender like '%" + sex + "%'";
		} else {
			sqlQ = "select * from student  where sid like '%" + id + "%' and sname like '%" + name
					+ "%' and gender like '%" + sex + "%' and birthday='" + bir + "'";
		}
		try {
			Vector<String> vector = new Vector<String>();
			vector.add("ѧ��");
			vector.add("����");
			vector.add("�Ա�");
			vector.add("��������");
			Vector<Vector<String>> data = new Vector<Vector<String>>();

			ResultSet rs = MySQLDBOperation.query(sqlQ);
			while (rs.next()) {
				String r_id = rs.getString("sid");
				String r_name = rs.getString("sname");
				String r_sex = rs.getString("gender");
				String r_bir = rs.getDate("birthday").toString();

				Vector<String> row = new Vector<String>();
				row.add(r_id);
				row.add(r_name);
				row.add(r_sex);
				row.add(r_bir);
				data.add(row);
			}
			smg.dtm.setDataVector(data, vector);
			clear();

			if (rs != null)
				rs.close();

		} catch (SQLException e1) {
			e1.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ��ʾȫ����ť�¼�����
	public void displayAll() {
		String sql = "select * from student";
		Vector<String> vector = new Vector<String>();
		vector.add("ѧ��");
		vector.add("����");
		vector.add("�Ա�");
		vector.add("��������");
		Vector<Vector<String>> data = new Vector<Vector<String>>();
		try {
			ResultSet rs = MySQLDBOperation.query(sql);
			while (rs.next()) {
				String id = rs.getString("sid");
				String name = rs.getString("sname");
				String sex = rs.getString("gender");
				String bir = rs.getDate("birthday").toString();

				Vector<String> row = new Vector<String>();
				row.add(id);
				row.add(name);
				row.add(sex);
				row.add(bir);
				data.add(row);
			}
			smg.dtm.setDataVector(data, vector);
			clear();
		} catch (SQLException e) {
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// ѡȡ�������
	public void valueChanged(ListSelectionEvent e) {
		clear();
		int row = smg.jTable.getSelectedRow();
		if (row >= 0) {
			String id = (String) smg.jTable.getValueAt(row, 0);
			String name = (String) smg.jTable.getValueAt(row, 1);
			if (((String) smg.jTable.getValueAt(row, 2)).equals("��"))
				smg.jRadioButtonMale.setSelected(true);
			else
				smg.jRadioButtonFemale.setSelected(true);
			String bir = (String) smg.jTable.getValueAt(row, 3);
			smg.jTextFieldId.setText(id);
			smg.jTextFieldName.setText(name);
			smg.jTextFieldBir.setText(bir);
		}
	}

	// ����ı���
	public void clear() {
		smg.jTextFieldId.setText("");
		smg.jTextFieldName.setText("");
		smg.jTextFieldBir.setText("");
		smg.jRadioButtonMale.setSelected(true);
	}
}

public class App7_5 { /* ������ */
	public static void main(String[] args) {
		new StuManageGUI();
	}

}
