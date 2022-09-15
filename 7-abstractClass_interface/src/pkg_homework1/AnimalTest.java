package pkg_homework1;

public class AnimalTest {
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
//		common action: eating
//		common action: sleeping
//		cat's action: catching mouse
//		----------------------------------
//		common action: eating
//		common action: sleeping
//		human action: saying and thinking
//		----------------------------------
//		common action: eating
//		common action: sleeping
//		bird action: flying
//		----------------------------------

	}
}
