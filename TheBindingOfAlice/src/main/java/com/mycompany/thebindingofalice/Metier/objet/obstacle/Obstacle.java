package com.mycompany.thebindingofalice.Metier.objet.obstacle;

import com.mycompany.thebindingofalice.Metier.ICollision;
import com.mycompany.thebindingofalice.Metier.objet.Objet;

/**
 * Classe abstraite, héritant de Objet, représentant les objets qui font obstacle au joueur
 */
public class Obstacle extends Objet {

	public void Collision(ICollision o) {
		throw new UnsupportedOperationException();
	}

	public boolean EstLeJoueur() {
		throw new UnsupportedOperationException();
	}

	public boolean EstBloquant() {
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
}