package NetUser;

public class TestNetUser {
	// Net User test class
	public static void main(String[] args) {
		new NetUser().shotInfo();

		new NetUser("120211080526", "1234qwer").shotInfo();

		new NetUser("120211080526", "1234qwer", "Szpsn2357@gmail.com").shotInfo();

		// output
//		NetUser [id = null, password = null, email = null]
//		NetUser [id = 120211080526, password = 1234qwer, email = 120211080526@ncepu.edu.cn]
//		NetUser [id = 120211080526, password = 1234qwer, email = Szpsn2357@gmail.com]
	}
}
