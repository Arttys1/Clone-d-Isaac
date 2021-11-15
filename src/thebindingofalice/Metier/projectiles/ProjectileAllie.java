package thebindingofalice.Metier.projectiles;

import thebindingofalice.Metier.Coordonnee;
import thebindingofalice.Metier.Hitbox;
import thebindingofalice.Metier.ICollision;

/**
 * Classe, héritant de Projectile, représentant les projectiles alliés
 */
public class ProjectileAllie extends Projectile {
    
    private Hitbox hitbox;
    
    private DirectionTir dirTir;
    
    private float vitesse = 2.5f;
    
    private TypeProjectile type;

    public ProjectileAllie(Coordonnee coordonnee, DirectionTir dir) {
        super(coordonnee, dir);
        this.hitbox = new Hitbox(coordonnee.getX(),coordonnee.getY(),50,50);
        this.dirTir = dir;
        this.type = TypeProjectile.ProjectileAllie;
        
        
    }

    /**
     * /**
     *  * Méthode appelé à chaque frame du jeu. Le paramètre pas représente le pas de temps entre deux appel de la méthode.
     *  * /
     */
    @Override
    public void evoluer(double pas) {
           Coordonnee c = getCoordonnee();
           switch (dirTir)
           {
               case HAUT:
                   setCoordonnee(new Coordonnee(c.getX(), c.getY() - vitesse * pas));
                   hitbox.setPosition(c, 10, 10);
                   break;
               case BAS:
                   setCoordonnee(new Coordonnee(c.getX(), c.getY() + vitesse * pas));
                   hitbox.setPosition(c, 10, 10);
                   break;
               case GAUCHE:
                   setCoordonnee(new Coordonnee(c.getX() - vitesse * pas, c.getY()));
                   hitbox.setPosition(c, 10, 10);
                   break;
               case DROITE:
                   setCoordonnee(new Coordonnee(c.getX() + vitesse * pas, c.getY()));
                   hitbox.setPosition(c, 10, 10);
                   break;
           
           }
           Notify("tirallié"); 
    }

    @Override
    public void Collision(ICollision o) {
            throw new UnsupportedOperationException();
    }

    @Override
    public boolean EstLeJoueur() {
        return false;
    }

    @Override
    public boolean EstBloquant() {
        return false;
    }

    @Override
    public TypeProjectile getType() {
        
        return TypeProjectile.ProjectileAllie;
    }

    @Override
    public Hitbox getHitbox() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //return hitbox;
    }
    
    public void setType(TypeProjectile type) {
        this.type = type;
    }

    public float getVitesse() {
        return vitesse;
    }

    public void setVitesse(float vitesse) {
        this.vitesse = vitesse;
    }
}