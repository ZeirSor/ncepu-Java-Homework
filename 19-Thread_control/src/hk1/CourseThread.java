package hk1;

import java.util.Calendar;

public class CourseThread extends Thread {

	private boolean flag = true;

	@Override
	public void run() {
		// TODO Auto-generated method stub

		while (flag) {
			System.out.println(Thread.currentThread().getName() + " is having class now.\t" + currentTime());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("finish class!\t\t\t" + currentTime());
	}

	public void stopCourse() {
		flag = false;
	}

	public static void main(String[] args) {
		int curTime = 0;

		CourseThread th = new CourseThread();
		th.start();

		while (curTime < 3) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			curTime++;
		}
		th.stopCourse();
	}

	public String currentTime() {
		Calendar calendar = Calendar.getInstance();
		int hour = calendar.get(calendar.HOUR);
		int minute = calendar.get(calendar.MINUTE);
		int second = calendar.get(calendar.SECOND);
		return "" + hour + ":" + minute + ":" + second;
	}
}
