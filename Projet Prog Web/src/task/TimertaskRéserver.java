package task;

import java.util.TimerTask;

import abonné.Abonne;
import documents.Livre;
import etat.LivreDisponible;
import exceptions.PasDEmprunteurException;

public class TimertaskRéserver extends TimerTask{
	private Livre l;
	private Abonne ab;

	public TimertaskRéserver(Livre l, Abonne ab) {
		super();
		this.l = l;
		this.ab = ab;
	}

	@Override
	public void run() {
		try {
			if (l.nameEtat().equals("Réservé") && l.getEmprunteur().equals(ab))
				l.setEtat(new LivreDisponible());
		} catch (PasDEmprunteurException e) {}
		
		try {
			this.finalize();
		} catch (Throwable e) {
		}
	}

}
