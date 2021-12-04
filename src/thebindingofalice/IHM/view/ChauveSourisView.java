/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thebindingofalice.IHM.view;

import javafx.scene.paint.Color;
import thebindingofalice.Controller.ControlleurChauveSouris;
import thebindingofalice.Controller.Observeur;
import thebindingofalice.IHM.GamePane;
import thebindingofalice.Metier.Partie;
import thebindingofalice.Metier.ennemis.volant.ChauveSouris;

/**
 *
 * @author Pascaline
 */
public class ChauveSourisView extends View implements Observeur{
    
    //Joueur à afficher
    private final ChauveSouris chauveSouris;
    //Controlleur du joueur
    private final ControlleurChauveSouris controlleurChauveSouris;
    //Vue de la hitbox du joueur à afficher
    private final HitboxView hitboxChauveSouris;

    public ChauveSourisView(ChauveSouris cS) {
        super(System.getProperty("user.dir") + "/src/thebindingofalice/Images/Sprites/Ennemis/chauveSouris.png");
        chauveSouris = cS;
        chauveSouris.Register(this);
        
        hitboxChauveSouris = new HitboxView(cS.getHitbox());
         //change la couleur du contour de la hitbox (à commenter pour laisser transparent)
        hitboxChauveSouris.setStroke(Color.RED);
        //ajoute la hitbox de la chauvesouris sur l'affichage
        GamePane.get().addView(hitboxChauveSouris);
        
        //ajoute la chauvesouris à la liste des evoluable et des collisions de la partie
        Partie.get().getNiveauCourant().getSalleCourante().AddEvoluable(chauveSouris);
        Partie.get().addICollision(chauveSouris);  
        
        //Affiche le coeur au bon endroit
        translate(chauveSouris.getCoordonnee().getX(),chauveSouris.getCoordonnee().getY());
        
        this.controlleurChauveSouris = new ControlleurChauveSouris(chauveSouris);
        
    }

    @Override
    public void Update(String message) {
        
    }
    
    
}
