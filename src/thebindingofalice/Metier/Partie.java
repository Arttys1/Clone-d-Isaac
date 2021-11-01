package thebindingofalice.Metier;
import thebindingofalice.Metier.joueur.Joueur;
import thebindingofalice.Metier.niveau.carte.salle.DirectionSalle;
import thebindingofalice.Metier.niveau.Niveau;
import java.util.ArrayList;

/**
 * Classe représentant une partie du jeu. Elle est le point d'entrée de la couche métier
 */
public class Partie {
    private static Partie instance = null;
    private final ArrayList<Niveau> niveaux;
    private final ArrayList<ICollision> objetsCollision;
    private Joueur joueur;

    private Partie() {
        this.objetsCollision = new ArrayList<>();
        this.niveaux = new ArrayList<>();
        
    }

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

    public void addICollision(ICollision o) { objetsCollision.add(o); }
    
    public Joueur GetJoueur() { return joueur; }

    public void ChangerSalle(DirectionSalle d) {
        //TODO
    }

    public void ChangerNiveau() {
        //TODO
    }
}