package NamingSys;

import javax.swing.JTextArea;

public class Student implements Comparable<Student> {
	private String name;
	private int score;

	private int isLogged;

	public void log(JTextArea textArea) {
		synchronized (this) {
			if (this.isLogged == 0) {
				String logInfo = Thread.currentThread().getName() + " 注册了" + this.getName() + '\n';
				textArea.setText(textArea.getText() + logInfo);
				System.out.printf(logInfo);
				this.isLogged = 1;
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}

	public Student() {
	}

	public Student(String name) {
		this.name = name;
		this.score = 0;
	}

	@Override
	public int compareTo(Student o) {
		return -(this.getScore() - o.getScore());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Student{" + "name='" + name + '\'' + ", score=" + score + '}';
	}

}
