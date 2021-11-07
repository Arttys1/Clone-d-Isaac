package thebindingofalice.Metier.joueur;

import thebindingofalice.Metier.Coordonnee;
import thebindingofalice.Metier.Evoluable;
import thebindingofalice.Metier.ICollision;
import thebindingofalice.Metier.Statistiques;
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
	private int vitesseX = 0;
	private int vitesseY = 0;
	private Cle[] cles;
	private Salle salleCourante;
	private Statistiques stats;

    public Joueur(Coordonnee c) {
        super(c);
        stats = new Statistiques();
    }

    public void Tirer(DirectionTir tir) {
            throw new UnsupportedOperationException();
    }

    public void Bouger(DirectionDeplacement dir) {
        final int vitesseMax = 20;
        int v = stats.getVitesseDeplacement();
        int coefY;
        int coefX;
        switch(dir)
        {
            case HAUT:          coefY = -1; coefX = 0; break;
            case HAUT_DROITE:   coefY = -1; coefX = 1; break; 
            case DROITE:        coefY = 0; coefX = 1; break;
            case BAS_DROITE:    coefY = 1; coefX = 1; break;
            case BAS:           coefY = 1; coefX = 0; break;
            case BAS_GAUCHE:    coefY = 1; coefX = -1; break;
            case GAUCHE:        coefY = 0; coefX = -1; break;
            case HAUT_GAUCHE:   coefY = -1; coefX = -1; break;
            default:
                throw new AssertionError(dir.name());                
        }
        vitesseX += v * coefX;
        vitesseY += v * coefY;

        if (vitesseX > vitesseMax) {
            vitesseX = vitesseMax;
        }
        if (vitesseX < -vitesseMax) {
            vitesseX = -vitesseMax;
        }
        if (vitesseY > vitesseMax) {
            vitesseY = vitesseMax;
        }
        if (vitesseY < -vitesseMax) {
            vitesseY = -vitesseMax;
        }
    }

    public void sArreter() {
        vitesseX = 0;
        vitesseY = 0;
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
     * Méthode appelé à chaque frame du jeu. Le paramètre pas représente le pas
     * de temps entre deux appel de la méthode.
     *
     * @param pas pas de temps de la boucle de jeu
     */
    @Override
    public void evoluer(double pas) {
        Coordonnee c = getCoordonnee();
        setCoordonnee(new Coordonnee(c.getX() + vitesseX * pas, c.getY() + vitesseY * pas));
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