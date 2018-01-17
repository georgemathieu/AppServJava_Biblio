package serveur;

import java.util.ArrayList;

import abonn�.Abonne;
import baseDeDonn�es.Document;
import exceptions.Abonn�BanniException;
import exceptions.MauvaisIDException;

public interface IBaseDeDonn�es {
	Abonne getAbo(int numAbo) throws MauvaisIDException;
	Document getDoc(int numDoc) throws MauvaisIDException;
	void rendre(int numDoc, boolean endommag�) throws MauvaisIDException, Abonn�BanniException;
	ArrayList<Abonne> getListAbo();
	ArrayList<Document> getListDoc();
	boolean existeAbo(int i);
	boolean existeDoc(int i);
}
