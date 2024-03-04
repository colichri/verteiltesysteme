package de.mbg.chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
	private List<ChatServerThread> _chatServerThreads;

	public ChatServer() {
		_chatServerThreads = new ArrayList<ChatServerThread>();
	}

	public void start() throws IOException {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(4449);
			System.out.println("ChatServer.start: Server gestartet!");
			int counter = 0;
			while (true) {
				counter++;
				Socket socket = serverSocket.accept();
				System.out.println("ChatServer.start: Client " + counter
						+ " hat sich angemeldet.");
				ChatServerThread clientThread = new ChatServerThread(this,
						socket, counter);
				_chatServerThreads.add(clientThread);
				clientThread.start();
			}
		} finally {
			if (serverSocket != null)
				serverSocket.close();
		}
	}

	public void distributeMsg(String msg) {
		for (ChatServerThread clientThread : _chatServerThreads) {
			try {
				clientThread.sendMessage(msg);
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
		ChatServer mtsm = new ChatServer();
		mtsm.start();
	}

}
