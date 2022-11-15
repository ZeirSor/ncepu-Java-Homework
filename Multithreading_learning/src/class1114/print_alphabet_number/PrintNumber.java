package class1114.print_alphabet_number;

public class PrintNumber implements Runnable {

	Print print = null;

	public PrintNumber(Print print) {
		this.print = print;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		print.printNumber();

	}
}
