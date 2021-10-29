package com.mycompany.thebindingofalice.Metier;
import com.mycompany.thebindingofalice.Metier.joueur.Joueur;
import com.mycompany.thebindingofalice.Metier.niveau.carte.salle.DirectionSalle;
import com.mycompany.thebindingofalice.Metier.niveau.Niveau;
import java.util.ArrayList;

/**
 * Classe représentant une partie du jeu. Elle est le point d'entrée de la couche métier
 */
public class Partie {
	private static Partie instance;
	public ArrayList<Niveau> niveaux = new ArrayList<Niveau>();
	public ArrayList<ICollision> objetsCollision = new ArrayList<ICollision>();
	public Joueur joueur;

	private Partie() {
		throw new UnsupportedOperationException();
	}

	public static Partie get() {
		throw new UnsupportedOperationException();
	}

	public void Evoluer() {
		throw new UnsupportedOperationException();
	}

	public Joueur GetJoueur() {
		throw new UnsupportedOperationException();
	}

	public void ChangerSalle(DirectionSalle d) {
		throw new UnsupportedOperationException();
	}

	public void ChangerNiveau() {
		throw new UnsupportedOperationException();
	}
}