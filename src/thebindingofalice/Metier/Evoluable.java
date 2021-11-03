package thebindingofalice.Metier;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Classe abstraite, représentant les objets pouvant evoluer au cours du temps.
 */
public abstract class Evoluable extends ImageView{
    private final Coordonnee coordonnee;

    protected Evoluable(Coordonnee c, Image img) {
        super(img);
        coordonnee = c;
        
    }
        
    public Coordonnee getCoordonnee() { return coordonnee; }
    
    /**
     * Méthode appelé à chaque frame du jeu.Le paramètre pas représente le pas de temps entre deux appel de la méthode.
     * @param pas
     */
    public abstract void evoluer(long pas);
}