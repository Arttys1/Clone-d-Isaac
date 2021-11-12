package thebindingofalice.Metier.objet.obstacle;

import thebindingofalice.Metier.Coordonnee;
import thebindingofalice.Metier.Hitbox;
import thebindingofalice.Metier.ICollision;
import thebindingofalice.Metier.Partie;
import thebindingofalice.Metier.objet.TypeObjet;

/**
 * Classe, héritant de Obstacle, représentant les murs
 */
public class Mur extends Obstacle {
    private final Hitbox hitbox;

    public Mur(Coordonnee c) {
        super(c);
        hitbox = new Hitbox(c.getX(), c.getY(), 50, 50);
    }

    @Override
    public TypeObjet getType() {
        return TypeObjet.MUR;
    }

    @Override
    public void evoluer(double pas) {

    }

    @Override
    public void Collision(ICollision o) {
        if(o.EstLeJoueur())
        {
            Partie.get().GetJoueur().sArreter();
            System.out.println("joueur");
        }
    }

    @Override
    public boolean EstLeJoueur() {
        return false;
    }

    @Override
    public boolean EstBloquant() {
        return true;
    }

    @Override
    public Hitbox getHitbox() {
        return hitbox;
    }
}