package baseDeDonnées;

import java.util.ArrayList;

import abonné.Abonne;
import exceptions.AbonnéBanniException;
import exceptions.MauvaisIDException;
import serveur.IBaseDeDonnées;

public class BaseDeDonnées implements IBaseDeDonnées {
	private ArrayList<Abonne> abonnes;
	private ArrayList<Document> documents;

	public BaseDeDonnées() {
		abonnes = new ArrayList<Abonne>();
		documents = new ArrayList<Document>();
	}

	public void rendre(int numDoc,boolean endommagé) throws MauvaisIDException, AbonnéBanniException {
		
		Document d = getDoc(numDoc);
		
		d.retour(endommagé);
	}

	public Document getDoc(int numDoc) throws MauvaisIDException {
		for (Document d : documents) {
			if (d.numero() == numDoc) {
				return d;
			}
		}
		throw new MauvaisIDException();
	}

	public Abonne getAbo(int numAbo) throws MauvaisIDException {
		for (Abonne a : abonnes) {
			if (a.getNum() == numAbo) {
				return a;
			}
		}
		throw new MauvaisIDException();
		
	}

	@Override
	public ArrayList<Abonne> getListAbo() {
		return abonnes;
	}
	
	@Override
	public ArrayList<Document> getListDoc() {
		return documents;
	}
	
	public boolean existeAbo (int i){
		try {
			getAbo(i);
			return true;
		} catch (Exception e) {
			return false; 
		}
	}
	
	public boolean existeDoc (int i){
		try {
			getDoc(i);
			return true;
		} catch (Exception e) {
			return false; 
		}
	}

}
