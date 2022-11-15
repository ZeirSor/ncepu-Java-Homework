package hk1;

import java.util.ArrayList;
import java.util.Random;

public class GenerateNumber {

	public ArrayList<Integer> list = new ArrayList<>();

	public int flag = 0;

	public int pk = 0;

	public int[] randNum = new int[2];
	public ArrayList<Thread> thList = new ArrayList<>() {
		{
			add(null);
			add(null);
		}
	};
	public int[] winCount = { 0, 0 };

	public synchronized int generateUnrepeatNumber(int range) {
		Random random = new Random();
		int res = random.nextInt(range);
		if (list.contains(res)) {
			res = generateUnrepeatNumber(range);
		} else {
			System.out.println(Thread.currentThread().getName() + " generate the number: " + res);
			list.add(res);

			randNum[pk] = res;
			thList.set(pk, Thread.currentThread());
//            System.out.println(" " + pk);
			pk += 1;

			if (pk == 1) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			}

			if (pk == 2) {
				pk = 0;
				int index = getMaxIndex(randNum);
				if (index == 0) {
					System.out.println(thList.get(0).getName() + ": " + randNum[0] + " > " + thList.get(1).getName()
							+ ": " + randNum[1]);
				} else {
					System.out.println(thList.get(0).getName() + ": " + randNum[0] + " < " + thList.get(1).getName()
							+ ": " + randNum[1]);
				}
				winCount[index] += 1;
				this.notifyAll();
			}

//            System.out.println("  " + flag);
			flag++;
			if (flag == range) {
				flag = 0;
			}
		}
		return res;
	}

	private int getMaxIndex(int[] arr) {
		int index = 0;
		int max = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
				index = i;
			}
		}
		return index;
	}

	public void getWin() {
		int index = getMaxIndex(winCount);
		System.out.println(thList.get(0).getName() + " win count: " + winCount[0]);
		System.out.println(thList.get(1).getName() + " win count: " + winCount[1]);
		System.out.println(thList.get(index).getName() + " win!");
	}

}
