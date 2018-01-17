package serveur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import exceptions.AbonnéBanniException;
import exceptions.MauvaisIDException;
import exceptions.PasLibreException;

public class ServiceEmprunt implements Runnable {

	private Socket socket;
	private IBaseDeDonnées bdd;

	public ServiceEmprunt(IBaseDeDonnées bdd, Socket socket) {
		this.socket = socket;
		this.bdd = bdd;
	}

	public void lancer() {
		new Thread(this).start();
	}

	@Override
	public void run() {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

			try {
				out.println("Numéro de l'Abonné : ");
				int numAbo = Integer.parseInt(in.readLine());
				out.println("Numéro du Document : ");
				int numDoc = Integer.parseInt(in.readLine());

				bdd.getDoc(numDoc).emprunter(bdd.getAbo(numAbo));
				out.println("Livre emprunté");

			} catch (PasLibreException e2) {
				out.println(e2.getMessage());
			} catch (MauvaisIDException e3) {
				out.println(e3.getMessage());
			}catch (AbonnéBanniException e4) {
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
