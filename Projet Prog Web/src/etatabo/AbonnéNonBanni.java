package etatabo;

import abonn�.Abonne;
import abonn�.EtatAbonne;
import exceptions.Abonn�NonBanniException;

public class Abonn�NonBanni implements EtatAbonne {

	@Override
	public EtatAbonne bannir(Abonne ab) {
		return new Abonn�Banni(ab);
	}

	@Override
	public EtatAbonne d�bannir() throws Abonn�NonBanniException {
		throw new Abonn�NonBanniException();
	}

	@Override
	public String getEtat() {

		return "Abonn�NonBanni";
	}

}
