/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thebindingofalice.IHM.view;

import thebindingofalice.Controller.ControlleurJoueur;
import thebindingofalice.Controller.Observeur;
import thebindingofalice.Metier.Coordonnee;
import thebindingofalice.Metier.Partie;
import thebindingofalice.Metier.joueur.DirectionDeplacement;
import thebindingofalice.Metier.joueur.Joueur;
import thebindingofalice.Metier.projectiles.DirectionTir;

/**
 * Classe IHM représentant la vue du joueur.
 * @author Arnaud
 */
public class JoueurView extends View implements Observeur{
    private final Joueur joueur;
    private final ControlleurJoueur controlleurJoueur;
    
    public JoueurView() {
        super(System.getProperty("user.dir") + "/src/thebindingofalice/Images/Sprites/aliceFront.png");
        joueur = Partie.get().GetJoueur();
        joueur.Register(this); 
        controlleurJoueur = new ControlleurJoueur(joueur);        
        Partie.get().getNiveauCourant().getSalleCourante().AddEvoluable(joueur);
        Partie.get().addICollision(joueur);
    }
    
    private void moveSpriteJoueur()
    {
        Coordonnee coordonnee = joueur.getCoordonnee();
        double x = coordonnee.getX();
        double y = coordonnee.getY();
        //System.out.println("x" + x + " | y" + y);
        translate(x, y);
    }

    @Override
    public void Update(String message) {
        if(message.toLowerCase().equals("joueur"))
        {
            moveSpriteJoueur();
        }
    }
    
    public void bouger(DirectionDeplacement d)
    {
        controlleurJoueur.bouger(d);
    }  

    public TirAllieView tirer(DirectionTir d)
    {
        return controlleurJoueur.tirer(d);        
    }
  
    public void sArreter(DirectionDeplacement d)
    {
        controlleurJoueur.sArreter(d);
    }
    
}
