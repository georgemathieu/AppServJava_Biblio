package exceptions;

public class AbonnéBanniException extends Exception {
	public AbonnéBanniException() {
		super("Cet utilisateur est interdit d'emprunt pour retard/mauvais entretien des documents.");
	}
	
}
