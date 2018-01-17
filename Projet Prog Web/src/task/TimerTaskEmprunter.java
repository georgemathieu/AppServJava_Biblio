package task;

import java.util.TimerTask;

import abonn�.Abonne;
import documents.Livre;
import exceptions.Abonn�BanniException;
import exceptions.PasDEmprunteurException;

public class TimerTaskEmprunter extends TimerTask {

	private Abonne ab;
	private Livre l;

	public TimerTaskEmprunter(Abonne ab, Livre l) {
		super();
		this.ab = ab;
		this.l = l;
	}

	@Override
	public void run() {
		try {
			if (l.nameEtat().equals("Emprunt�") && l.getEmprunteur().equals(ab)) {
				ab.bannir();
			}
		} catch (PasDEmprunteurException e) {
		} catch (Abonn�BanniException e) {
		}
		try {
			this.finalize();
		} catch (Throwable e) {

		}
	}
}
