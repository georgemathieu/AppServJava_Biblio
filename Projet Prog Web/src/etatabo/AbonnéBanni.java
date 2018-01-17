package etatabo;

import abonn�.Abonne;
import abonn�.EtatAbonne;
import exceptions.Abonn�BanniException;
import schedule.Horloge;
import task.TimerTaskBan;

public class Abonn�Banni implements EtatAbonne {

	private static final long DELAY = 2629800000L;//temps avant le deban

	public Abonn�Banni(Abonne ab) {
		timerBan(ab);
	}

	public void timerBan(Abonne ab) {
		new Thread(new Horloge(new TimerTaskBan(ab), DELAY)).start();
	}

	@Override
	public EtatAbonne bannir(Abonne ab) throws Abonn�BanniException {
		throw new Abonn�BanniException();
	}

	@Override
	public EtatAbonne d�bannir() {

		return new Abonn�NonBanni();

	}

	@Override
	public String getEtat() {
		// TODO Auto-generated method stub
		return "Abonn�Banni";
	}

}
