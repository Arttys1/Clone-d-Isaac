package thebindingofalice.Metier.objet.obstacle;

import thebindingofalice.Metier.Coordonnee;
import thebindingofalice.Metier.ICollision;
import thebindingofalice.Metier.objet.TypeObjet;

/**
 * Classe, héritant de Obstacle, représentant les murs
 */
public class Mur extends Obstacle {

    public Mur(Coordonnee c) {
        super(c);
    }

    @Override
    public TypeObjet getType() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void evoluer(long pas) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Collision(ICollision o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean EstLeJoueur() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean EstBloquant() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}