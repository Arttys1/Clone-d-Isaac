package thebindingofalice.Metier.objet.obstacle;

import thebindingofalice.Metier.Coordonnee;
import thebindingofalice.Metier.Hitbox;
import thebindingofalice.Metier.ICollision;
import thebindingofalice.Metier.Partie;
import thebindingofalice.Metier.joueur.Joueur;
import thebindingofalice.Metier.niveau.carte.Generateur.CaseMur;
import thebindingofalice.Metier.niveau.carte.salle.DirectionSalle;
import thebindingofalice.Metier.niveau.carte.salle.Salle;
import thebindingofalice.Metier.objet.TypeObjet;

/**
 * Classe, héritant de Obstacle, représentant les murs
 */
public class Mur extends Obstacle {
    private final Hitbox hitbox;
    private DirectionSalle dir = null;
    
    public Mur(Coordonnee c) {
        super(c);
        hitbox = new Hitbox(c.getX(), c.getY(), 50, 50);
    }
    
    public Mur(Coordonnee c, CaseMur caseMur)
    {
        this(c);
        int colonne = caseMur.getColonne();
        int ligne = caseMur.getLigne();
        if(colonne == 0)
        {
            dir = DirectionSalle.GAUCHE;
        }
        else if(colonne == Salle.getTailleCote() - 1)
        {
            dir = DirectionSalle.DROITE;
        }
        else if(ligne == 0)
        {
            dir = DirectionSalle.HAUT;
        }
        else if(ligne == Salle.getTailleCote() - 1)
        {
            dir = DirectionSalle.BAS;
        }
    }
    
    
    @Override
    public TypeObjet getType() {
        return TypeObjet.MUR;
    }

    @Override
    public void evoluer(double pas) {

    }

    @Override
    public void Collision(ICollision o) {
        if(o.EstLeJoueur())
        {
            Joueur joueur = Partie.get().GetJoueur();
            double x = getCoordonnee().getX();
            double y = getCoordonnee().getY();
            Coordonnee coord = joueur.getCoordonnee();
            switch(dir)
            {
                case HAUT: coord.setY(hitbox.getY() + hitbox.getHeight());
                    break;
                case BAS: coord.setY(hitbox.getY());
                    break;
                case GAUCHE: coord.setX(hitbox.getX() + hitbox.getWidth()); 
                    break;
                case DROITE: coord.setX(hitbox.getX() - 60);
                    break;
                default:
                    throw new AssertionError(dir.name());
                
            }
        }
    }

    @Override
    public boolean EstLeJoueur() {
        return false;
    }

    @Override
    public boolean EstBloquant() {
        return true;
    }

    @Override
    public Hitbox getHitbox() {
        return hitbox;
    }
}