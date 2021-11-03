package thebindingofalice.Metier.objet.ramassable.bonus;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import thebindingofalice.Metier.Coordonnee;
import thebindingofalice.Metier.objet.ramassable.ObjetRamassable;

/**
 * Classe abstraite, héritant de ObjetRamassable, représentant les bonus du jeu
 */
public abstract class Bonus extends ObjetRamassable {

    protected Bonus(Coordonnee c, Image img) {
        super(c,img);
    }
    
    public abstract void effet();
}