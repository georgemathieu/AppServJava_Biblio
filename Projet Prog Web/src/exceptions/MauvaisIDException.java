package exceptions;

public class MauvaisIDException extends Exception {
	public MauvaisIDException() {
		super("Document ou Abonné n'existe pas");
	}
}
		
