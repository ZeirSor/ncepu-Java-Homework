package pkg1_arrayStringTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.function.Consumer;

public class ArrayListStringTest {
	public static void main(String[] args) {

//		1、从键盘输入若干个字符串，存入ArrayList中，并遍历显示，查找某个字符串并将其删除。

		Scanner sc = new Scanner(System.in);

		ArrayList<String> alstr = new ArrayList<>();

		System.out.println("Please enter a string: (Enter \"exit\" to exit)");
		String str;
		while (true) {
			str = sc.nextLine();
			if (str.equalsIgnoreCase("exit")) {
				System.out.println("enter stopp!");
				break;
			} else {
				alstr.add(str);
				System.out.println("keep enter (Enter \"exit\" to exit)");
			}
		}
		System.out.println("----------------------------------");
		System.out.println(alstr);
		System.out.println("----------------------------------");

		System.out.println("Traversal way 1");
		Iterator<String> it = alstr.iterator();
		while (it.hasNext())
			System.out.println(it.next());
		System.out.println("----------------------------------");

		System.out.println("Traversal way 2");
		for (String i : alstr)
			System.out.println(i);
		System.out.println("----------------------------------");

		System.out.println("Traversal way 3");
		alstr.forEach(new Consumer<String>() {
			@Override
			public void accept(String t) {
				// TODO Auto-generated method stub
				System.out.println(t);
			}
		});
		System.out.println("----------------------------------");

		System.out.println("Traversal way 4");
		alstr.forEach(s -> System.out.println(s));
		System.out.println("----------------------------------");

		System.out.println("enter a string you want to find");
		String str_find;

		while (true) {
			str_find = sc.nextLine();
			if (alstr.contains(str_find)) {
				int index = alstr.indexOf(str_find);
				System.out.println("the string exists, " + "index = " + index);
				String rm = alstr.remove(index);
				System.out.println("\"" + rm + "\" has been removed!");
				break;
			} else {
				System.out.println("the element does not exist! ! !\nplease enter again! ! !");
			}
		}

		System.out.println(alstr);
		// output
//		Please enter a string: (Enter "exit" to exit)
//		aaa
//		keep enter (Enter "exit" to exit)
//		bbb
//		keep enter (Enter "exit" to exit)
//		ccc
//		keep enter (Enter "exit" to exit)
//		ddd
//		keep enter (Enter "exit" to exit)
//		eee
//		keep enter (Enter "exit" to exit)
//		fff
//		keep enter (Enter "exit" to exit)
//		exit
//		enter stopp!
//		----------------------------------
//		[aaa, bbb, ccc, ddd, eee, fff]
//		----------------------------------
//		Traversal way 1
//		aaa
//		bbb
//		ccc
//		ddd
//		eee
//		fff
//		----------------------------------
//		Traversal way 2
//		aaa
//		bbb
//		ccc
//		ddd
//		eee
//		fff
//		----------------------------------
//		Traversal way 3
//		aaa
//		bbb
//		ccc
//		ddd
//		eee
//		fff
//		----------------------------------
//		Traversal way 4
//		aaa
//		bbb
//		ccc
//		ddd
//		eee
//		fff
//		----------------------------------
//		enter a string you want to find
//		asdf
//		the element does not exist! ! !
//		please enter again! ! !
//		eee
//		the string exists, index = 4
//		"eee" has been removed!
//		[aaa, bbb, ccc, ddd, fff]

	}
}

