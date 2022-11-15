package class1114.print_alphabet_number;

public class PrintLower implements Runnable {

	Print print = null;

	public PrintLower(Print print) {
		this.print = print;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		print.printLowerCaseLetter();

	}
}
