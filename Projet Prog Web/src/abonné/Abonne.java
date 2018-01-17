package abonn�;

import etatabo.Abonn�NonBanni;
import exceptions.Abonn�BanniException;
import exceptions.Abonn�NonBanniException;

public class Abonne {
	private int numAbo;
	private EtatAbonne etat;

	public Abonne(int i) {
		numAbo = i;
		etat = new Abonn�NonBanni();
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

	public void bannir() throws Abonn�BanniException {
		synchronized (this) {
			etat = etat.bannir(this);
		}
	}

	public void debannir() throws Abonn�NonBanniException {
		synchronized (this) {
			etat = etat.d�bannir();
		}
	}

	public EtatAbonne etatAbo() {
		return this.etat;
	}
}
