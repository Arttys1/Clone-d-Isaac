/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thebindingofalice.Controller;

import thebindingofalice.IHM.view.TirAllieView;
import thebindingofalice.Metier.joueur.DirectionDeplacement;
import thebindingofalice.Metier.joueur.Joueur;
import thebindingofalice.Metier.projectiles.DirectionTir;
import thebindingofalice.Metier.projectiles.ProjectileAllie;

/**
 *
 * @author Arnaud
 */
public class ControlleurJoueur{
    private final Joueur joueur;

    public ControlleurJoueur(Joueur joueur) {
        this.joueur = joueur;
    }
    
    public void bouger(DirectionDeplacement dir)
    {
        joueur.Bouger(dir);
    }
  
    public TirAllieView tirer(DirectionTir d)
    {
        return new TirAllieView(joueur.Tirer(d));
    }

    public void sArreter(DirectionDeplacement d)
    {
        joueur.sArreter(d);
    }
}
