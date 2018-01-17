package abonné;

import etatabo.AbonnéNonBanni;
import exceptions.AbonnéBanniException;
import exceptions.AbonnéNonBanniException;

public class Abonne {
	private int numAbo;
	private EtatAbonne etat;

	public Abonne(int i) {
		numAbo = i;
		etat = new AbonnéNonBanni();
	}

	public int getNum() {
		return numAbo;
	}

	public boolean equals(Abonne ab) {
		return getNum() == ab.getNum();
	}

	public String getEtat() {
		return etat.getEtat();
	}

	public void bannir() throws AbonnéBanniException {
		synchronized (this) {
			etat = etat.bannir(this);
		}
	}

	public void debannir() throws AbonnéNonBanniException {
		synchronized (this) {
			etat = etat.débannir();
		}
	}

	public EtatAbonne etatAbo() {
		return this.etat;
	}
}
