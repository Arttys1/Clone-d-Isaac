/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thebindingofalice.IHM.view;

import javafx.scene.paint.Color;
import thebindingofalice.Controller.ControlleurJoueur;
import thebindingofalice.Controller.Observeur;
import thebindingofalice.IHM.GamePane;
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
    //Joueur à afficher
    private final Joueur joueur;
    //Controlleur du joueur
    private final ControlleurJoueur controlleurJoueur;
    //Vue de la hitbox du joueur à afficher
    private final HitboxView hitboxJoueur;
    
    /**
     * Constructeur du joueur
     */
    public JoueurView() {
        //On passe en paramètre le sprite du joueur
        super(System.getProperty("user.dir") + "/src/thebindingofalice/Images/Sprites/aliceFront.png");
        joueur = Partie.get().GetJoueur();
        //Le joueur est observé par la vue
        joueur.Register(this); 
        controlleurJoueur = new ControlleurJoueur(joueur); 
        
        //Création de la vue de la hitbox du joueur
        hitboxJoueur = new HitboxView(Partie.get().GetJoueur().getHitbox());
        //ligne à commenter si on rendre l'hitbox du joueur transparente
        hitboxJoueur.setStroke(Color.RED);
        //La ligne ci-dessous rajoute la hitbox du joueur sur l'affichage
        GamePane.get().addView(hitboxJoueur);
        
        //Ajout du joueur à la liste des evoluables et des collisions
        Partie.get().getNiveauCourant().getSalleCourante().AddEvoluable(joueur);
        Partie.get().addICollision(joueur);
    }
    
    /**
     * Déplace le sprite du joueur
     */
    private void moveSpriteJoueur()
    {
        //Coordonnee du joueur au moment de l'appel de la méthode
        Coordonnee coordonnee = joueur.getCoordonnee();
        double x = coordonnee.getX();
        double y = coordonnee.getY();
        //Déplacement de sprite
        translate(x, y);
    }

    @Override
    public void Update(String message) {
        if(message.toLowerCase().equals("joueur"))
        {
            moveSpriteJoueur();
        }
    }
    
    /**
     * Appelle le controlleur pour demander au joueur de bouger
     * @param d dans la direction donnée
     */
    public void bouger(DirectionDeplacement d)
    {
        controlleurJoueur.bouger(d);
    }  
    
    /**
     * Appelle le controlleur pour demander au joueur d'arrêter de bouger 
     * @param d dans la direction donnée
     */
    public void sArreter(DirectionDeplacement d)
    {
        controlleurJoueur.sArreter(d);
    }

    /**
     * Appelle le controlleur pour demander au joueur de tirer 
     * @param d dans la direction donnée
     */
    public void tirer(DirectionTir d)
    {
        controlleurJoueur.tirer(d);        
    }
    
    /**
     * Appelle le controlleur pour demander au joueur d'arrêter de tirer 
     * @param d dans la direction donnée
     */
    public void stopTirer(DirectionTir d){
        controlleurJoueur.stopTirer(d);
    }
    
}
