package application;

import java.io.IOException;

import abonné.Abonne;
import baseDeDonnées.BaseDeDonnées;
import documents.Livre;
import serveur.IBaseDeDonnées;
import serveur.Serveur;

public class AppliServeur {
	private final static int PORT_RES = 2500;
	private final static int PORT_EMP = 2600;
	private final static int PORT_RET = 2700;

	public static void main(String[] args) {
		IBaseDeDonnées b = new BaseDeDonnées();
		b.getListAbo().add(new Abonne(0));;
		b.getListAbo().add(new Abonne(1));
		b.getListDoc().add(new Livre(0));
		b.getListDoc().add(new Livre(1));
		b.getListDoc().add(new Livre(2));
		b.getListDoc().add(new Livre(3));
		b.getListDoc().add(new Livre(4));
		b.getListDoc().add(new Livre(5));
		try {
			
			new Thread(new Serveur (b, PORT_RES)).start();
			System.out.println("Serveur Réservation lancé");
			new Thread(new Serveur (b, PORT_RET)).start();
			System.out.println("Serveur Retour lancé");
			new Thread(new Serveur (b, PORT_EMP)).start();
			System.out.println("Serveur Emprunt lancé");
		} catch (IOException e){
			System.out.println("Pb lors de la création du serveur : " + e);
		}
	}
}