package thebindingofalice.Metier.projectiles;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import thebindingofalice.Metier.Coordonnee;
import thebindingofalice.Metier.Evoluable;
import thebindingofalice.Metier.ICollision;

/**
 * Classe abstraite représentant les projectiles
 */
public abstract class Projectile extends Evoluable implements ICollision {
    private int vitesse;
    private DirectionTir dir;

    protected Projectile(Coordonnee coordonnee, DirectionTir dir,  Image img) {
            super(coordonnee,img);
            this.dir = dir;
    }

    public abstract TypeProjectile getType();
}