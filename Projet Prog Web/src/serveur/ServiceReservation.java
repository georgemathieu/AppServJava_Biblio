package serveur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import baseDeDonnées.Document;
import exceptions.AbonnéBanniException;
import exceptions.MauvaisIDException;
import exceptions.PasLibreException;

public class ServiceReservation implements Runnable {

	private Socket socket;
	private IBaseDeDonnées bdd;

	public ServiceReservation(IBaseDeDonnées bdd, Socket socket) {
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
				out.println("Numéro du Document : ");
				numDoc = Integer.parseInt(in.readLine());
				Document d = bdd.getDoc(numDoc);

				out.println("Numéro de l'Abonné : ");
				numAbo = Integer.parseInt(in.readLine());

				d.reserver(bdd.getAbo(numAbo));
				out.println("Vous avez 2h pour récupérer votre document");

			} catch (PasLibreException e2) {
				out.println(e2.getMessage());
			} catch (MauvaisIDException e3) {
				out.println(e3.getMessage());
			} catch (AbonnéBanniException e4) {
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
