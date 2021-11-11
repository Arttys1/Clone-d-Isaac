package thebindingofalice.Metier.projectiles;

import thebindingofalice.Metier.Coordonnee;
import thebindingofalice.Metier.Hitbox;
import thebindingofalice.Metier.ICollision;

/**
 * Classe, héritant de Projectile, représentant les projectiles alliés
 */
public class ProjectileAllie extends Projectile {

    public ProjectileAllie(Coordonnee coordonnee, DirectionTir dir) {
        super(coordonnee, dir);
    }

    /**
     * /**
     *  * Méthode appelé à chaque frame du jeu. Le paramètre pas représente le pas de temps entre deux appel de la méthode.
     *  * /
     */
    @Override
    public void evoluer(double pas) {
            throw new UnsupportedOperationException();
    }

    @Override
    public void Collision(ICollision o) {
            throw new UnsupportedOperationException();
    }

    @Override
    public boolean EstLeJoueur() {
            throw new UnsupportedOperationException();
    }

    @Override
    public boolean EstBloquant() {
            throw new UnsupportedOperationException();
    }

    @Override
    public TypeProjectile getType() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Hitbox getHitbox() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}