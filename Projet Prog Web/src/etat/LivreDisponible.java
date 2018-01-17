package etat;

import abonn�.Abonne;
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
			l.setEtat(new LivreEmprunt�(ab,l));
		}
	}

	@Override
	public void r�server(Livre l, Abonne ab) throws PasLibreException {
		synchronized (l) {
			l.setEtat(new LivreR�serv�(ab, l));
		}
	}

	@Override
	public String getEtat() {
		return "Disponible";
	}
}
