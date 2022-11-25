package networkProgramming_learning.class221117;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class MyClient {
	public static void main(String[] args) {
		try {
			System.out.println("Client: prepare to connect...");
			Socket socket = new Socket("localhost", 6666);
			System.out.println("Hi, " + socket.getInetAddress().getLocalHost());

			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String msg = br.readLine();
			System.out.println(msg);

			OutputStreamWriter osw = new OutputStreamWriter(socket.getOutputStream());
			BufferedWriter bw = new BufferedWriter(osw);
			bw.write("yes, he is in class.");
			bw.newLine();
			bw.flush();
//			socket.shutdownOutput();

			bw.close();
			br.close();

			socket.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
