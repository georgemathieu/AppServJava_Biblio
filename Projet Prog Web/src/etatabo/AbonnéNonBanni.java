package etatabo;

import abonné.Abonne;
import abonné.EtatAbonne;
import exceptions.AbonnéNonBanniException;

public class AbonnéNonBanni implements EtatAbonne {

	@Override
	public EtatAbonne bannir(Abonne ab) {
		return new AbonnéBanni(ab);
	}

	@Override
	public EtatAbonne débannir() throws AbonnéNonBanniException {
		throw new AbonnéNonBanniException();
	}

	@Override
	public String getEtat() {

		return "AbonnéNonBanni";
	}

}
