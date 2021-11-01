package thebindingofalice.Metier;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Classe abstraite, représentant les objets pouvant evoluer au cours du temps.
 */
public abstract class Evoluable extends Rectangle{
    private final Coordonnee coordonnee;

    protected Evoluable(Coordonnee c,int w, int h, Color color) {
        super(h,w,color);
        coordonnee = c;
        
    }
        
    public Coordonnee getCoordonnee() { return coordonnee; }
    
    /**
     * Méthode appelé à chaque frame du jeu.Le paramètre pas représente le pas de temps entre deux appel de la méthode.
     * @param pas
     */
    public abstract void evoluer(long pas);
}