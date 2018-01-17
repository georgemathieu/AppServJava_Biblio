package task;

import java.util.TimerTask;

import abonné.Abonne;
import exceptions.AbonnéNonBanniException;


public class TimerTaskBan extends TimerTask {
	private Abonne ab;

	public TimerTaskBan(Abonne ab) {
		super();
		this.ab = ab;
	}

	@Override
	public void run() {
		try {
			if (ab.getEtat().equals("AbonnéBanni"))
				ab.debannir();

		} catch (AbonnéNonBanniException e) {
		}

		try {
			this.finalize();
		} catch (Throwable e) {
		}

	}

}
