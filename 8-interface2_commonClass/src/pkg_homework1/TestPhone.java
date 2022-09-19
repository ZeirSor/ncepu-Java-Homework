package pkg_homework1;

public class TestPhone {
	public static void main(String[] args) {

//		分别定义打电话、发短信、行程导航的接口，然后定义智能机和老年机，并验证。

		MobilePhone mb = new MobilePhone();
		mb.call_phone();
		mb.text_phone();
		mb.navigate_phone();
		System.out.println("---------------------");

		ElderlyPhone ep = new ElderlyPhone();
		ep.call_phone();
		ep.text_phone();

		// output
//		MobilePhone.call_phone
//		MobilePhone.text_phone
//		MobilePhone.navigate_phone
//		---------------------
//		ElderlyPhone.call_phone
//		ElderlyPhone.text_phone

	}
}
