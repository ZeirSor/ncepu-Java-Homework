package class1114.print_alphabet_number;

public class PrintUpper implements Runnable {
	Print print = null;

	public PrintUpper(Print print) {
		this.print = print;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		print.printUpperCaseLetter();
	}
}
