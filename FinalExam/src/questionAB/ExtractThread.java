package questionAB;

import javax.swing.JTextArea;

public class ExtractThread implements Runnable {
	Question[] selectQuestions;
	Question[] blankQuestions;
	JTextArea textArea;

	public ExtractThread(Question[] selectQuestions, Question[] blankQuestions, JTextArea textArea) {
		this.selectQuestions = selectQuestions;
		this.blankQuestions = blankQuestions;
		this.textArea = textArea;
	}

	@Override
	public void run() {
//        记录已经生成的试题数量
		int selectedNums = 0;
		int blankNums = 0;

//        各生成4道题
		while (selectedNums < 4 || blankNums < 4) {
			if (selectedNums < 4)
				selectedNums = selectQuestions[(int) (Math.random() * 10)].turnSelected(selectedNums, textArea);
			if (blankNums < 4)
				blankNums = blankQuestions[(int) (Math.random() * 10)].turnSelected(blankNums, textArea);
		}
	}
}
