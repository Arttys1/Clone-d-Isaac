/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thebindingofalice.IHM;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import thebindingofalice.Main;
import thebindingofalice.Metier.Partie;
import thebindingofalice.Metier.joueur.DirectionDeplacement;

/**
 * FXML Controller class
 *
 * @author Pascaline
 */
public class MenuPrincipalView implements Initializable {

    private boolean goNorth, goSouth, goWest, goEast;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    public void MCJouer(MouseEvent event){
        
        try {
            
            Parent root = FXMLLoader.load(getClass().getResource("EnJeu.fxml"));
            //Création d'un groupe d'objet à partir du parent
            Group group = new Group(root);
            //Ajout du joueur dans le groupe d'objet
            group.getChildren().add(Partie.get().GetJoueur());
            
            Scene scene = new Scene(group);
            
            //Mis en place du "controlleur d'appuie de touche sur le clavier pour le déplacement
            /**Version déplacement saccadée 
            scene.setOnKeyPressed((KeyEvent evt) -> {
            switch(evt.getCode()) {
                
                case Z:
                    Partie.get().GetJoueur().Bouger(DirectionDeplacement.HAUT);
                    break;
                case S:
                    Partie.get().GetJoueur().Bouger(DirectionDeplacement.BAS);
                    break;
                case Q:
                    Partie.get().GetJoueur().Bouger(DirectionDeplacement.GAUCHE);
                    break;
                case D:
                    Partie.get().GetJoueur().Bouger(DirectionDeplacement.DROITE);
                    break;
                default:
                    break;
            }
            });
            **/
            
            //Version non saccadée
            scene.setOnKeyPressed((KeyEvent evt) ->  {
                switch (evt.getCode()) {
                    case Z:    goNorth = true; break;
                    case S:  goSouth = true; break;
                    case Q:  goWest  = true; break;
                    case D: goEast  = true; break; 
                    //noa qui fait mumuse avec la vitesse 
                    case W : Partie.get().GetJoueur().setVitesse((float) (Partie.get().GetJoueur().getVitesse()+0.1));System.out.println(Partie.get().GetJoueur().getVitesse());break;
                    //tout pareil 
                    case X : Partie.get().GetJoueur().setVitesse((float) (Partie.get().GetJoueur().getVitesse()-0.1));System.out.println(Partie.get().GetJoueur().getVitesse()); break;
                    //Remet le joueur au milieu
                    case R :Partie.get().GetJoueur().setTranslateX(480); Partie.get().GetJoueur().setTranslateY(270); break;
                }           
            });
            scene.setOnKeyReleased((KeyEvent evt) ->  {
                switch (evt.getCode()) {
                    case Z:    goNorth = false; break;
                    case S:  goSouth = false; break;
                    case Q:  goWest  = false; break;
                    case D: goEast  = false; break;
                }           
            });
            
              
                    
            Main.getPrimaryStage().setScene(scene);
            
            AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
 
                if (goNorth) Partie.get().GetJoueur().Bouger(DirectionDeplacement.HAUT);
                if (goSouth) Partie.get().GetJoueur().Bouger(DirectionDeplacement.BAS);
                if (goEast)  Partie.get().GetJoueur().Bouger(DirectionDeplacement.DROITE);
                if (goWest)  Partie.get().GetJoueur().Bouger(DirectionDeplacement.GAUCHE);
                            
            }
        };
        timer.start();
        
        } catch (IOException ex) {
            Logger.getLogger(MenuPrincipalView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    public void MCQuitter(MouseEvent event){
        Main.getPrimaryStage().close();
    }
}
