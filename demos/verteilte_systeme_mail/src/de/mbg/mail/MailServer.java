package de.mbg.mail;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MailServer {

	public void start() throws IOException {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(4449);
			System.out.println("MailServer.start: Server gestartet!");
			int counter = 0;
			while (true) {
				counter++;
				Socket socket = serverSocket.accept();
				System.out.println("MailServer.start: Client " + counter
						+ " hat sich angemeldet.");
				MailServerCommunication clientThread = new MailServerCommunication(
						socket, counter);
				Thread thread = new Thread(clientThread);
				thread.start();
			}
		} finally {
			if (serverSocket != null)
				serverSocket.close();
		}
	}

	class MailServerCommunication extends AbstractSocketCommunication implements
			Runnable {
		private int _threadNo;

		public MailServerCommunication(Socket socket, int threadNo)
				throws IOException {
			super(socket, "MailServer [" + threadNo + "]");
			_threadNo = threadNo;
		}

		public void run() {
			receiveMail();
		}

		public void receiveMail() {
			try {
				String sender = null;
				String receiver = null;
				String subject = null;
				String message = null;

				// Starte Kommunikation...
				String msg = readMessage();
				if (isErrorMessage(msg)) {
					System.out.println("Fehler: " + msg);
					return;
				} else if (!msg.equals("Hallo")) {
					throw new Exception();
				}
				sendMessage("Hallo");

				// Absender
				msg = readMessage();
				if (isErrorMessage(msg)) {
					System.out.println("Fehler: " + msg);
					return;
				} else if (!msg.startsWith("SENDER:")) {
					throw new Exception();
				} else {
					sendMessage("OK");
				}
				sender = msg;

				// Empf‰nger
				msg = readMessage();
				if (isErrorMessage(msg)) {
					System.out.println("Fehler: " + msg);
					return;
				} else if (!msg.startsWith("RECEIVER:")) {
					throw new Exception();
				} else {
					sendMessage("OK");
				}
				receiver = msg;

				// Betreff
				msg = readMessage();
				if (isErrorMessage(msg)) {
					System.out.println("Fehler: " + msg);
					return;
				} else if (!msg.startsWith("SUBJECT:")) {
					throw new Exception();
				} else {
					sendMessage("OK");
				}
				subject = msg;

				// Message
				msg = readMessage();
				if (isErrorMessage(msg)) {
					System.out.println("Fehler: " + msg);
					return;
				} else if (!msg.startsWith("MESSAGE:")) {
					throw new Exception();
				} else {
					sendMessage("OK");
				}
				message = msg;

				// Empfang best√§tigen
				sendMessage("Sending Mail Successfull!");

				// Beenden senden
				sendMessage("BYE");

				// Beenden
				msg = readMessage();
				if (isErrorMessage(msg)) {
					System.out.println("Fehler: " + msg);
					return;
				} else if (!msg.startsWith("BYE")) {
					throw new Exception();
				}

				printMail(sender, receiver, subject, message);
			} catch (Exception e) {
				try {
					sendMessage("Protokoll verletzt!");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			}
			close();
		}

		private void printMail(String sender, String receiver, String subject,
				String msg) {
			System.out.println("\nEmpfangene Nachricht: " + _threadNo);
			System.out.println(sender);
			System.out.println(receiver);
			System.out.println(subject);
			System.out.println(msg);
		}
	}

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		MailServer server = new MailServer();
		server.start();
	}

}
