package thebindingofalice.Metier.ennemis.volant;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import thebindingofalice.Metier.Coordonnee;
import thebindingofalice.Metier.ennemis.Ennemi;

/**
 * Classe abstraite, héritant de Ennemi, représentant les ennemis volant
 */
public abstract class EnnemiVolant extends Ennemi {

    public EnnemiVolant(Coordonnee c, Image img) {
        super(c,img);
    }
}