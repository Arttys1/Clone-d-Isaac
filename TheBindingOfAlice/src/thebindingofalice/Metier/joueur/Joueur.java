package thebindingofalice.Metier.joueur;

import thebindingofalice.Metier.Coordonnee;
import thebindingofalice.Metier.Evoluable;
import thebindingofalice.Metier.ICollision;
import thebindingofalice.Metier.Partie;
import thebindingofalice.Metier.Statistiques;
import thebindingofalice.Metier.joueur.DirectionDeplacement;
import thebindingofalice.Metier.niveau.carte.salle.DirectionSalle;
import thebindingofalice.Metier.projectiles.DirectionTir;
import thebindingofalice.Metier.objet.ramassable.TypeCoeur;
import thebindingofalice.Metier.niveau.carte.salle.Salle;
import thebindingofalice.Metier.objet.ramassable.Cle;

/**
 * Classe, héritant de Evoluable et de ICollision, représentant le joueur.
 */
public class Joueur extends Evoluable implements ICollision {
	private int vieMax;
	private int[] vie;
	private int vitesseX;
	private int vitesseY;
	private Cle[] cles;
	private Salle salleCourante;
	private Statistiques stats;

    public Joueur(Coordonnee c) {
        super(c);
    }

    public void Tirer(DirectionTir tir) {
            throw new UnsupportedOperationException();
    }

    public void Bouger(DirectionDeplacement dir) {
            throw new UnsupportedOperationException();
    }

    public void PrendDegat(int nbDegat) {
            throw new UnsupportedOperationException();
    }

    public void AddCoeur(TypeCoeur type, int nb) {
            throw new UnsupportedOperationException();
    }

    public void AddCle(Cle cle) {
            throw new UnsupportedOperationException();
    }

    public void ChangerSalle(DirectionSalle d) {
            throw new UnsupportedOperationException();
    }

    public void ChangerNiveau() {
            throw new UnsupportedOperationException();
    }

    /**
     * /**
     *  * Méthode appelé à chaque frame du jeu. Le paramètre pas représente le pas de temps entre deux appel de la méthode.
     *  * /
     */
    public void evoluer(long pas) {
            throw new UnsupportedOperationException();
    }

    public void Collision(ICollision o) {
            throw new UnsupportedOperationException();
    }

    public boolean EstLeJoueur() {
            throw new UnsupportedOperationException();
    }

    public boolean EstBloquant() {
            throw new UnsupportedOperationException();
    }
}