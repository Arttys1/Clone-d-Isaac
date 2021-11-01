package thebindingofalice.Metier.niveau;

import thebindingofalice.Metier.niveau.carte.salle.DirectionSalle;
import thebindingofalice.Metier.Partie;
import thebindingofalice.Metier.niveau.carte.Carte;
import thebindingofalice.Metier.niveau.carte.salle.Salle;

/**
 * Classe représentant les niveaux du jeu.
 */
public class Niveau {
    private Carte carte;

    public Niveau() {
        carte = new Carte();
    }   

    public Salle getSalleCourante()
    {
        return carte.getSalleCourante();
    }
    
    public Carte getCarte() { return carte; }

    public void ChangerSalle(DirectionSalle d) {
            throw new UnsupportedOperationException();
    }
}