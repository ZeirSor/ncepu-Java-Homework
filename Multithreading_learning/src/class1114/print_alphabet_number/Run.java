package class1114.print_alphabet_number;

public class Run {
	public static void main(String[] args) {
		Print print = new Print();

		PrintUpper printUpper = new PrintUpper(print);
		PrintLower printLower = new PrintLower(print);
		PrintNumber printNumber = new PrintNumber(print);

		Thread t1 = new Thread(printUpper);
		Thread t2 = new Thread(printLower);
		Thread t3 = new Thread(printNumber);

		t1.start();
		t2.start();
		t3.start();

	}
}
