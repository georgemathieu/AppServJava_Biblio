package abonné;

import exceptions.AbonnéBanniException;
import exceptions.AbonnéNonBanniException;

public interface EtatAbonne {
	public EtatAbonne bannir(Abonne ab) throws AbonnéBanniException;

	public EtatAbonne débannir() throws AbonnéNonBanniException;

	String getEtat();
}
