package documents;

import exceptions.Abonn�BanniException;
import exceptions.PasDEmprunteurException;
import exceptions.PasLibreException;
import abonn�.Abonne;
import baseDeDonn�es.Document;
import etat.LivreDisponible;

public class Livre implements Document {
	private Etat etat;
	private int num;

	public Livre(int i) {
		num = i;
		etat = new LivreDisponible();
	}

	@Override
	public int numero() {
		return num;
	}

	public Abonne getEmprunteur() throws PasDEmprunteurException {
		return etat.getEmprunteur();
	}

	@Override
	public void reserver(Abonne ab) throws PasLibreException, Abonn�BanniException {
		if (ab.getEtat().equals("Abonn�NonBanni")) {
			etat.r�server(this, ab);
		} else {
			throw new Abonn�BanniException();
		}

	}

	@Override
	public void emprunter(Abonne ab) throws PasLibreException, Abonn�BanniException {
		if (ab.getEtat().equals("Abonn�NonBanni")) {
			etat.emprunter(this, ab);
		} else {
			throw new Abonn�BanniException();
		}

	}

	@Override
	public void retour(boolean endommag�) throws Abonn�BanniException {
		
		if (endommag�) {
			try {
				this.getEmprunteur().bannir();

			} catch (PasDEmprunteurException e) {
				e.printStackTrace();
			}
		}
		etat.retour(this);
	}

	public void setEtat(Etat etat) {
		this.etat = etat;
	}

	public Etat getEtat() {
		return etat;
	}

	public String nameEtat() {
		return etat.getEtat();
	}
}
