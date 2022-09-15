package pkg_homework2;

//	2、将（1）题中的抽象动物类变为接口，再次完成相应的功能。

public interface AnimalInterface {
	public abstract void eat();

	public abstract void sleep();
}

class Cat implements AnimalInterface {

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("Cat is eating");
	}

	@Override
	public void sleep() {
		// TODO Auto-generated method stub
		System.out.println("Cat is sleeping");
	}

	public void action() {
		// TODO Auto-generated method stub
		System.out.println("cat's action: catching mouse");
	}

}

class Human implements AnimalInterface {

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("Human is eating");
	}

	@Override
	public void sleep() {
		// TODO Auto-generated method stub
		System.out.println("Human is eating");
	}

	public void action() {
		// TODO Auto-generated method stub
		System.out.println("human action: saying and thinking");
	}

}

class Bird implements AnimalInterface {

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("Bird is eating");
	}

	@Override
	public void sleep() {
		// TODO Auto-generated method stub
		System.out.println("Bird is eating");
	}

	public void action() {
		// TODO Auto-generated method stub
		System.out.println("bird action: flying");
	}

}
