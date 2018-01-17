package baseDeDonn�es;

import java.util.ArrayList;

import abonn�.Abonne;
import exceptions.Abonn�BanniException;
import exceptions.MauvaisIDException;
import serveur.IBaseDeDonn�es;

public class BaseDeDonn�es implements IBaseDeDonn�es {
	private ArrayList<Abonne> abonnes;
	private ArrayList<Document> documents;

	public BaseDeDonn�es() {
		abonnes = new ArrayList<Abonne>();
		documents = new ArrayList<Document>();
	}

	public void rendre(int numDoc,boolean endommag�) throws MauvaisIDException, Abonn�BanniException {
		
		Document d = getDoc(numDoc);
		
		d.retour(endommag�);
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
