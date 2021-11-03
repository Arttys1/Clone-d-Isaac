package thebindingofalice.Metier.objet.poussable;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import thebindingofalice.Metier.Coordonnee;
import thebindingofalice.Metier.objet.Objet;

/**
 * Classe abstraite, héritant de Objet, réprésentant les objets poussables
 */
public abstract class ObjetPoussable extends Objet {

    protected ObjetPoussable(Coordonnee c, Image img) {
        super(c,img);
    }
    
}