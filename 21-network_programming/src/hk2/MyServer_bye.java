package hk2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MyServer_bye {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		BufferedWriter bufferedWriter = null;
		BufferedReader bufferedReader = null;

		try {
			serverSocket = new ServerSocket(7890);
			System.out.println("Server: wait for connection...");
			socket = serverSocket.accept();

			System.out.println("successfully connects client " + socket.getInetAddress().getHostName());
			send(socket, bufferedWriter);

			while (!recv(socket, bufferedReader).equalsIgnoreCase("bye")) {
				if (send(socket, bufferedWriter).equalsIgnoreCase("bye"))
					break;
			}

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

	public static String recv(Socket socket, BufferedReader bufferedReader) {
		String line = null;
		try {
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			line = bufferedReader.readLine();
			System.out.println("Client: " + line);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			return line;
		}

	}

	public static String send(Socket socket, BufferedWriter bufferedWriter) {
		System.out.print(">>> ");
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		try {

			bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			bufferedWriter.write(line);
			bufferedWriter.newLine();
			bufferedWriter.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			return line;
		}
	}
}
