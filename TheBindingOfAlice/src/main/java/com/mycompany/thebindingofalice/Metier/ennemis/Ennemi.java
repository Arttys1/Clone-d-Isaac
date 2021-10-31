package com.mycompany.thebindingofalice.Metier.ennemis;

import com.mycompany.thebindingofalice.Metier.Coordonnee;
import com.mycompany.thebindingofalice.Metier.joueur.DirectionDeplacement;
import com.mycompany.thebindingofalice.Metier.Evoluable;
import com.mycompany.thebindingofalice.Metier.ICollision;
import com.mycompany.thebindingofalice.Metier.Statistiques;

/**
 * Classe abstraite, héritant de Evoluable et de ICollision, représentant les ennemis du jeu
 */
public abstract class Ennemi extends Evoluable implements ICollision {
    private int vie;
    private Statistiques statistiques;

    public Ennemi(Coordonnee c) {
        super(c);
    }

    public abstract TypeEnnemi getType();
    
    public void Bouger(DirectionDeplacement dir) {
            throw new UnsupportedOperationException();
    }
}