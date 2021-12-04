package thebindingofalice.Metier.ennemis.volant;

import thebindingofalice.Metier.Coordonnee;
import thebindingofalice.Metier.Hitbox;
import thebindingofalice.Metier.ICollision;
import thebindingofalice.Metier.ennemis.TypeEnnemi;
import thebindingofalice.Metier.niveau.carte.salle.Salle;

/**
 * Classe ,héritant de Ennemi Volant, représentant les chauves souris
 */
public class ChauveSouris extends EnnemiVolant {

    //Statistique
    private int vie = 3;
    private double vitesseX = 0;
    private double vitesseY = 0;
    private double cadTir;
    
    //Hitbox de l'ennemi
    private final Hitbox hitbox;
    
    private Salle salleCourante; //utile ?
    
    public ChauveSouris(Coordonnee c) {
        super(c);
        hitbox = new Hitbox(c.getX(), c.getY(), 27, 36);
    }

    /**
     * /**
     *  * Méthode appelé à chaque frame du jeu. Le paramètre pas représente le pas de temps entre deux appel de la méthode.
     *  * /
     */
    public void evoluer(double pas) {
            
    }

    public void Collision(ICollision o) {
            if(o.EstLeJoueur()){
                
            }
    }

    public boolean EstLeJoueur() {
            return false;
    }

    public boolean EstBloquant() {
            return false;
    }

    @Override
    public TypeEnnemi getType() {
        return TypeEnnemi.VOLANT;
    }

    @Override
    public Hitbox getHitbox() {
        return hitbox;
    }
}