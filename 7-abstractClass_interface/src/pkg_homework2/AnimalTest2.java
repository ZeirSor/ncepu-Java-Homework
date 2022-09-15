package pkg_homework2;

public class AnimalTest2 {
	public static void main(String[] args) {
		Cat c = new Cat();
		c.eat();
		c.sleep();
		c.action();
		System.out.println("----------------------------------");

		Human h = new Human();
		h.eat();
		h.sleep();
		h.action();
		System.out.println("----------------------------------");

		Bird b = new Bird();
		b.eat();
		b.sleep();
		b.action();
		System.out.println("----------------------------------");

		// output
//		Cat is eating
//		Cat is sleeping
//		cat's action: catching mouse
//		----------------------------------
//		Human is eating
//		Human is eating
//		human action: saying and thinking
//		----------------------------------
//		Bird is eating
//		Bird is eating
//		bird action: flying
//		----------------------------------
	}
}
