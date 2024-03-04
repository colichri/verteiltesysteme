package de.mbg.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadServerMain {

	public void start() throws IOException {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(4449);
			System.out.println("MultiThreadServerMain.start: Server gestartet!");
			int counter = 0;
			while (true) {
				counter++;
				Socket socket = serverSocket.accept();
				System.out.println("MultiThreadServerMain.start: Client " + counter + " hat sich angemeldet.");
				ServerThread serverThread = new ServerThread(socket, counter);
				serverThread.start();
			}
		} finally {
			if (serverSocket != null)
				serverSocket.close();
		}
	}

	class ServerThread extends Thread {
		private int _threadNo;

		private Socket _socket;

		public ServerThread(Socket socket, int threadNo) {
			_socket = socket;
			_threadNo = threadNo;
		}

		@Override
		public void run() {
			try {
				InputStream in = null;
				try {
					in = _socket.getInputStream();
					String msg = "";
					for (int b = in.read(); b != -1; b = in.read()) {
						msg = msg + (char) b;
					}
					System.out.println("Nachricht von Client " + _threadNo + ": " + msg);

				} finally {
					if (in != null)
						in.close();
					if (_socket != null)
						_socket.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		MultiThreadServerMain mtsm = new MultiThreadServerMain();
		mtsm.start();
	}

}
