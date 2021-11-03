package thebindingofalice.Metier.ennemis;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import thebindingofalice.Metier.Coordonnee;
import thebindingofalice.Metier.joueur.DirectionDeplacement;
import thebindingofalice.Metier.Evoluable;
import thebindingofalice.Metier.ICollision;
import thebindingofalice.Metier.Statistiques;

/**
 * Classe abstraite, héritant de Evoluable et de ICollision, représentant les ennemis du jeu
 */
public abstract class Ennemi extends Evoluable implements ICollision {
    private int vie;
    private Statistiques statistiques;

    public Ennemi(Coordonnee c, Image img) {
        super(c,img);
    }

    public abstract TypeEnnemi getType();
    
    public void Bouger(DirectionDeplacement dir) {
            throw new UnsupportedOperationException();
    }
}