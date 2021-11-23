package thebindingofalice.Metier.joueur;

import javafx.animation.AnimationTimer;
import thebindingofalice.IHM.GamePane;
import thebindingofalice.IHM.view.TirAllieView;
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
    private boolean goNorth, goSouth, goEast,goWest,shootingNorth,shootingSouth,shootingEast,shootingWest;

    public Joueur(Coordonnee c) {
        super(c);
        stats = new Statistiques();
        hitbox = new Hitbox(c.getX(), c.getY(), 30, 30);
        
        
    }

    public void Tirer(DirectionTir dir) {
        switch(dir)
        {
            case HAUT:    shootingNorth = true; break;
            case BAS:     shootingSouth = true; break;
            case GAUCHE:  shootingEast  = true; break;
            case DROITE:  shootingWest  = true; break;
            default:
                throw new AssertionError(dir.name());                
        }
    }
    
    public void stopTirer(DirectionTir dir) {
        switch(dir)
        {
            case HAUT:    shootingNorth = false; break;
            case BAS:     shootingSouth = false; break;
            case GAUCHE:  shootingEast  = false; break;
            case DROITE:  shootingWest  = false; break;
            default:
                throw new AssertionError(dir.name());                
        }
    }

    public void Bouger(DirectionDeplacement dir) {
        int v = stats.getVitesseDeplacement();
        switch(dir)
        {
            case HAUT:    goNorth = true; break;
            case BAS:     goSouth = true; break;
            case GAUCHE:  goWest  = true; break;
            case DROITE:  goEast  = true; break;
            default:
                throw new AssertionError(dir.name());                
        }
    }

    public void sArreter(DirectionDeplacement dir) {
        switch(dir)
        {
            case HAUT:    goNorth = false; break;
            case BAS:     goSouth = false; break;
            case GAUCHE:  goWest  = false; break;
            case DROITE:  goEast  = false; break;
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
        
        int v = stats.getVitesseDeplacement();
        if(goNorth){
            vitesseY = -v;
        }
        else{
            vitesseY =0;
        }
        if(goSouth){
            vitesseY = v;
        }
        if(goWest){
            vitesseX = -v;
        }
        else{
            vitesseX=0;
        }
        if(goEast){
            vitesseX = v;
        }

        if(shootingNorth){
            instancierTir(DirectionTir.HAUT);  
        }
        if(shootingSouth){
            instancierTir(DirectionTir.BAS);  
        }
        if(shootingWest){
            instancierTir(DirectionTir.GAUCHE);  
        }
        if(shootingEast){
            instancierTir(DirectionTir.DROITE);            
        }
        
        
        Coordonnee c = getCoordonnee();
        setCoordonnee(new Coordonnee(c.getX() + vitesseX * pas, c.getY() + vitesseY * pas));
        hitbox.setPosition(c, 10, 20); //les valeurs seront à changé
        Notify("joueur");       
        
    }

    private void instancierTir(DirectionTir dir)
    {
        Coordonnee coord = new Coordonnee(this.getCoordonnee().getX()+22,this.getCoordonnee().getY()+10);
        ProjectileAllie p = new ProjectileAllie(coord, dir);
        TirAllieView tirView = new TirAllieView(p);        
        GamePane.get().addView(tirView);   
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
