package NetUser;

public class NetUser {
//	定义一个网络用户类，要处理的信息有用户ID、用户密码、email地址。
//	在建立类的实例时，把以上三个信息都作为构造函数的参数输入，
//	其中用户ID和用户密码时必须的，缺省的email地址是用户ID加上字符串"@ncepu.edu.cn"
	private String id;
	private String password;
	private String email;

	public NetUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NetUser(String id, String password, String email) {
		super();
		this.id = id;
		this.password = password;
		this.email = email;
	}

	public NetUser(String id, String password) {
		super();
		this.id = id;
		this.password = password;
		this.email = id + "@ncepu.edu.cn";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "NetUser [id = " + id + ", password = " + password + ", email = " + email + "]";
	}

	public void shotInfo() {
		System.out.println(this.toString());
	}

}
