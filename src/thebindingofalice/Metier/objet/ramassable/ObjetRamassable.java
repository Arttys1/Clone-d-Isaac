package thebindingofalice.Metier.objet.ramassable;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import thebindingofalice.Metier.Coordonnee;
import thebindingofalice.Metier.objet.Objet;

/**
 * Classe abstraite, héritant de Objet, représentant les objets que l'on peut ramasser.
 */
public abstract class ObjetRamassable extends Objet {

    protected ObjetRamassable(Coordonnee c, Image img) {
        super(c,img);
    }
}