package serveur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import exceptions.Abonn�BanniException;
import exceptions.MauvaisIDException;

public class ServiceRetour implements Runnable {
	private IBaseDeDonn�es bdd;
	private final Socket socket;

	public ServiceRetour(IBaseDeDonn�es bdd, Socket socket) {
		this.socket = socket;
		this.bdd = bdd;
	}

	@Override
	public void run() {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

			try {
				out.println("Num�ro du Document");
				int numDoc = Integer.parseInt(in.readLine());
				out.println("Le livre est-il endommag� ? mettre oui ou non");
				String ligne = in.readLine();
				boolean endommag� = false;
				switch (ligne) {
				case "oui":
					endommag� = true;
					break;
				case "non":
					endommag� = false;
					break;
				default:
					break;
				}
				bdd.rendre(numDoc, endommag�);
				out.println("Livre rendu");

			} catch (MauvaisIDException e2) {
				out.println(e2.getMessage());
			} catch (Abonn�BanniException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			socket.close();
		} catch (IOException e3) {
			e3.printStackTrace();
		}
	}
}
