package serveur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import baseDeDonn�es.Document;
import exceptions.Abonn�BanniException;
import exceptions.MauvaisIDException;
import exceptions.PasLibreException;

public class ServiceReservation implements Runnable {

	private Socket socket;
	private IBaseDeDonn�es bdd;

	public ServiceReservation(IBaseDeDonn�es bdd, Socket socket) {
		this.socket = socket;
		this.bdd = bdd;
	}

	public void lancer() {
		new Thread(this).start();
	}

	@Override
	public void run() {
		int numAbo;
		int numDoc;
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

			try {
				out.println("Num�ro du Document : ");
				numDoc = Integer.parseInt(in.readLine());
				Document d = bdd.getDoc(numDoc);

				out.println("Num�ro de l'Abonn� : ");
				numAbo = Integer.parseInt(in.readLine());

				d.reserver(bdd.getAbo(numAbo));
				out.println("Vous avez 2h pour r�cup�rer votre document");

			} catch (PasLibreException e2) {
				out.println(e2.getMessage());
			} catch (MauvaisIDException e3) {
				out.println(e3.getMessage());
			} catch (Abonn�BanniException e4) {
				out.println(e4.getMessage());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			socket.close();
		} catch (IOException e4) {
			e4.printStackTrace();
		}
	}
}
