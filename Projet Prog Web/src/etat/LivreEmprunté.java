package etat;

import abonn�.Abonne;
import documents.Etat;
import documents.Livre;
import exceptions.PasDEmprunteurException;
import exceptions.PasLibreException;
import schedule.Horloge;
import task.TimerTaskEmprunter;

public class LivreEmprunt� implements Etat {
	private Abonne emprunteur;
	private final long DELAY =1209600033L ;//dur�e d'emprunt



	public LivreEmprunt�(Abonne ab, Livre l) {
		this.emprunteur = ab;
		tempsRetour(l);
	}

	public void tempsRetour(Livre l) {
		new Thread(new Horloge(new TimerTaskEmprunter(emprunteur,l), DELAY)).start();
	}

	@Override
	public void retour(Livre l) {
		synchronized (l) {
			l.setEtat(new LivreDisponible());
		}
	}

	@Override
	public Abonne getEmprunteur() throws PasDEmprunteurException {
		return emprunteur;
	}

	@Override
	public void emprunter(Livre l, Abonne ab) throws PasLibreException {
		throw new PasLibreException();
	}

	@Override
	public void r�server(Livre l, Abonne ab) throws PasLibreException {
		throw new PasLibreException();
	}

	@Override
	public String getEtat() {
		return "Emprunt�";
	}
}
