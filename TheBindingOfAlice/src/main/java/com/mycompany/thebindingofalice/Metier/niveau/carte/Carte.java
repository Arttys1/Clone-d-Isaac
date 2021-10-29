package com.mycompany.thebindingofalice.Metier.niveau.carte;

import com.mycompany.thebindingofalice.Metier.niveau.carte.salle.DirectionSalle;
import com.mycompany.thebindingofalice.Metier.niveau.carte.salle.Salle;
import com.mycompany.thebindingofalice.Metier.niveau.Niveau;
import java.util.ArrayList;

/**
 * Classe représentant la carte d'un niveau
 */
public class Carte {
	public Niveau unnamed_Niveau_;
	public ArrayList<Salle> salles = new ArrayList<Salle>();
	public Salle salleCourante;

	public Salle[] GetSalle() {
		throw new UnsupportedOperationException();
	}

	public void ChangerSalle(DirectionSalle directionSalle) {
		throw new UnsupportedOperationException();
	}
}