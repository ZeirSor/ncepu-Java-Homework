package Exe1;

public class StackTest {
	public static void main(String[] args) {
		Stack stack = new Stack(3);
//		System.out.println(stack.toString());

		System.out.println(stack.isEmpty());

		System.out.println("---------isEmpty-------------");

		stack.push(2);
		System.out.println(stack);
		stack.push(5);
		stack.push(3);
		stack.push(7);
		stack.push(8);
		stack.push(10);

		System.out.println("size = " + stack.size());

		System.out.println("---------pop-------------");

		for (int e : stack.getStack()) {
			if (e == 0)
				break;
			System.out.println(e);
		}

		System.out.println("------------traverse----------------");

		System.out.println(stack.getIndex());

		System.out.println("------------index----------------");

		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());

		System.out.println("size = " + stack.size());

		System.out.println("------------pop----------------");

		System.out.println(stack.getIndex());

		System.out.println("------------index----------------");

		for (int e : stack.getStack()) {
			if (e == 0)
				break;
			System.out.println(e);
		}

		System.out.println("------------traverse----------------");

		System.out.println(stack.isEmpty());

		System.out.println("---------isEmpty-------------");

		System.out.println(stack);
	}
}
