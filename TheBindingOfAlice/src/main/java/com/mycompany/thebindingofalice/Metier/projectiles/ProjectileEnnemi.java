package com.mycompany.thebindingofalice.Metier.projectiles;

import com.mycompany.thebindingofalice.Metier.Coordonnee;
import com.mycompany.thebindingofalice.Metier.ICollision;
import com.mycompany.thebindingofalice.Metier.projectiles.DirectionTir;

/**
 * Classe abstraite, héritant de Projectile, représentant les projectiles ennemies.
 */
public class ProjectileEnnemi extends Projectile {

    public ProjectileEnnemi(Coordonnee coordonnee, DirectionTir dir) {
        super(coordonnee, dir);
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