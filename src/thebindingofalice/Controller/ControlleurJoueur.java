/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thebindingofalice.Controller;

import thebindingofalice.Metier.joueur.DirectionDeplacement;
import thebindingofalice.Metier.joueur.Joueur;

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
    
    public void sArreter()
    {
        joueur.sArreter();
    }
}
