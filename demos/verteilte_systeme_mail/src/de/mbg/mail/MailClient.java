package de.mbg.mail;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class MailClient {

	public void start() throws UnknownHostException, IOException {
		// Verbinden zum Server...
		Socket socket = new Socket("localhost", 4449);
		MailClientCommunication comm = new MailClientCommunication(socket);

		String sender = "mberg@temenos.com";
		String receiver = "mberg@temenos.com";
		String subject = "Vorlesung Verteilte Systeme";
		String message = "What a wonderful day...";
		comm.sendMail(sender, receiver, subject, message);
	}

	class MailClientCommunication extends AbstractSocketCommunication {
		public MailClientCommunication(Socket socket) throws IOException {
			super(socket, "Mail Client");
		}

		public void sendMail(String sender, String receiver, String subject,
				String message) {
			try {

				// Starte Kommunikation...
				sendMessage("Hallo");

				String msg = readMessage();
				if (isErrorMessage(msg)) {
					System.out.println("Fehler: " + msg);
					return;
				} else if (!msg.equals("Hallo")) {
					throw new Exception();
				}
				// Absender senden
				sendMessage("SENDER:" + sender);
				msg = readMessage();
				if (isErrorMessage(msg)) {
					System.out.println("Fehler: " + msg);
					return;
				}

				// Empf√§nger senden
				sendMessage("RECEIVER:" + receiver);
				msg = readMessage();
				if (isErrorMessage(msg)) {
					System.out.println("Fehler: " + msg);
					return;
				}

				// Betreff senden
				sendMessage("SUBJECT:" + subject);
				msg = readMessage();
				if (isErrorMessage(msg)) {
					System.out.println("Fehler: " + msg);
					return;
				}

				// Message senden
				sendMessage("MESSAGE:" + message);
				msg = readMessage();
				if (isErrorMessage(msg)) {
					System.out.println("Fehler: " + msg);
					return;
				}

				// Empfangsbest‰tigung
				msg = readMessage();
				if (isErrorMessage(msg)) {
					System.out.println("Fehler: " + msg);
					return;
				} else if (!msg.startsWith("Sending Mail Successfull!")) {
					throw new Exception();
				}

				// Beenden
				msg = readMessage();
				if (isErrorMessage(msg)) {
					System.out.println("Fehler: " + msg);
					return;
				} else if (!msg.startsWith("BYE")) {
					throw new Exception();
				}

				// Beenden senden
				sendMessage("BYE");

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
	}

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		MailClient client = new MailClient();
		client.start();
	}
}
