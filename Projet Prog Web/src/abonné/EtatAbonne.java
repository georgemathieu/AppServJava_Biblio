package abonn�;

import exceptions.Abonn�BanniException;
import exceptions.Abonn�NonBanniException;

public interface EtatAbonne {
	public EtatAbonne bannir(Abonne ab) throws Abonn�BanniException;

	public EtatAbonne d�bannir() throws Abonn�NonBanniException;

	String getEtat();
}
