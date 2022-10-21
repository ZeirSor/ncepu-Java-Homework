package hk1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileDialogFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FileDialogFrame();
	}

	private JFrame frame = new JFrame("java-homework-15-fileDialog");
	private JPanel panel = new JPanel(new BorderLayout());
	private JPanel northPanel = new JPanel(new FlowLayout());
	private JButton openFileButton = new JButton("please select a file you want to open");
	private JPanel centerPanel = new JPanel(new FlowLayout());
	private JTextArea textArea = new JTextArea();

	public FileDialogFrame() {

		frame.setSize(1000, 800);

		northPanel.add(openFileButton);
		panel.add(northPanel, BorderLayout.NORTH);

		openFileButton.addActionListener(e -> openFile());

		centerPanel.add(textArea);
		panel.add(centerPanel, BorderLayout.CENTER);

		JScrollPane scrollPane = new JScrollPane(textArea);
		panel.add(scrollPane);
		frame.add(panel);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void openFile() {
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File("E:\\ncepu\\ncepu-Java-Homework\\15-decorateStream_fileDialog\\src"));
		FileNameExtensionFilter filter = new FileNameExtensionFilter(null, "*txt", "java");
		chooser.setFileFilter(filter);

		int res = chooser.showDialog(frame, "openFile");
		if (res == JFileChooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();
			frame.setTitle(frame.getTitle() + "-" + file.getAbsolutePath());
			String filePath = file.getAbsolutePath();

			readFileAndWriteToTextArea(filePath);
		}
	}

	private void readFileAndWriteToTextArea(String filePath) {
		BufferedInputStream bis = null;

		try {
			bis = new BufferedInputStream(new FileInputStream(filePath));

			int readLen = 0;
			byte[] buff = new byte[1024];

			while ((readLen = bis.read(buff)) != -1) {
				String readRes = new String(buff, 0, readLen);
				textArea.append(readRes);
				System.out.println(readRes);
			}

		} catch (IOException e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		} finally {
			try {
				bis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
