/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thebindingofalice.Metier.objet.obstacle;

import thebindingofalice.Metier.Coordonnee;
import thebindingofalice.Metier.Hitbox;
import thebindingofalice.Metier.ICollision;
import thebindingofalice.Metier.objet.TypeObjet;

/**
 *Classe, héritant de Obstacle, représentant les portes
 * @author Pascaline
 */
public class Porte extends Obstacle{

    private final Hitbox hitbox;
    private boolean ouvert = false;
    
    public Porte(Coordonnee c) {
        super(c);
        hitbox = new Hitbox(c.getX(), c.getY(), 60, 60);
    }

    @Override
    public TypeObjet getType() {
        return TypeObjet.PORTE;
    }

    @Override
    public void evoluer(double pas) {
        
    }

    @Override
    public void Collision(ICollision o) {
    }

    @Override
    public boolean EstLeJoueur() {
        return false;
    }

    @Override
    public boolean EstBloquant() {
        return !ouvert;
    }

    @Override
    public boolean estUnProjectileAllie() {
        return false;
    }

    @Override
    public Hitbox getHitbox() {
        return hitbox;
    }

    public boolean isOuvert() {
        return ouvert;
    }

    public void setOuvert(boolean ouvert) {
        this.ouvert = ouvert;
    }
    
    
    
}
