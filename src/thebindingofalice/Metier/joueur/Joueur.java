package thebindingofalice.Metier.joueur;

import thebindingofalice.Metier.Coordonnee;
import thebindingofalice.Metier.Evoluable;
import thebindingofalice.Metier.Hitbox;
import thebindingofalice.Metier.ICollision;
import thebindingofalice.Metier.Partie;
import thebindingofalice.Metier.Statistiques;
import thebindingofalice.Metier.niveau.carte.salle.DirectionSalle;
import thebindingofalice.Metier.projectiles.DirectionTir;
import thebindingofalice.Metier.objet.ramassable.TypeCoeur;
import thebindingofalice.Metier.niveau.carte.salle.Salle;
import thebindingofalice.Metier.objet.ramassable.Cle;
import thebindingofalice.Metier.projectiles.ProjectileAllie;

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
    private Hitbox hitbox;

    public Joueur(Coordonnee c) {
        super(c);
        stats = new Statistiques();
        hitbox = new Hitbox(c.getX(), c.getY(), 30, 30);
        
        
    }

    public ProjectileAllie Tirer(DirectionTir tir) {
        Coordonnee corTir = new Coordonnee(this.getCoordonnee().getX()+22,this.getCoordonnee().getY()+10);
        ProjectileAllie p = new ProjectileAllie(corTir, tir);
        Notify("TirAllié");
        return p;
    }

    public void Bouger(DirectionDeplacement dir) {
        int v = stats.getVitesseDeplacement();
        switch(dir)
        {
            case HAUT: vitesseY = -v; break;
            case HAUT_DROITE: break; 
            case DROITE: vitesseX = v; break;
            case BAS_DROITE:  break;
            case BAS: vitesseY = v; break;
            case BAS_GAUCHE:  break;
            case GAUCHE: vitesseX = -v; break;
            case HAUT_GAUCHE:  break;
            default:
                throw new AssertionError(dir.name());                
        }
    }

    public void sArreter(DirectionDeplacement dir) {
        switch(dir)
        {
            case HAUT: vitesseY = 0; break;
            case HAUT_DROITE: break; 
            case DROITE: vitesseX = 0; break;
            case BAS_DROITE:  break;
            case BAS: vitesseY = 0; break;
            case BAS_GAUCHE:  break;
            case GAUCHE: vitesseX = 0; break;
            case HAUT_GAUCHE:  break;
            default:
                throw new AssertionError(dir.name());                
        }
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
     * @param pas pas de temps de la boucle de jeu
     */
    @Override
    public void evoluer(double pas) {
        Coordonnee c = getCoordonnee();
        setCoordonnee(new Coordonnee(c.getX() + vitesseX * pas, c.getY() + vitesseY * pas));
        hitbox.setPosition(c, 10, 20); //les valeurs seront à changé
        Notify("joueur");
    }

    @Override
    public void Collision(ICollision o) {
        
    }

    @Override
    public boolean EstLeJoueur() {
        return true;
    }

    @Override
    public boolean EstBloquant() {
       return false;
    }

    @Override
    public Hitbox getHitbox() { return hitbox; }

    public void stop() {
        vitesseX = 0;
        vitesseY = 0;
    }
}
