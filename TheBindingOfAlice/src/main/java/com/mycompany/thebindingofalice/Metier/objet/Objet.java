package com.mycompany.thebindingofalice.Metier.objet;

import com.mycompany.thebindingofalice.Metier.Coordonnee;
import com.mycompany.thebindingofalice.Metier.Evoluable;
import com.mycompany.thebindingofalice.Metier.ICollision;

/**
 * Classe abstraite, héritant de Evoluable, représentant les objets au sols
 */
public abstract class Objet extends Evoluable implements ICollision {

    protected Objet(Coordonnee c) {
        super(c);
    }
    
    public abstract TypeObjet getType(); 
}