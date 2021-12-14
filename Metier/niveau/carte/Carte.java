package thebindingofalice.Metier.niveau.carte;

import thebindingofalice.Metier.niveau.carte.salle.DirectionSalle;
import thebindingofalice.Metier.niveau.carte.salle.Salle;
import thebindingofalice.Metier.niveau.Niveau;
import java.util.ArrayList;
import thebindingofalice.IHM.GamePane;
import thebindingofalice.IHM.view.ChauveSourisView;
import thebindingofalice.Metier.Coordonnee;
import thebindingofalice.Metier.ennemis.volant.ChauveSouris;
import thebindingofalice.Metier.niveau.carte.salle.SalleSimple;

/**
 * Classe représentant la carte d'un niveau
 * @author Arnaud
 */
public class Carte {
    private final ArrayList<Salle> salles;  //liste des salles composant la carte
    private Salle salleCourante;            //salle courante

    public Carte() {
        this.salles = new ArrayList<>();
        salleCourante = new SalleSimple();

    }

    /**
     * Méthode renvoyant une copie de la liste des salles de la carte.
     * @return une copie de la liste des salles de la carte
     */
    public ArrayList<Salle> GetSalles() { return new ArrayList<>(salles); }
    
    /**
     * Accesseur de la salle courante
     * @return 
     */
    public Salle getSalleCourante() { return salleCourante; }

    /**
     * Méthode permettant de changer de salle courante selon la direction de la porte emprunté.
     * @param directionSalle direction de la porte emprunté.
     */
    public void ChangerSalle(DirectionSalle directionSalle) {
        
    }
    
    
}
