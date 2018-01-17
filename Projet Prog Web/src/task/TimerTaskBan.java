package task;

import java.util.TimerTask;

import abonn�.Abonne;
import exceptions.Abonn�NonBanniException;


public class TimerTaskBan extends TimerTask {
	private Abonne ab;

	public TimerTaskBan(Abonne ab) {
		super();
		this.ab = ab;
	}

	@Override
	public void run() {
		try {
			if (ab.getEtat().equals("Abonn�Banni"))
				ab.debannir();

		} catch (Abonn�NonBanniException e) {
		}

		try {
			this.finalize();
		} catch (Throwable e) {
		}

	}

}
