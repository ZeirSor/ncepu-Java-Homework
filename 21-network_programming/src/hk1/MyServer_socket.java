package hk1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer_socket {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerSocket serverSocket = null;
		Socket socket = null;
		BufferedWriter bufferedWriter = null;
		BufferedReader bufferedReader = null;

		try {
			serverSocket = new ServerSocket(7890);
			System.out.println("Server: wait for connection...");
			socket = serverSocket.accept();

			System.out.println("successfully connects client " + socket.getInetAddress().getHostName());

			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String line = bufferedReader.readLine();
			System.out.println(line);

			bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			bufferedWriter.write("Server: Hello, I am server.");
			bufferedWriter.newLine();
			bufferedWriter.flush();

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
				serverSocket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
