/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thebindingofalice.IHM.view;

import thebindingofalice.Controller.ControlleurTirAllie;
import thebindingofalice.Controller.Observeur;
import thebindingofalice.Metier.Coordonnee;
import thebindingofalice.Metier.Partie;
import thebindingofalice.Metier.projectiles.ProjectileAllie;

/**
 *
 * @author johann
 */
public class TirAllieView extends View implements Observeur{
    private final ProjectileAllie projectile;    
    private final ControlleurTirAllie controlleurTir;
    
    public TirAllieView(ProjectileAllie p) {
        super(System.getProperty("user.dir") + "/src/thebindingofalice/Images/Sprites/Tirs/Tir.png");
        this.projectile = p;
        projectile.Register(this); 
        controlleurTir = new ControlleurTirAllie(projectile);        
        Partie.get().getNiveauCourant().getSalleCourante().AddEvoluable(projectile);
    }
    
    private void moveSpriteTir()
    {
        Coordonnee coordonnee = projectile.getCoordonnee();
        double x = coordonnee.getX();
        double y = coordonnee.getY();
        //System.out.println("x" + x + " | y" + y);
        translate(x, y);
    }
    @Override
    public void Update(String message) {
        switch(message.toLowerCase())
        {
            case "tirallie" : moveSpriteTir(); break;
            case "delete" : break;
            default: break;
        }
    }
    
}