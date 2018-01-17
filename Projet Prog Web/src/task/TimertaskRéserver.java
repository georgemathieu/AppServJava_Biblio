package task;

import java.util.TimerTask;

import abonn�.Abonne;
import documents.Livre;
import etat.LivreDisponible;
import exceptions.PasDEmprunteurException;

public class TimertaskR�server extends TimerTask{
	private Livre l;
	private Abonne ab;

	public TimertaskR�server(Livre l, Abonne ab) {
		super();
		this.l = l;
		this.ab = ab;
	}

	@Override
	public void run() {
		try {
			if (l.nameEtat().equals("R�serv�") && l.getEmprunteur().equals(ab))
				l.setEtat(new LivreDisponible());
		} catch (PasDEmprunteurException e) {}
		
		try {
			this.finalize();
		} catch (Throwable e) {
		}
	}

}
