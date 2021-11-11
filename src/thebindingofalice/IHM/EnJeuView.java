package thebindingofalice.IHM;

import java.net.URL;
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
import thebindingofalice.Metier.niveau.Niveau;
import thebindingofalice.Metier.niveau.carte.Generateur.Case;


/**
 * FXML Controller class
 * Vue représentant la fenêtre de jeu.
 * @author Pascaline, Arnaud
 */
public class EnJeuView implements Initializable, Observeur {
    private final Joueur joueur = Partie.get().GetJoueur();
    private ControlleurJoueur controllerJoueur;      
    private final Partie partie = Partie.get();     //partie de jeu
    private ControlleurNiveau controlleurNiveau;    //controlleur du niveau
    private Niveau niveau;                          //niveau
    private ImageView imageJoueur;   
    @FXML
    private AnchorPane background;  //arrière plan
    @FXML
    private AnchorPane foreground;  //premier plan
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        niveau = partie.getNiveauCourant();
        controlleurNiveau = new ControlleurNiveau(niveau);
        controlleurNiveau.Register(this);
        controllerJoueur = new ControlleurJoueur(joueur);
        controllerJoueur.Register(this);  
        
        displaySalle();
        loadPlayer();
        boucleDeJeu();
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
                controllerJoueur.evoluer(Double.valueOf(1));
                System.err.println(Double.valueOf(pas));
            }            
        };
        animationTimer.start();
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
        foreground.getChildren().add(imageJoueur);
    }
    
    @Override
    public void Update(String message) {
        switch(message.toLowerCase())
        {
            case "joueur": moveSpriteJoueur(); break;
            case "salle" : displaySalle(); break;
            default: break;
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
    
    /**
     * Méthode permettant d'afficher la salle en court.
     */
    private void displaySalle()
    {  
        background.getChildren().clear();
        int size = 60;
        for (Case c : niveau.getSalleCourante().getCases()) {
            
            ImageView img = new ImageView(System.getProperty("user.dir")+"/src/thebindingofalice/Images/Salle/" + c.getSprite());
            img.setX(100 + c.getColonne() * size);
            img.setY(50 + c.getLigne() * size);
            img.setFitHeight(size);
            img.setFitWidth(size);
            background.getChildren().add(img);
        }
        
    }
}
