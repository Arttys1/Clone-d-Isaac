package thebindingofalice.Metier.ennemis.volant;

import java.util.Random;
import thebindingofalice.Metier.Coordonnee;
import thebindingofalice.Metier.Hitbox;
import thebindingofalice.Metier.ICollision;
import thebindingofalice.Metier.ennemis.TypeEnnemi;

/**
 * Classe ,héritant de Ennemi Volant, représentant les chauves souris
 */
public class ChauveSouris extends EnnemiVolant {

    private int frame;
    
    public ChauveSouris(Coordonnee c) {
        super(c);
        frame = 25;
    }

    /**
     * Méthode appelé à chaque frame du jeu.
     * Le paramètre pas représente le pas de temps entre deux appel de la méthode.
     * @param pas 
     */
    public void evoluer(double pas) {
        if (frame <= 0) {
            Random r = new Random();
            int v = getStatistiques().getVitesseDeplacement();
            setVitesseX(r.nextDouble() % v);
            setVitesseY(r.nextDouble() % v);
            frame = 25;
        }
        else
        {
            frame--;
        }
        
        Coordonnee c = getCoordonnee();
        setCoordonnee(new Coordonnee(c.getX() * getVitesseX() * pas, c.getY() * getVitesseY() * pas));
        System.out.println("x :" + getCoordonnee().getX() + "| y :" + getCoordonnee().getY());
    }

    public void Collision(ICollision o) {
        
    }

    public boolean EstLeJoueur() {
        return false;
    }

    public boolean EstBloquant() {
        return false;
    }

    @Override
    public TypeEnnemi getType() {
        return null;
    }

    @Override
    public Hitbox getHitbox() {
        return null;
    }
}