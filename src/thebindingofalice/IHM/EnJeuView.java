package thebindingofalice.IHM;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import thebindingofalice.Controller.ControlleurJoueur;
import thebindingofalice.Controller.Observeur;
import thebindingofalice.Metier.Coordonnee;
import thebindingofalice.Metier.Partie;
import thebindingofalice.Metier.joueur.DirectionDeplacement;
import thebindingofalice.Metier.joueur.Joueur;
import thebindingofalice.Controller.ControlleurNiveau;
import thebindingofalice.IHM.view.JoueurView;
import thebindingofalice.IHM.view.TirAllieView;
import thebindingofalice.IHM.view.View;
import thebindingofalice.Metier.niveau.Niveau;
import thebindingofalice.Metier.niveau.carte.Generateur.Case;
import thebindingofalice.Metier.projectiles.DirectionTir;
import thebindingofalice.Metier.projectiles.ProjectileAllie;



/**
 * FXML Controller class
 * Vue représentant la fenêtre de jeu.
 * @author Pascaline, Arnaud
 */
public class EnJeuView implements Initializable {  
    private final Partie partie = Partie.get();     //partie de jeu
    private JoueurView joueurView;    
    private ArrayList<View> objAAfficher;
    boolean goNorth, goSouth, goEast, goWest, shootNorth, shootSouth, shootEast, shootWest;
    /**private AnimationTimer t = new AnimationTimer() {
            @Override
            public void handle(long now) {
 
                if (goNorth) joueurView.bouger(DirectionDeplacement.HAUT);
                if (goSouth) joueurView.bouger(DirectionDeplacement.BAS);
                if (goEast)  joueurView.bouger(DirectionDeplacement.GAUCHE);
                if (goWest)  joueurView.bouger(DirectionDeplacement.DROITE);
                
            }
        };
    **/
    @FXML
    private AnchorPane background;  //arrière plan
    @FXML
    private AnchorPane foreground;  //premier plan
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        objAAfficher = new ArrayList<>();
        joueurView = new JoueurView();               
        addView(joueurView);
        
        displaySalle();
        boucleDeJeu();
    }
    
    private void addView(View v)
    {
        objAAfficher.add(v);
        foreground.getChildren().add(v);        
    }
    
    /**
     * Méthode représentant la boucle de jeu.
     * Ce n'est pour l'instant qu'une esquisse mais c'est un début.
     */
    private void boucleDeJeu() {        
        AnimationTimer animationTimer = new AnimationTimer()
        {
            @Override
            public void handle(long pas) {
                //for some obscurs reasons pas must be equal to 1
                
                if (goNorth) joueurView.bouger(DirectionDeplacement.HAUT);
                if (goSouth) joueurView.bouger(DirectionDeplacement.BAS);
                if (goEast)  joueurView.bouger(DirectionDeplacement.DROITE);
                if (goWest)  joueurView.bouger(DirectionDeplacement.GAUCHE);
                
                if (shootNorth && !shootSouth && !shootEast && !shootWest){
                    joueurView.tirer(DirectionTir.HAUT);
                    addView(new TirAllieView((ProjectileAllie)Partie.get().getNiveauCourant().getSalleCourante().getEvoluables().get(Partie.get().getNiveauCourant().getSalleCourante().getEvoluables().size() - 1)));
                }
                if (shootSouth && !shootNorth && !shootEast && !shootWest){
                    joueurView.tirer(DirectionTir.BAS);
                    addView(new TirAllieView((ProjectileAllie)Partie.get().getNiveauCourant().getSalleCourante().getEvoluables().get(Partie.get().getNiveauCourant().getSalleCourante().getEvoluables().size() - 1)));
                }
                if (shootEast && !shootSouth && !shootNorth && !shootWest){
                    joueurView.tirer(DirectionTir.DROITE);
                    addView(new TirAllieView((ProjectileAllie)Partie.get().getNiveauCourant().getSalleCourante().getEvoluables().get(Partie.get().getNiveauCourant().getSalleCourante().getEvoluables().size() - 1)));
                }
                if (shootWest && !shootSouth && !shootEast && !shootNorth){
                    joueurView.tirer(DirectionTir.GAUCHE);
                    addView(new TirAllieView((ProjectileAllie)Partie.get().getNiveauCourant().getSalleCourante().getEvoluables().get(Partie.get().getNiveauCourant().getSalleCourante().getEvoluables().size() - 1)));
                }
                
                partie.CheckCollides();
                partie.Evoluer(1);  
            }            
        };
        animationTimer.start();
    }
    
   
    @FXML
    public void handleOnKeyPressed(KeyEvent event)
    {
        switch(event.getCode())
        {
            //joueurView.bouger(DirectionDeplacement.HAUT);
                
            //joueurView.tirer(DirectionTir.HAUT);
            //addView(new TirAllieView((ProjectileAllie)Partie.get().getNiveauCourant().getSalleCourante().getEvoluables().get(Partie.get().getNiveauCourant().getSalleCourante().getEvoluables().size() - 1)));
            
            //joueurView.sArreter();
            
            case Z: goNorth = true; break;
            case S: goSouth = true; break;
            case D: goEast = true; break;
            case Q: goWest = true; break;
            case UP: shootNorth = true; break;
            case DOWN: shootSouth = true; break;
            case LEFT: shootWest = true; break;
            case RIGHT: shootEast = true; break;
            default : break;
        }
    }
    
    @FXML
    public void handleKeyRelease(KeyEvent evt)
    {
        switch(evt.getCode())
        {
            case Z: goNorth = false; joueurView.sArreter(); break;
            case S: goSouth = false; joueurView.sArreter(); break;
            case D: goEast = false; joueurView.sArreter(); break;
            case Q: goWest = false; joueurView.sArreter(); break;
            case UP: shootNorth = false; break;
            case DOWN: shootSouth = false; break;
            case LEFT: shootWest = false; break;
            case RIGHT: shootEast = false; break;
            default : break;
        }
        
    }
    
    
     
    
    
    /**
     * Méthode permettant d'afficher la salle en court.
     */
    private void displaySalle()
    {  
        background.getChildren().clear();
        int size = 60;
        for (Case c : partie.getNiveauCourant().getSalleCourante().getCases()) {
            
            ImageView img = new ImageView(System.getProperty("user.dir")+"\\src\\thebindingofalice\\Images\\Salle\\" + c.getSprite());
            img.setX(100 + c.getColonne() * size);
            img.setY(50 + c.getLigne() * size);
            img.setFitHeight(size);
            img.setFitWidth(size);
            background.getChildren().add(img);
        }
        
    }
}
