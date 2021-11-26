package thebindingofalice.Metier.objet.ramassable;

import thebindingofalice.Metier.Coordonnee;
import thebindingofalice.Metier.Hitbox;
import thebindingofalice.Metier.ICollision;
import thebindingofalice.Metier.objet.TypeObjet;

/**
 * Classe, héritant de ObjetRamassable, représentant les coeurs
 */
public class Coeur extends ObjetRamassable {
    
    private final Hitbox hitbox;

    public Coeur(Coordonnee c) {
        super(c);
        this.hitbox = new Hitbox(c.getX(),c.getY(),10,10);
    }

    /**
     * /**
     *  * Méthode appelé à chaque frame du jeu. Le paramètre pas représente le pas de temps entre deux appel de la méthode.
     *  * /
     */
    @Override
    public void evoluer(double pas) {
            
    }

    @Override
    public void Collision(ICollision o) {
        if(o.EstLeJoueur())
        {
            Notify("heal");
        }
    }

    @Override
    public boolean EstLeJoueur() {
            return false;
    }

    @Override
    public boolean EstBloquant() {
            return false;
    }

    @Override
    public TypeObjet getType() {
        return TypeObjet.COEUR;
    }
    
    public TypeCoeur getTypeCoeur(){
        return TypeCoeur.ROUGE;
    }

    @Override
    public Hitbox getHitbox() {
        return this.hitbox;
    }
}