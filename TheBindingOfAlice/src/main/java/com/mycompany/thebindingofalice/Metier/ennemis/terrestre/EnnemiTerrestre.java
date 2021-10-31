package com.mycompany.thebindingofalice.Metier.ennemis.terrestre;

import com.mycompany.thebindingofalice.Metier.Coordonnee;
import com.mycompany.thebindingofalice.Metier.ennemis.Ennemi;

/**
 * Classe abstraite, héritant de Ennemi, représentant les ennemis terrestres
 */
public abstract class EnnemiTerrestre extends Ennemi {

    public EnnemiTerrestre(Coordonnee c) {
        super(c);
    }
}