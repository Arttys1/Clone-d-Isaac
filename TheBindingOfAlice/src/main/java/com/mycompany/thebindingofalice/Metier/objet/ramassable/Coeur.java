package com.mycompany.thebindingofalice.Metier.objet.ramassable;

import com.mycompany.thebindingofalice.Metier.Coordonnee;
import com.mycompany.thebindingofalice.Metier.ICollision;
import com.mycompany.thebindingofalice.Metier.objet.TypeObjet;

/**
 * Classe, héritant de ObjetRamassable, représentant les coeurs
 */
public class Coeur extends ObjetRamassable {

    public Coeur(Coordonnee c) {
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
    public TypeObjet getType() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}