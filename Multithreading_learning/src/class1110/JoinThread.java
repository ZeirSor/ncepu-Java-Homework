package class1110;

public class JoinThread extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 27; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
	}

	public static void main(String[] args) {
		JoinThread jt = new JoinThread();
		jt.start();
		try {
			jt.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int i = 0; i < 27; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
	}
}
