package etat;

import abonné.Abonne;
import documents.Etat;
import documents.Livre;
import exceptions.PasDEmprunteurException;
import exceptions.PasLibreException;

public class LivreDisponible implements Etat {	
	
	@Override
	public Abonne getEmprunteur() throws PasDEmprunteurException {
		throw new PasDEmprunteurException();
	}
	
	@Override
	public void retour(Livre l){
		
	}

	@Override
	public void emprunter(Livre l, Abonne ab) {
		synchronized (l) {
			l.setEtat(new LivreEmprunté(ab,l));
		}
	}

	@Override
	public void réserver(Livre l, Abonne ab) throws PasLibreException {
		synchronized (l) {
			l.setEtat(new LivreRéservé(ab, l));
		}
	}

	@Override
	public String getEtat() {
		return "Disponible";
	}
}
