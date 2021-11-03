package thebindingofalice.Metier.objet;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import thebindingofalice.Metier.Coordonnee;
import thebindingofalice.Metier.Evoluable;
import thebindingofalice.Metier.ICollision;

/**
 * Classe abstraite, héritant de Evoluable, représentant les objets au sols
 */
public abstract class Objet extends Evoluable implements ICollision {

    protected Objet(Coordonnee c, Image img) {
        super(c,img);
    }
    
    public abstract TypeObjet getType(); 
}