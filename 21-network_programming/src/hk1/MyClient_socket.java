package hk1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class MyClient_socket {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Socket socket = null;
		BufferedWriter bufferedWriter = null;
		BufferedReader bufferedReader = null;

		try {
			System.out.println("Client: prepare to connect...");
			socket = new Socket("localhost", 7890);

			System.out.println("successfully connects server " + socket.getInetAddress().getHostName());

			bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			bufferedWriter.write("Client: Hello, I am client.");
			bufferedWriter.newLine();
			bufferedWriter.flush();

			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String line = bufferedReader.readLine();
			System.out.println(line);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (bufferedWriter != null)
					bufferedWriter.close();
				if (bufferedReader != null)
					bufferedReader.close();
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
