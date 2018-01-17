package documents;

import abonn�.Abonne;
import exceptions.PasDEmprunteurException;
import exceptions.PasLibreException;

public interface Etat {

	void retour(Livre l);

	Abonne getEmprunteur() throws PasDEmprunteurException;

	void emprunter(Livre l, Abonne ab) throws PasLibreException;
	
	void r�server (Livre l, Abonne ab) throws PasLibreException;
	
	String getEtat();
}
