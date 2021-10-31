package com.mycompany.thebindingofalice.Metier.niveau;

import com.mycompany.thebindingofalice.Metier.niveau.carte.salle.DirectionSalle;
import com.mycompany.thebindingofalice.Metier.Partie;
import com.mycompany.thebindingofalice.Metier.niveau.carte.Carte;

/**
 * Classe représentant les niveaux du jeu.
 */
public class Niveau {
    private Carte carte;

    public Niveau() {
        carte = new Carte();
    }   

    public Carte getCarte() { return carte; }

    public void ChangerSalle(DirectionSalle d) {
            throw new UnsupportedOperationException();
    }
}