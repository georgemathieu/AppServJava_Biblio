package baseDeDonn�es;
import abonn�.Abonne;
import exceptions.Abonn�BanniException;
import exceptions.PasLibreException;

public interface Document {
	int numero();

	public void reserver(Abonne ab) throws PasLibreException, Abonn�BanniException;

	public void emprunter(Abonne ab) throws PasLibreException, Abonn�BanniException;

	public void retour(boolean endommag�) throws Abonn�BanniException;

}