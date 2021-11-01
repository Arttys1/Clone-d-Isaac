/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thebindingofalice.Controller;

import thebindingofalice.Metier.niveau.Niveau;
import thebindingofalice.Metier.niveau.carte.salle.DirectionSalle;

/**
 *
 * @author Arnaud
 */
public class ControlleurNiveau extends Observable{
    private Niveau niveau;

    public ControlleurNiveau(Niveau niveau) {
        this.niveau = niveau;
    }
    
    public void ChangerSalle(DirectionSalle d)
    {
        //TODO
        Notify("niveau");
    }

    public Niveau getNiveau() {
        return niveau;
    }
    
}
