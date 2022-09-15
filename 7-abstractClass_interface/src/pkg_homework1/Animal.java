package pkg_homework1;

//	1、创建⼀个抽象动物类，包括：进⾷、睡觉、思考、说话、飞翔。
//	分别定义猫类、⼈类、鸟类继承动物类并选择实现上述的接⼝，并创建实例验证。
public abstract class Animal {
	public void eat() {
		System.out.println("common action: eating");
	}

	public void sleep() {
		System.out.println("common action: sleeping");
	}

	public abstract void action();
}

class Cat extends Animal {

	@Override
	public void action() {
		// TODO Auto-generated method stub
		System.out.println("cat's action: catching mouse");
	}

}

class Human extends Animal {

	@Override
	public void action() {
		// TODO Auto-generated method stub
		System.out.println("human action: saying and thinking");
	}

}

class Bird extends Animal {

	@Override
	public void action() {
		// TODO Auto-generated method stub
		System.out.println("bird action: flying");
	}

}