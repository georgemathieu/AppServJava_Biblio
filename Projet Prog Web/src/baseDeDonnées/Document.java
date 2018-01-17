package baseDeDonnées;
import abonné.Abonne;
import exceptions.AbonnéBanniException;
import exceptions.PasLibreException;

public interface Document {
	int numero();

	public void reserver(Abonne ab) throws PasLibreException, AbonnéBanniException;

	public void emprunter(Abonne ab) throws PasLibreException, AbonnéBanniException;

	public void retour(boolean endommagé) throws AbonnéBanniException;

}