package documents;

import abonné.Abonne;
import exceptions.PasDEmprunteurException;
import exceptions.PasLibreException;

public interface Etat {

	void retour(Livre l);

	Abonne getEmprunteur() throws PasDEmprunteurException;

	void emprunter(Livre l, Abonne ab) throws PasLibreException;
	
	void réserver (Livre l, Abonne ab) throws PasLibreException;
	
	String getEtat();
}
