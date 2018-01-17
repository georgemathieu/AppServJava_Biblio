package etat;

import abonn�.Abonne;
import documents.Etat;
import documents.Livre;
import exceptions.PasDEmprunteurException;
import exceptions.PasLibreException;
import schedule.Horloge;
import task.TimertaskR�server;

public class LivreR�serv� implements Etat {
	private final int DELAY = 7200000;
	private Abonne emprunteur;

	public LivreR�serv�(Abonne ab, Livre l) {
		this.emprunteur = ab;
		tempsReservation(l);
	}

	private void tempsReservation(Livre l) {
		new Thread(new Horloge(new TimertaskR�server(l, emprunteur), DELAY)).start();
	}

	@Override
	public void retour(Livre l) {
		l.setEtat(new LivreDisponible());
	}

	@Override
	public Abonne getEmprunteur() throws PasDEmprunteurException {
		return emprunteur;
	}

	@Override
	public void emprunter(Livre l, Abonne ab) throws PasLibreException {
		synchronized (l) {
			if (ab.equals(this.emprunteur)) {
				l.setEtat(new LivreEmprunt�(ab,l));
			} else
				throw new PasLibreException();
		}
	}

	@Override
	public void r�server(Livre l, Abonne ab) throws PasLibreException {
		throw new PasLibreException();
	}

	@Override
	public String getEtat() {
		return "R�serv�";
	}
}
