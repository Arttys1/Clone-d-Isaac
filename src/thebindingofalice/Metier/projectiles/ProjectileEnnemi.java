package thebindingofalice.Metier.projectiles;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import thebindingofalice.Metier.Coordonnee;
import thebindingofalice.Metier.ICollision;
import thebindingofalice.Metier.projectiles.DirectionTir;

/**
 * Classe abstraite, héritant de Projectile, représentant les projectiles ennemies.
 */
public class ProjectileEnnemi extends Projectile {

    public ProjectileEnnemi(Coordonnee coordonnee, DirectionTir dir, Image img) {
        super(coordonnee, dir,img);
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

    @Override
    public TypeProjectile getType() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}