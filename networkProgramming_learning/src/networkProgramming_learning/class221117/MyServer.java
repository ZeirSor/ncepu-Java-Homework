package networkProgramming_learning.class221117;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(6666);
			System.out.println("Server: wait for connection...");
			Socket socket = ss.accept();

			System.out.println("Hi, " + socket.getInetAddress().getLocalHost());

			OutputStreamWriter osw = new OutputStreamWriter(socket.getOutputStream());
			BufferedWriter bw = new BufferedWriter(osw);
			bw.write("Zs is in class...");
			bw.newLine();
			bw.flush();

			InputStreamReader isr = new InputStreamReader(socket.getInputStream());
			BufferedReader br = new BufferedReader(isr);
			String msg = br.readLine();
			System.out.println(msg);

			bw.close();
			br.close();

			socket.close();
			ss.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
