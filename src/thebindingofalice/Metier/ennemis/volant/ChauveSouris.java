package thebindingofalice.Metier.ennemis.volant;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import thebindingofalice.Metier.Coordonnee;
import thebindingofalice.Metier.ICollision;
import thebindingofalice.Metier.ennemis.TypeEnnemi;

/**
 * Classe ,héritant de Ennemi Volant, représentant les chauves souris
 */
public class ChauveSouris extends EnnemiVolant {

    public ChauveSouris(Coordonnee c, Image img) {
        super(c,img);
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