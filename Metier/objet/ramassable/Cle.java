package thebindingofalice.Metier.objet.ramassable;

import thebindingofalice.Metier.Coordonnee;
import thebindingofalice.Metier.Hitbox;
import thebindingofalice.Metier.ICollision;
import thebindingofalice.Metier.objet.TypeObjet;

/**
 * Classe, héritant de ObjetRamassable, représentant les clés
 */
public class Cle extends ObjetRamassable {

    public Cle(Coordonnee c) {
        super(c);
    }

    /**
     * /**
     *  * Méthode appelé à chaque frame du jeu. Le paramètre pas représente le pas de temps entre deux appel de la méthode.
     *  * /
     */
    public void evoluer(double pas) {
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
    public TypeObjet getType() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Hitbox getHitbox() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}