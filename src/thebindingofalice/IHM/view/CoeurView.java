/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thebindingofalice.IHM.view;

import thebindingofalice.Controller.Observeur;
import thebindingofalice.IHM.GamePane;
import thebindingofalice.Metier.Partie;
import thebindingofalice.Metier.objet.ramassable.Coeur;


/**
 *
 * @author Pascaline
 */
public class CoeurView  extends View implements Observeur{
    private final Coeur coeur;

    public CoeurView(Coeur c) {
        super(System.getProperty("user.dir") + "/src/thebindingofalice/Images/Sprites/coeur.png");
        this.coeur = c;
        coeur.Register(this);
        Partie.get().getNiveauCourant().getSalleCourante().AddEvoluable(coeur);
        Partie.get().addICollision(coeur);  
        
        //Affiche le coeur au bon endroit
        translate(coeur.getCoordonnee().getX(),coeur.getCoordonnee().getY());
    }

    @Override
    public void Update(String message) {
        if(message.toLowerCase().equals("heal"))
        {
            soigner();
        }
    }
    
    public void soigner(){           
        Partie.get().getNiveauCourant().getSalleCourante().RemoveEvoluable(coeur);
        Partie.get().RemoveICollision(coeur);
        GamePane.get().removeView(this);
    }
    
}
