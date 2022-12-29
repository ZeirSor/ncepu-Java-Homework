package questionAB;

import javax.swing.JTextArea;

public class Question {
//  试题内容
	private String description;
//  试题选中状态
	private boolean isSelected = false;

//  试题选中方法
	public int turnSelected(int nums, JTextArea textArea) {
		synchronized (this) {
			if (this.isSelected == false) {
				this.setSelected(true);
				String info = Thread.currentThread().getName() + " " + this.description;
				System.out.println(info);
				textArea.setText(textArea.getText() + this.description + '\n');
//              选中的试题量+1
				nums++;
			}
			return nums;
		}
	}

//  初始化所有试题选中状态：未选中
	public static void initSelected(Question[] questions) {
		for (Question question : questions) {
			question.setSelected(false);
		}
	}

	public Question() {
	}

	public Question(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Question{" + "description='" + description + '\'' + ", isSelected=" + isSelected + '}';
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isSelected() {
		return isSelected;
	}

	public void setSelected(boolean selected) {
		isSelected = selected;
	}
}
