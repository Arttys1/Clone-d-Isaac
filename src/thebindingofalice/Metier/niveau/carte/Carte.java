package thebindingofalice.Metier.niveau.carte;

import thebindingofalice.Metier.niveau.carte.salle.DirectionSalle;
import thebindingofalice.Metier.niveau.carte.salle.Salle;
import thebindingofalice.Metier.niveau.Niveau;
import java.util.ArrayList;
import thebindingofalice.Metier.niveau.carte.salle.SalleSimple;

/**
 * Classe représentant la carte d'un niveau
 */
public class Carte {

    private final ArrayList<Salle> salles;
    private Salle salleCourante;

    public Carte() {
        this.salles = new ArrayList<>();
        salleCourante = new SalleSimple();
    }

    public ArrayList<Salle> GetSalle() {
        return salles;
    }
    
    public Salle getSalleCourante()
    {
        return salleCourante;
    }

    public void ChangerSalle(DirectionSalle directionSalle) {
        
    }
    
    
}
