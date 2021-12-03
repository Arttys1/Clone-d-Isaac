package thebindingofalice.Metier.ennemis;

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
    private double vitesseX = 0;
    private double vitesseY = 0;

    public Ennemi(Coordonnee c) {
        super(c);
        statistiques = new Statistiques();
    }

    public abstract TypeEnnemi getType();
    
    public void Bouger(DirectionDeplacement dir) {
        
    }

    public double getVitesseX() {
        return vitesseX;
    }

    public void setVitesseX(double vitesseX) {
        this.vitesseX = vitesseX;
    }

    public double getVitesseY() {
        return vitesseY;
    }

    public void setVitesseY(double vitesseY) {
        this.vitesseY = vitesseY;
    }

    public Statistiques getStatistiques() {
        return statistiques;
    }
    
    
    
}