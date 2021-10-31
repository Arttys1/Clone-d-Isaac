package com.mycompany.thebindingofalice.Metier.objet.obstacle;

import com.mycompany.thebindingofalice.Metier.Coordonnee;
import com.mycompany.thebindingofalice.Metier.objet.Objet;

/**
 * Classe abstraite, héritant de Objet, représentant les objets qui font obstacle au joueur
 */
public abstract class Obstacle extends Objet {

    protected Obstacle(Coordonnee c) {
        super(c);
    }
	
}