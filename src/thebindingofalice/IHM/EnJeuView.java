/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thebindingofalice.IHM;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import thebindingofalice.Controller.ControlleurJoueur;
import thebindingofalice.Controller.Observeur;
import thebindingofalice.Metier.Coordonnee;
import thebindingofalice.Metier.Partie;
import thebindingofalice.Metier.joueur.DirectionDeplacement;
import thebindingofalice.Metier.joueur.Joueur;

/**
 * FXML Controller class
 *
 * @author Pascaline
 */
public class EnJeuView implements Initializable, Observeur {
    private final Joueur joueur = Partie.get().GetJoueur();
    private ControlleurJoueur controllerJoueur;
    private ImageView imageJoueur;  
    
    @FXML
    private AnchorPane anchorPane;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {        
        controllerJoueur = new ControlleurJoueur(joueur);
        controllerJoueur.Register(this);   
        loadPlayer();
        boucleDeJeu();
    }
    
    private void boucleDeJeu() {
        //TODO Boucle de jeu
    }

    private void moveSpriteJoueur()
    {
        Coordonnee coordonnee = joueur.getCoordonnee();
        double x = coordonnee.getX();
        double y = coordonnee.getY();
        System.out.println("x" + x + " | y" + y);
        imageJoueur.setTranslateX(x);
        imageJoueur.setTranslateY(y);
    }
    
    private void loadPlayer()
    {
        imageJoueur = new ImageView(System.getProperty("user.dir") + "/src/thebindingofalice/Images/Sprites/aliceFront.png");
        anchorPane.getChildren().add(imageJoueur);
    }
    
    @Override
    public void Update(String message) {
        switch(message.toLowerCase())
        {
            case "joueur": moveSpriteJoueur(); break;
        }
    }
   
    @FXML
    public void handleOnKeyPressed(KeyEvent event)
    {
        switch(event.getCode())
        {
            case Z: controllerJoueur.bouger(DirectionDeplacement.HAUT); break;
            case S: controllerJoueur.bouger(DirectionDeplacement.BAS); break;
            case D: controllerJoueur.bouger(DirectionDeplacement.DROITE); break;
            case Q: controllerJoueur.bouger(DirectionDeplacement.GAUCHE); break;
            default : break;
        }
    }
    
    @FXML
    public void handleKeyRelease(KeyEvent evt)
    {
        controllerJoueur.sArreter();
    }
}
