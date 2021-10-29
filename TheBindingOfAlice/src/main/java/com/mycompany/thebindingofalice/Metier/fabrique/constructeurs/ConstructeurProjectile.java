package com.mycompany.thebindingofalice.Metier.fabrique.constructeurs;

import com.mycompany.thebindingofalice.Metier.projectiles.Projectile;

/**
 * Interface représentant les différents  Constructeur pour les types de projectiles.
 */
public interface ConstructeurProjectile {

	public Projectile Create();
}