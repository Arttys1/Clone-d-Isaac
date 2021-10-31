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

    protected Projectile(Coordonnee coordonnee, DirectionTir dir) {
            super(coordonnee);
            this.dir = dir;
    }

    public abstract TypeProjectile getType();
}