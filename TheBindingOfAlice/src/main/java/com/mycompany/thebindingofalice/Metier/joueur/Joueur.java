package com.mycompany.thebindingofalice.Metier.joueur;

import com.mycompany.thebindingofalice.Metier.Evoluable;
import com.mycompany.thebindingofalice.Metier.ICollision;
import com.mycompany.thebindingofalice.Metier.Partie;
import com.mycompany.thebindingofalice.Metier.Statistiques;
import com.mycompany.thebindingofalice.Metier.joueur.DirectionDeplacement;
import com.mycompany.thebindingofalice.Metier.niveau.carte.salle.DirectionSalle;
import com.mycompany.thebindingofalice.Metier.projectiles.DirectionTir;
import com.mycompany.thebindingofalice.Metier.objet.ramassable.TypeCoeur;
import com.mycompany.thebindingofalice.Metier.niveau.carte.salle.Salle;
import com.mycompany.thebindingofalice.Metier.objet.ramassable.Cle;

/**
 * Classe, héritant de Evoluable et de ICollision, représentant le joueur.
 */
public class Joueur extends Evoluable implements ICollision {
	private int vieMax;
	private int[] vie;
	private int vitesseX;
	private int vitesseY;
	private Cle[] cles;
	public Partie unnamed_Partie_;
	public Salle salleCourante;
	public Statistiques stats;

	public void Tirer(DirectionTir tir) {
		throw new UnsupportedOperationException();
	}

	public void Bouger(DirectionDeplacement dir) {
		throw new UnsupportedOperationException();
	}

	public void PrendDegat(int nbDegat) {
		throw new UnsupportedOperationException();
	}

	public void AddCoeur(TypeCoeur type, int nb) {
		throw new UnsupportedOperationException();
	}

	public void AddCle(Cle cle) {
		throw new UnsupportedOperationException();
	}

	public void ChangerSalle(DirectionSalle d) {
		throw new UnsupportedOperationException();
	}

	public void ChangerNiveau() {
		throw new UnsupportedOperationException();
	}

	/**
	 * /**
	 *  * Méthode appelé à chaque frame du jeu. Le paramètre pas représente le pas de temps entre deux appel de la méthode.
	 *  * /
	 */
	public void evoluer(long pas) {
		throw new UnsupportedOperationException();
	}

	public void Collision(ICollision o) {
		throw new UnsupportedOperationException();
	}

	public boolean EstLeJoueur() {
		throw new UnsupportedOperationException();
	}

	public boolean EstBloquant() {
		throw new UnsupportedOperationException();
	}
}