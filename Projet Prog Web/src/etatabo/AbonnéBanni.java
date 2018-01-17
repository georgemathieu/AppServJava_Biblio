package etatabo;

import abonné.Abonne;
import abonné.EtatAbonne;
import exceptions.AbonnéBanniException;
import schedule.Horloge;
import task.TimerTaskBan;

public class AbonnéBanni implements EtatAbonne {

	private static final long DELAY = 2629800000L;//temps avant le deban

	public AbonnéBanni(Abonne ab) {
		timerBan(ab);
	}

	public void timerBan(Abonne ab) {
		new Thread(new Horloge(new TimerTaskBan(ab), DELAY)).start();
	}

	@Override
	public EtatAbonne bannir(Abonne ab) throws AbonnéBanniException {
		throw new AbonnéBanniException();
	}

	@Override
	public EtatAbonne débannir() {

		return new AbonnéNonBanni();

	}

	@Override
	public String getEtat() {
		// TODO Auto-generated method stub
		return "AbonnéBanni";
	}

}
