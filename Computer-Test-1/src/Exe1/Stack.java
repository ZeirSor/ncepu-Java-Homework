package Exe1;

import java.util.Arrays;

public class Stack {
	private int[] stack = new int[10];
	private int index;

	public int size() {
		return index;
	}

	public void push(int e) {

		if (isFull()) {
			System.out.println("stack is full!");
			return;
		}

		stack[index++] = e;
	}

	public int pop() {

		if (isEmpty()) {
			System.out.println("stack is empty!");
			return -1;
		}

		int res = stack[--index];
		stack[index] = 0;
		return res;
	}

	public boolean isEmpty() {
		if (this.index == 0)
			return true;
		else
			return false;
	}

	public boolean isFull() {
		if (this.index == this.stack.length)
			return true;
		else
			return false;
	}

	public Stack() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Stack(int size) {
		super();
		stack = new int[size];
	}

	public int[] getStack() {
		return stack;
	}

	public void setStack(int[] stack) {
		this.stack = stack;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	@Override
	public String toString() {
		return "Stack [stack=" + Arrays.toString(stack) + ", index=" + index + "]";
	}

}
