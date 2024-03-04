package de.mbg.chat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ChatServerThread extends Thread {
	private int _threadNo;

	private Socket _socket;

	private InputStream _in;

	private OutputStream _out;

	private ChatServer _chatServer;

	public ChatServerThread(ChatServer chatServer, Socket socket, int threadNo)
			throws IOException {
		_chatServer = chatServer;
		_socket = socket;
		_in = _socket.getInputStream();
		_out = _socket.getOutputStream();
		_threadNo = threadNo;
	}

	@Override
	public void run() {
		try {
			while (true) {
				String msg = "";
				for (int b = _in.read(); b != (int) '\n'; b = _in.read()) {
					msg = msg + (char) b;
				}
				// System.out.println("Nachricht von Client "
				// + _threadNo
				// + ": "
				// + msg);
				_chatServer.distributeMsg(msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void sendMessage(String msg) throws IOException {
		msg = msg + '\n';
		char[] msgChars = msg.toCharArray();
		for (int i = 0; i < msgChars.length; i++) {
			_out.write(msgChars[i]);
		}
		_out.flush();
		System.out.println("Nachricht an Client " + _threadNo + " gesendet.");
	}
}
