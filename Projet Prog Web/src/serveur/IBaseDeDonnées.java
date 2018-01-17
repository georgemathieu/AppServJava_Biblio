package serveur;

import java.util.ArrayList;

import abonné.Abonne;
import baseDeDonnées.Document;
import exceptions.AbonnéBanniException;
import exceptions.MauvaisIDException;

public interface IBaseDeDonnées {
	Abonne getAbo(int numAbo) throws MauvaisIDException;
	Document getDoc(int numDoc) throws MauvaisIDException;
	void rendre(int numDoc, boolean endommagé) throws MauvaisIDException, AbonnéBanniException;
	ArrayList<Abonne> getListAbo();
	ArrayList<Document> getListDoc();
	boolean existeAbo(int i);
	boolean existeDoc(int i);
}
