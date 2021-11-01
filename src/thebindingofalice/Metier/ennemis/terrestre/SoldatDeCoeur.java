package thebindingofalice.Metier.ennemis.terrestre;

import thebindingofalice.Metier.Coordonnee;
import thebindingofalice.Metier.ICollision;
import thebindingofalice.Metier.ennemis.TypeEnnemi;

/**
 * Classe, héritant de EnnemiTerrestre, représentant les Soldats de coeurs. L'ennemi de base du jeu
 */
public class SoldatDeCoeur extends EnnemiTerrestre {

    public SoldatDeCoeur(Coordonnee c) {
        super(c);
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
    public TypeEnnemi getType() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}