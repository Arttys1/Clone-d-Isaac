package thebindingofalice.Metier.objet.obstacle;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import thebindingofalice.Metier.Coordonnee;
import thebindingofalice.Metier.objet.Objet;

/**
 * Classe abstraite, héritant de Objet, représentant les objets qui font obstacle au joueur
 */
public abstract class Obstacle extends Objet {

    protected Obstacle(Coordonnee c, Image img) {
        super(c,img);
    }
	
}