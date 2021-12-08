package thebindingofalice.Metier.joueur;

import java.util.ArrayList;
import thebindingofalice.IHM.GamePane;
import thebindingofalice.IHM.view.TirAllieView;
import thebindingofalice.Metier.Coordonnee;
import thebindingofalice.Metier.Evoluable;
import thebindingofalice.Metier.Hitbox;
import thebindingofalice.Metier.ICollision;
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
    //Statistique du joueur
    private Statistiques stats;
    private int vieMax;
    private ArrayList<TypeCoeur> vie;
    private double vitesseX = 0;
    private double vitesseY = 0;
    private double cadTir;
    private Cle[] cles;
    
    private Salle salleCourante; //utile ?
    
    //Hitbox du joueur
    private final Hitbox hitbox;
    
    //Booléen gérant les déplacements et le tir
    private boolean goNorth, goSouth, goEast,goWest,shootingNorth,shootingSouth,shootingEast,shootingWest, canShoot;
    
    private int frameInvicibilite = 0;
    private boolean invincible = false;
    private int dernierDept = 0;
    
    /**
     * Constructeur du joueur
     * @param c coordonnée du joueur
     */
    public Joueur(Coordonnee c) {
        super(c);
        stats = new Statistiques();
        hitbox = new Hitbox(c.getX(), c.getY(), 30, 30);
        this.canShoot = true;
        cadTir = -1;
        this.vie = new ArrayList<>();
        InstanceVie();
    }

    /**
     * Met les booléens nécessaires à true
     * @param dir ceux correspondant à la direction donnée
     */
    public void Tirer(DirectionTir dir) {
        
        switch(dir)
        {
            case HAUT:    shootingNorth = true; break;
            case BAS:     shootingSouth = true; break;
            case GAUCHE:  shootingWest  = true; break;
            case DROITE:  shootingEast  = true; break;
            default:
                
                throw new AssertionError(dir.name());            
        }
    }
    
    /**
     * Met les booléens de tir nécessaires à false
     * @param dir ceux correspondant à la direction donnée
     */
    public void stopTirer(DirectionTir dir) {
        switch(dir)
        {
            case HAUT:    shootingNorth = false; break;
            case BAS:     shootingSouth = false; break;
            case GAUCHE:  shootingWest  = false; break;
            case DROITE:  shootingEast  = false; break;
            default:
                
                throw new AssertionError(dir.name());                
        }
    }

    /**
     * Met les booléens de déplacement nécessaires à true
     * @param dir ceux correspondant à la direction donnée
     */
    public void Bouger(DirectionDeplacement dir) {
        double v = stats.getVitesseDeplacement();
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

    /**
     * Met les booléens de déplacement nécessaires à false
     * @param dir ceux correspondant à la direction donnée
     */
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
        if (!invincible) {
            for (int i = 0; i < nbDegat; i++) {
                if (!vie.isEmpty()) {
                    vie.remove(0);
                }
            }
            invincible = true;
            frameInvicibilite = 25;
            Notify("degat");
        }
    }

    /**
     * Méthode pour ajouter des coeurs au personnage
     * @param type
     * @param nb correspond aux demi-coeur
     */
    public void AddCoeur(TypeCoeur type, int nb) {
        for(int nbDemiCoeur = 0; nbDemiCoeur < nb;nbDemiCoeur++)
        {
            switch (type) 
            {
                case ROUGE:
                    this.vie.add(type);
                    Notify("healRouge");
                    break;
            }
        }
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
        if (invincible) {            
            frameInvicibilite--;
            if (frameInvicibilite < 0) {
                frameInvicibilite = 25;
                invincible = false;
            }
        }
        
        //Change la vitesse en x et en y selon la direction dans laquelle on se déplace
        double v = stats.getVitesseDeplacement();
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
        
        //Si on peut tirer, tir dans la direction adéquate
        if (canShoot) {
            if (shootingNorth) {
                shootingSouth = false;
                shootingWest = false;
                shootingEast = false;
                instancierTir(DirectionTir.HAUT);
                this.canShoot = false;
            }
            if(shootingSouth){
                shootingNorth=false;
                shootingWest=false;
                shootingEast=false;
                instancierTir(DirectionTir.BAS);
                this.canShoot = false;
            }
            if(shootingWest){
                shootingSouth=false;
                shootingNorth=false;
                shootingEast=false;
                instancierTir(DirectionTir.GAUCHE);
                this.canShoot = false;
            }
            if(shootingEast){
                shootingSouth=false;
                shootingWest=false;
                shootingNorth=false;
                instancierTir(DirectionTir.DROITE);
                this.canShoot = false;
            }
        }        
        
        //Si on ne peut pas tirer change la valeur du cooldown de tir
        if(!canShoot) {
            if (this.cadTir == -1) {
                cadTir = this.stats.getCadenveTir();
            } else if (this.cadTir > 0) {
                this.cadTir--;
            } else if (this.cadTir == 0) {
                this.cadTir--;
                this.canShoot = true;
            }
        }

        Coordonnee c = getCoordonnee();
        setCoordonnee(new Coordonnee(c.getX() + vitesseX * pas, c.getY() + vitesseY * pas));
        hitbox.setPosition(c, 17, 20); //les valeurs seront à changé
        Notify("joueur"); 
        
        
    }

    /**
     * Créer un tir allié
     * @param dir dans la direction donnée
     */
    private void instancierTir(DirectionTir dir)
    {
        Coordonnee coord = new Coordonnee(this.getCoordonnee().getX()+22,this.getCoordonnee().getY()+10);
        ProjectileAllie p = new ProjectileAllie(coord, dir);
        TirAllieView tirView = new TirAllieView(p);
        GamePane.get().addView(tirView);   
    }
    
    
    @Override
    public void Collision(ICollision o) {
        if (o.EstBloquant()) {
            Coordonnee co = new Coordonnee(this.getCoordonnee());
            //info sur le joueur (des points qui se situe sur un côté de la hitbox)
            double droite = hitbox.getX() + hitbox.getWidth();
            double haut = hitbox.getY();
            double gauche = hitbox.getX();
            double bas = hitbox.getY() + hitbox.getHeight();
           
            double joueurX = this.getCoordonnee().getX();
            double joueurY = this.getCoordonnee().getY();
            double absX = Math.abs(vitesseX);
            double absY = Math.abs(vitesseY);
            
            //info sur l'objet (les même points que pour le joueur)
            double hautMur = o.getHitbox().getY();
            double basMur = o.getHitbox().getY() + o.getHitbox().getHeight();
            double droiteMur = o.getHitbox().getX() + o.getHitbox().getWidth();
            double gaucheMur = o.getHitbox().getX();            
            
            if (absX>absY) { //gauche et droite
                if (vitesseX > 0 && gaucheMur < droite  && droite < droiteMur) {//vers la droite
                    co.setX(joueurX - (droite - gaucheMur));
                    dernierDept = 1;
                } else if (vitesseX < 0 && gaucheMur < gauche  && gauche < droiteMur){ //vers la gauche
                    co.setX(joueurX - (gauche-droiteMur));
                    dernierDept = 2;
                }
            } else if (absY>absX) { // haut et bas
                if(vitesseY < 0 && hautMur < haut  && haut < basMur){ //haut
                    co.setY(joueurY - (haut - basMur));
                    dernierDept=3;
                } else if (vitesseY>0 && hautMur < bas  && bas < basMur) { //bas
                    co.setY(joueurY - (bas - hautMur));
                    dernierDept=4;
                }

            } else if(absX==0 && absY==0){ //Quand on est immobile mais en collision "à cause" du pas de temps
                switch(dernierDept){
                    case 1: co.setX(joueurX - (droite - gaucheMur) - 1);
                            dernierDept = 0;
                            break;
                    case 2: co.setX(joueurX - (gauche-droiteMur) + 1);
                            dernierDept = 0;
                            break;
                    case 3: co.setY(joueurY - (haut - basMur) + 1);
                            dernierDept = 0;
                            break;
                    case 4: co.setY(joueurY - (bas - hautMur) - 1);
                            dernierDept = 0;
                            break;
                }
            } else { //diagonale
                if (vitesseX>0 && vitesseY<0){//diagonale haut droite
                    if(gauche<gaucheMur && gauche<droiteMur){//Touche à droite
                        co.setX(joueurX - (droite - gaucheMur));
                        dernierDept = 1;
                    } else if (bas>basMur && bas>hautMur){//touche en haut
                        co.setY(joueurY - (haut - basMur));
                        dernierDept=3;
                    }
                } else if (vitesseX>0 && vitesseY>0){//diagonale bas droite
                    if(gauche<gaucheMur && gauche<droiteMur){//Touche à droite
                        co.setX(joueurX - (droite - gaucheMur));
                        dernierDept = 1;
                    } else if (hautMur < bas  && bas < basMur) { //Touche en bas 
                        co.setY(joueurY - (bas - hautMur));
                        dernierDept=4;
                    }                    
                } else if (vitesseX<0 && vitesseY<0){ //diagonale haut gauche
                    if (bas>basMur && bas>hautMur){//touche en haut
                        co.setY(joueurY - (haut - basMur));
                        dernierDept=3;
                    } else if (gaucheMur < gauche  && gauche < droiteMur){ //touche à gauche
                        co.setX(joueurX - (gauche-droiteMur));
                        dernierDept = 2;
                    }
                } else if (vitesseX<0 && vitesseY>0){//diagonale bas gauche
                    if (hautMur < bas  && bas < basMur) { //Touche en bas 
                        co.setY(joueurY - (bas - hautMur));
                        dernierDept=4;
                    } else if (gaucheMur < gauche  && gauche < droiteMur){ //touche à gauche
                        co.setX(joueurX - (gauche-droiteMur));
                        dernierDept = 2;
                    }
                }
            }
            this.setCoordonnee(co);
        }
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
    public boolean estUnProjectileAllie() {
        return false;
    }

    @Override
    public Hitbox getHitbox() { 
        return hitbox; 
    }

    //utile ?
    public void stop() {
        vitesseX = 0;
        vitesseY = 0;
    }
    /**
     * Initialise la liste de vie
     */
    private void InstanceVie() {
        for(int x = 0 ; x < 12; x++)
        {
            this.vie.add(TypeCoeur.ROUGE);
        
        }
    }
    /**
     * retourne la liste de vie
     * @return 
     */
    public ArrayList<TypeCoeur> getVie() {
        return vie;
    }
    
}
