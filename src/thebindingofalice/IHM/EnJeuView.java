package thebindingofalice.IHM;

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
import thebindingofalice.IHM.view.View;
import thebindingofalice.Metier.niveau.Niveau;
import thebindingofalice.Metier.niveau.carte.Generateur.Case;


/**
 * FXML Controller class
 * Vue représentant la fenêtre de jeu.
 * @author Pascaline, Arnaud
 */
public class EnJeuView implements Initializable {  
    private final Partie partie = Partie.get();     //partie de jeu
    private JoueurView joueurView;    
    private ArrayList<View> objAAfficher;
    
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
            case Z: joueurView.bouger(DirectionDeplacement.HAUT); break;
            case S: joueurView.bouger(DirectionDeplacement.BAS); break;
            case D: joueurView.bouger(DirectionDeplacement.DROITE); break;
            case Q: joueurView.bouger(DirectionDeplacement.GAUCHE); break;
            default : break;
        }
    }
    
    @FXML
    public void handleKeyRelease(KeyEvent evt)
    {
        joueurView.sArreter();
    }
    
    /**
     * Méthode permettant d'afficher la salle en court.
     */
    private void displaySalle()
    {  
        background.getChildren().clear();
        int size = 60;
        for (Case c : partie.getNiveauCourant().getSalleCourante().getCases()) {
            
            ImageView img = new ImageView(System.getProperty("user.dir")+"/src/thebindingofalice/Images/Salle/" + c.getSprite());
            img.setX(100 + c.getColonne() * size);
            img.setY(50 + c.getLigne() * size);
            img.setFitHeight(size);
            img.setFitWidth(size);
            background.getChildren().add(img);
        }
        
    }
}
