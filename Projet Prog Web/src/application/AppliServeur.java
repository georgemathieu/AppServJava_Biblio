package application;

import java.io.IOException;

import abonn�.Abonne;
import baseDeDonn�es.BaseDeDonn�es;
import documents.Livre;
import serveur.IBaseDeDonn�es;
import serveur.Serveur;

public class AppliServeur {
	private final static int PORT_RES = 2500;
	private final static int PORT_EMP = 2600;
	private final static int PORT_RET = 2700;

	public static void main(String[] args) {
		IBaseDeDonn�es b = new BaseDeDonn�es();
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
			System.out.println("Serveur R�servation lanc�");
			new Thread(new Serveur (b, PORT_RET)).start();
			System.out.println("Serveur Retour lanc�");
			new Thread(new Serveur (b, PORT_EMP)).start();
			System.out.println("Serveur Emprunt lanc�");
		} catch (IOException e){
			System.out.println("Pb lors de la cr�ation du serveur : " + e);
		}
	}
}