package documents;

import exceptions.AbonnéBanniException;
import exceptions.PasDEmprunteurException;
import exceptions.PasLibreException;
import abonné.Abonne;
import baseDeDonnées.Document;
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
	public void reserver(Abonne ab) throws PasLibreException, AbonnéBanniException {
		if (ab.getEtat().equals("AbonnéNonBanni")) {
			etat.réserver(this, ab);
		} else {
			throw new AbonnéBanniException();
		}

	}

	@Override
	public void emprunter(Abonne ab) throws PasLibreException, AbonnéBanniException {
		if (ab.getEtat().equals("AbonnéNonBanni")) {
			etat.emprunter(this, ab);
		} else {
			throw new AbonnéBanniException();
		}

	}

	@Override
	public void retour(boolean endommagé) throws AbonnéBanniException {
		
		if (endommagé) {
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
