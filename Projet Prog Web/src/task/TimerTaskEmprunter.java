package task;

import java.util.TimerTask;

import abonné.Abonne;
import documents.Livre;
import exceptions.AbonnéBanniException;
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
			if (l.nameEtat().equals("Emprunté") && l.getEmprunteur().equals(ab)) {
				ab.bannir();
			}
		} catch (PasDEmprunteurException e) {
		} catch (AbonnéBanniException e) {
		}
		try {
			this.finalize();
		} catch (Throwable e) {

		}
	}
}
