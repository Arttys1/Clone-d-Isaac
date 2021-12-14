/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thebindingofalice.IHM.view;

import thebindingofalice.Controller.Observeur;
import thebindingofalice.Metier.Partie;
import thebindingofalice.Metier.niveau.carte.salle.Salle;

/**
 *
 * @author Arnaud
 */
public class SalleView implements Observeur{

    private Salle salle;

    public SalleView() {
        salle = Partie.get().getNiveauCourant().getSalleCourante();
        salle.Register(this);
        
    }   
    
    @Override
    public void Update(String message) {
        switch(message.toLowerCase())
        {
            case "loot" : InstanciateLoot(); break;
        }
    }

    private void InstanciateLoot() {
        
    }

    
    
    
    
}
