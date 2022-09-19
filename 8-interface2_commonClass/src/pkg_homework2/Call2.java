package pkg_homework2;

//分别定义打电话、发短信、行程导航的接口，然后定义智能机和老年机，并验证。

interface Call2 {
	public abstract void call_phone();
}

interface Text {
	public abstract void text_phone();
}

interface Navigate {
	public abstract void navigate_phone();

//	为行程导航接口增加查找加油站的缺省方法，并在智能机中重新定义该方法。
	public default void findGasStation() {
		System.out.println("findGasStation");
	}
}

abstract class Phone implements Call2, Text {
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

//	为行程导航接口增加查找加油站的缺省方法，并在智能机中重新定义该方法。
	@Override
	public void findGasStation() {
		// TODO Auto-generated method stub
		Navigate.super.findGasStation();
		System.out.println("MobilePhone-findGasStation");
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