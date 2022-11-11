package hk2;

import java.util.Calendar;

//	2、编写一个线程模拟一门课程的上课过程，主线程控制在45秒后暂停该课程，10秒之后再次继续该课程，然后45秒之后课程结束。

public class CoursePauseThread implements Runnable {

	// 结束课程标志
	private boolean flagStop = false;
	// 暂停课程标志
	private boolean flagPause = false;

	public void stopCourse() {
		flagStop = !flagStop;
	}

	public void changCourseStatement() {
		// 如果之前暂停了 就提示继续
		if (flagPause == true)
			System.out.println(Thread.currentThread().getName() + " continues now.\t" + currentTime());
		flagPause = !flagPause;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		// 上课
		while (!flagStop) {
			// 课间
			if (!flagPause) {
				System.out.println(Thread.currentThread().getName() + " is having class now.\t" + currentTime());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else { // 下课
				System.out.println(Thread.currentThread().getName() + " is stopping now.\t\t" + currentTime());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		System.out.println("finish class!\t\t\t" + currentTime());
	}

	public static void main(String[] args) {

		CoursePauseThread task = new CoursePauseThread();
		Thread th = new Thread(task);

		th.start();

		CoursePauseThread.continueCourse(task, 45);
		CoursePauseThread.pauseCourse(task, 10);
		CoursePauseThread.continueCourse(task, 45);

		task.stopCourse();

	}

	// 上课
	public static void continueCourse(CoursePauseThread task, int conTime) {
		int startTime = 0;
		while (startTime < conTime) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			startTime++;
		}
	}

	// 课间暂停
	public static void pauseCourse(CoursePauseThread task, int pauseTime) {
		task.changCourseStatement();
		int startTime = 0;
		while (startTime < pauseTime) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			startTime++;
		}
		task.changCourseStatement();
	}

	// 获取当前时间
	public String currentTime() {
		Calendar calendar = Calendar.getInstance();
		int hour = calendar.get(calendar.HOUR);
		int minute = calendar.get(calendar.MINUTE);
		int second = calendar.get(calendar.SECOND);
		return "" + hour + ":" + minute + ":" + second;
	}

}
