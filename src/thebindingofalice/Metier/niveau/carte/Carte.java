package thebindingofalice.Metier.niveau.carte;

import thebindingofalice.Metier.niveau.carte.salle.DirectionSalle;
import thebindingofalice.Metier.niveau.carte.salle.Salle;
import thebindingofalice.Metier.niveau.Niveau;
import java.util.ArrayList;

/**
 * Classe représentant la carte d'un niveau
 */
public class Carte {
	private Niveau unnamed_Niveau_;
	private ArrayList<Salle> salles = new ArrayList<Salle>();
	private Salle salleCourante;

	public Salle[] GetSalle() {
		throw new UnsupportedOperationException();
	}

	public void ChangerSalle(DirectionSalle directionSalle) {
		throw new UnsupportedOperationException();
	}
}