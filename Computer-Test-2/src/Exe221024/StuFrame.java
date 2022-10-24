package Exe221024;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

public class StuFrame implements ActionListener {
	public static void main(String[] args) {
//		System.out.println("hello world");/
		new StuFrame();
	}

	private JFrame frame = new JFrame("Student Information Management System");

	private JPanel idPanel = new JPanel();
	private JLabel idJLabel = new JLabel("ID:");
	private JTextArea idTextArea = new JTextArea(1, 10);

	private JPanel namePanel = new JPanel();
	private JLabel nameLabel = new JLabel("Name:");
	private JTextArea nameTextArea = new JTextArea(1, 10);

	private JPanel genderPanel = new JPanel();
	private JLabel genderLabel = new JLabel("gender:");
	private ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton manRadioButton = new JRadioButton("man");
	private JRadioButton womanRadioButton = new JRadioButton("woman");

	private JPanel buttonPanel = new JPanel();
	private JButton saveButton = new JButton("save");
	private JButton openButton = new JButton("open");
	private JButton lastButton = new JButton("last student");
	private JButton nextButton = new JButton("next student");

	// save students
	private int showIndex = 0;
	ArrayList<Student> studentList = new ArrayList<>();

	public StuFrame() {
		frame.setSize(600, 150);
		frame.setLayout(new FlowLayout());
		frame.setLocationRelativeTo(null);

		idPanel.add(idJLabel);
		idPanel.add(idTextArea);
		frame.add(idPanel);

		namePanel.add(nameLabel);
		namePanel.add(nameTextArea);
		frame.add(namePanel);

		genderPanel.add(genderLabel);
		genderPanel.add(manRadioButton);
		genderPanel.add(womanRadioButton);
		buttonGroup.add(manRadioButton);
		buttonGroup.add(womanRadioButton);
		frame.add(genderPanel);

		saveButton.addActionListener(e -> {
			String id = idTextArea.getText();
			String name = nameTextArea.getText();
			String gender = manRadioButton.isSelected() ? manRadioButton.getText() : womanRadioButton.getText();
			Student student = new Student(id, name, gender);

			studentList.add(student);

			System.out.println(studentList.size());

			String destPath = "E:\\ncepu\\ncepu-Java-Homework\\Computer-Test-2\\src\\Exe221024\\stuTest.zs";

			try {
				writeObject(destPath, studentList);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			System.out.println(student.toString());

		});
		openButton.addActionListener(e -> {
			JFileChooser chooser = new JFileChooser();
			chooser.setCurrentDirectory(new File("E:\\ncepu\\ncepu-Java-Homework\\Computer-Test-2\\src\\Exe221024"));
			FileNameExtensionFilter filter = new FileNameExtensionFilter(null, "zs");
			chooser.setFileFilter(filter);

			int res = chooser.showOpenDialog(frame);
			if (res == JFileChooser.APPROVE_OPTION) {
				String srcPath = chooser.getSelectedFile().getAbsolutePath();
				try {
					readObject(srcPath);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println(srcPath);
			}
		});

		lastButton.addActionListener(e -> {

			if (showIndex == 0) {
				System.out.println("Array Index Out Of Bounds");
			} else {
				showIndex--;
				showStudent(studentList, showIndex);
			}

			System.out.println("studentList.size() = " + studentList.size());
			System.out.println("showIndex = " + showIndex);
		});

		nextButton.addActionListener(e -> {

			if (showIndex == studentList.size() - 1) {
				System.out.println("Array Index Out Of Bounds");
			} else {
				showIndex++;
				showStudent(studentList, showIndex);
			}

			System.out.println("studentList.size() = " + studentList.size());
			System.out.println("showIndex = " + showIndex);
		});

		buttonPanel.add(saveButton);
		buttonPanel.add(openButton);
		buttonPanel.add(lastButton);
		buttonPanel.add(nextButton);
		frame.add(buttonPanel);

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void writeObject(String filePath, ArrayList<Student> studentList) throws FileNotFoundException, IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));

		oos.writeObject(studentList);

		oos.close();
	}

	public void readObject(String filePath) throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath));

		studentList = (ArrayList<Student>) ois.readObject();

		showStudent(studentList, showIndex);

		ois.close();
	}

	public void showStudent(ArrayList<Student> studentList, int index) {

		idTextArea.setText(studentList.get(index).getId());
		nameTextArea.setText(studentList.get(index).getName());
		String gender = studentList.get(index).getGender();

		if (gender.equalsIgnoreCase("man")) {
			manRadioButton.setSelected(true);
		} else {
			womanRadioButton.setSelected(true);
		}

		System.out.println(studentList.get(index).toString());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}

}