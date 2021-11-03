package thebindingofalice.Metier;
import java.io.File;
import java.net.MalformedURLException;
import thebindingofalice.Metier.joueur.Joueur;
import thebindingofalice.Metier.niveau.carte.salle.DirectionSalle;
import thebindingofalice.Metier.niveau.Niveau;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

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
        //Coordonnees de départ du joueur
        Coordonnee c = new Coordonnee(480,270);
        //Création du joueur de la partie
        File file = new File("src/thebindingofalice/Images/Sprites/chat.png");
        String localUrl = null;
        try {
            localUrl = file.toURI().toURL().toString();
        } catch (MalformedURLException ex) {
            Logger.getLogger(Partie.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.joueur= new Joueur(c, new Image(localUrl));
        
    }

    public static Partie get() {
        if(instance == null)
        {
            instance = new Partie();
        }
        return instance;
    }

    public void Evoluer() {
            throw new UnsupportedOperationException();
    }

    public void addICollision(ICollision o) { objetsCollision.add(o); }
    
    public Joueur GetJoueur() { return joueur; }

    public void ChangerSalle(DirectionSalle d) {
            throw new UnsupportedOperationException();
    }

    public void ChangerNiveau() {
            throw new UnsupportedOperationException();
    }
}