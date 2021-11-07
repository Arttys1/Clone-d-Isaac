package thebindingofalice.Metier;

import thebindingofalice.Metier.joueur.Joueur;
import thebindingofalice.Metier.niveau.carte.salle.DirectionSalle;
import thebindingofalice.Metier.niveau.Niveau;
import java.util.ArrayList;
import thebindingofalice.Metier.niveau.algoNiveau.AlgoCreationNiveaux;
import thebindingofalice.Metier.niveau.algoNiveau.MockAlgoNiveaux;

/**
 * Classe représentant une partie du jeu. Elle est le point d'entrée de la couche métier
 */
public class Partie {
    private static Partie instance = null;                  //Instance de la partie
    private final ArrayList<Niveau> niveaux;                //listes des niveaux
    private Niveau niveauCourant;                           //niveau courant
    private final ArrayList<ICollision> objetsCollision;    //ICollision de la partie
    private Joueur joueur;                                  //le joueur

    private Partie() {        
        this.objetsCollision = new ArrayList<>();
        joueur = new Joueur(new Coordonnee(1, 1));
        AlgoCreationNiveaux algo = new MockAlgoNiveaux();
        this.niveaux = algo.getNiveaux();
        niveauCourant = niveaux.get(0);
    }

    /**
     * Méthode renvoyant l'instance de la Partie.
     * @return l'instance de la Partie
     */
    public static Partie get() {
        if(instance == null)
        {
            instance = new Partie();
        }
        return instance;
    }

    public void Evoluer() {
        //TODO
    }

    /**
     * Méthode permettant d'ajouter un ICollision à la liste
     * @param o ICollision à ajouter à la liste
     */
    public void addICollision(ICollision o) { objetsCollision.add(o); }
    
    /**
     * Accesseur du joueur
     * @return le joueur
     */
    public Joueur GetJoueur() { return joueur; }

    /**
     * Méthode permettant de changer de salle selon la direction de la porte emprunté.
     * @param d la direction de la porte.
     */
    public void ChangerSalle(DirectionSalle d) {
        niveauCourant.ChangerSalle(d);
    }

    /**
     * Méthode permettant de passer au niveau suivant
     */
    public void ChangerNiveau() {
        //TODO
    }
    
    /**
     * Accesseur du niveau courant
     * @return le niveau courant
     */
    public Niveau getNiveauCourant() { return niveauCourant; }
}