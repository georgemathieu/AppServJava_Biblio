package exceptions;

public class PasDEmprunteurException extends Exception {
	public PasDEmprunteurException() {
		super("Document non emprunté");
	}
}
