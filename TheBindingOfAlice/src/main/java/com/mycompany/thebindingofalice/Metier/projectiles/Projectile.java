package com.mycompany.thebindingofalice.Metier.projectiles;

import com.mycompany.thebindingofalice.Metier.Coordonnee;
import com.mycompany.thebindingofalice.Metier.Evoluable;
import com.mycompany.thebindingofalice.Metier.ICollision;

/**
 * Classe abstraite représentant les projectiles
 */
public abstract class Projectile extends Evoluable implements ICollision {
	private int vitesse;
	private DirectionTir dir;
	private TypeProjectile type;

	public Projectile(Coordonnee coordonnee, DirectionTir dir) {
		throw new UnsupportedOperationException();
	}

	public void setType(TypeProjectile type) {
		this.type = type;
	}

	public TypeProjectile getType() {
		return this.type;
	}
}