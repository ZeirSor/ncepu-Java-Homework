package NamingSys;

import javax.swing.JTextArea;

public class LogThread implements Runnable {

	Student[] students;
	JTextArea textArea;
	int logIndex = 0;

	public LogThread(Student[] students, JTextArea textArea) {
		this.students = students;
		this.textArea = textArea;
	}

	@Override
	public void run() {
		while (logIndex <= students.length - 1) {
			students[logIndex].log(textArea);
			logIndex++;
		}
	}

}
