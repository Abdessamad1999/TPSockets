package server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {

	public static void main(String[] args) throws IOException {
		
		ServerSocket ss = new ServerSocket(1234);
		System.out.println("J'attend la connexion...");
		Socket s = ss.accept();
		InputStream is = s.getInputStream();
		OutputStream os = s.getOutputStream();
		String ip = s.getRemoteSocketAddress().toString();
		System.out.println("Connexion d'un client : "+ip);
		System.out.println("J'attend que le client envoie un octet");
		int nb = is.read();
		System.out.println("J'ai reçu un nombre "+nb);
		int rep = nb*2;
		System.out.println("J'envoie la reponse "+rep);
		os.write(rep);
		os.close(); //pour férmer la connexion
	}

}
