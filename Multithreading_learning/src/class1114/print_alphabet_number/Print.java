package class1114.print_alphabet_number;

public class Print {
	int flag = 0;

	public synchronized void printUpperCaseLetter() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 26; i++) {
			while (flag != 0) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.print((char) ('A' + i));
			flag = (flag + 1) % 3;
			notifyAll();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public synchronized void printLowerCaseLetter() {
		for (int i = 0; i < 26; i++) {
			while (flag != 1) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.print((char) ('a' + i));
			flag = (flag + 1) % 3;
			notifyAll();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public synchronized void printNumber() {
		for (int i = 0; i < 26; i++) {
			while (flag != 2) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.print(i + 1);
			flag = (flag + 1) % 3;
			notifyAll();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
