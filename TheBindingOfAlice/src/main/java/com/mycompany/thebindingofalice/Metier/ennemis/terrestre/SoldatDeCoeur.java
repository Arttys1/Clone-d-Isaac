package com.mycompany.thebindingofalice.Metier.ennemis.terrestre;

import com.mycompany.thebindingofalice.Metier.ICollision;

/**
 * Classe, héritant de EnnemiTerrestre, représentant les Soldats de coeurs. L'ennemi de base du jeu
 */
public class SoldatDeCoeur extends EnnemiTerrestre {

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