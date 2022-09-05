package pkg_homework3;

public class StringTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		3.编程比较两个String对象的大小，若字符串1和字符串2相等，显示相同；
//		若字符串1和字符串2不相等，则显示第一个不同字符的差值；
//		若字符串1和字符串2仅长度不同，则显示两者长度的差值
//		（可在main方法中之前对两个String对象赋值，通过赋不同的值来测试不同的情况）。
		ifStrEqual("string1", "string1");
		ifStrEqual("string1", "string2");
		ifStrEqual("string 1", "string 2");
		ifStrEqual("ncepu", "upecn");
		ifStrEqual("Hello world", "Hello World");
		ifStrEqual("Hello Java", "Hello Java");
		ifStrEqual("Hello world!", "Hello java!");
		ifStrEqual("Hello java!", "hello world");
		ifStrEqual("this is the first string", "second string");
		// output
//		相同
//		第7个字符不同, 差值为: 1
//		第8个字符不同, 差值为: 1
//		第1个字符不同, 差值为: 7
//		第7个字符不同, 差值为: 32
//		相同
//		两者长度相差 1
//		第1个字符不同, 差值为: 32
//		两者长度相差 11

	}

	public static void ifStrEqual(String str1, String str2) {
		if (str1.equals(str2)) {
//			若字符串1和字符串2相等，显示相同；
			System.out.println("相同");
		} else {
			if (str1.length() != str2.length()) {
//				若字符串1和字符串2仅长度不同，则显示两者长度的差值
				System.out.println("两者长度相差 " + Math.abs(str1.length() - str2.length()));
			} else {
				for (int i = 0; i < Math.min(str1.length(), str2.length()); i++) {
					if (str1.charAt(i) != str2.charAt(i)) {
						System.out.println("第" + (i + 1) + "个字符不同, 差值为: " + Math.abs(str1.charAt(i) - str2.charAt(i)));
						break;
					}
				}
			}
		}

	}
}
