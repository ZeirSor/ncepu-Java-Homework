package pkg_homework1;

//分别定义打电话、发短信、行程导航的接口，然后定义智能机和老年机，并验证。

interface Call {
	public abstract void call_phone();
}

interface Text {
	public abstract void text_phone();
}

interface Navigate {
	public abstract void navigate_phone();
}

abstract class Phone implements Call, Text {
	private String name;

	public Phone(String name) {
		super();
		this.name = name;
	}

	public Phone() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

class MobilePhone extends Phone implements Navigate {

	public MobilePhone() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MobilePhone(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void navigate_phone() {
		// TODO Auto-generated method stub
		System.out.println("MobilePhone.navigate_phone");

	}

	@Override
	public void call_phone() {
		// TODO Auto-generated method stub
		System.out.println("MobilePhone.call_phone");
	}

	@Override
	public void text_phone() {
		// TODO Auto-generated method stub
		System.out.println("MobilePhone.text_phone");
	}

}

class ElderlyPhone extends Phone {

	public ElderlyPhone() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ElderlyPhone(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void call_phone() {
		// TODO Auto-generated method stub
		System.out.println("ElderlyPhone.call_phone");
	}

	@Override
	public void text_phone() {
		// TODO Auto-generated method stub
		System.out.println("ElderlyPhone.text_phone");
	}

}