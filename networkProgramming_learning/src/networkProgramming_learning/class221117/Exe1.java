package networkProgramming_learning.class221117;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Exe1 {
	public static void main(String[] args) {
		try {
			InetAddress address = InetAddress.getByName("www.ncepu.edu.cn");
			System.out.println(address);
			InetAddress address2 = InetAddress.getLocalHost();
			System.out.println(address2);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
