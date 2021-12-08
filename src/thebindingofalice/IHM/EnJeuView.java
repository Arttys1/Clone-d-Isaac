package thebindingofalice.IHM;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import thebindingofalice.IHM.view.ChauveSourisView;
import thebindingofalice.IHM.view.CoeurView;
import thebindingofalice.IHM.view.HitboxView;
import thebindingofalice.IHM.view.JoueurView;
import thebindingofalice.IHM.view.MurView;
import thebindingofalice.IHM.view.RocherView;
import thebindingofalice.Metier.Partie;
import thebindingofalice.Metier.joueur.DirectionDeplacement;
import thebindingofalice.Metier.Coordonnee;
import thebindingofalice.Metier.ennemis.volant.ChauveSouris;
import thebindingofalice.Metier.niveau.carte.Generateur.Case;
import thebindingofalice.Metier.niveau.carte.Generateur.CaseMur;
import thebindingofalice.Metier.niveau.carte.Generateur.TypeCase;
import thebindingofalice.Metier.objet.obstacle.Rocher;
import thebindingofalice.Metier.objet.ramassable.Coeur;
import thebindingofalice.Metier.projectiles.DirectionTir;


/**
 * FXML Controller class
 * Vue représentant la fenêtre de jeu.
 * @author Pascaline, Arnaud
 */
public class EnJeuView implements Initializable{  
    private final Partie partie = Partie.get();     //partie de jeu
    private JoueurView joueurView;    
    private final GamePane gamePane = GamePane.get();
    @FXML
    private AnchorPane background;  //arrière plan
    @FXML
    private AnchorPane root;  //racine
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        instancierRocher();
        joueurView = new JoueurView();  
        root.getChildren().add(gamePane.getForeground());
        GamePane.get().addView(joueurView);
        
        HitboxView hitboxJoueur = new HitboxView(Partie.get().GetJoueur().getHitbox());
        //ligne à commenter si on veut rendre l'hitbox du joueur transparente
        hitboxJoueur.setStroke(Color.RED);
        //ajoute la hitbox du joueur sur l'affichage
        GamePane.get().addView(hitboxJoueur);
        
        //Affiche la salle avec les murs et les portes
        displaySalle();
        
        //Créer des coeurs dans la salle A supprimer plus tard
        instancierDesCoeurs();  
        
        //Créer des ennemis dans la salle A supprimer plus tard
        instancierEnnemis();  
        
        //Lance la boucle du jeu
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
                
                //Fait évoluer tout les éléments de liste d'évoluable de la partie
                partie.Evoluer(1);
                //Vérifie si chacun des éléments collisionable est en collision
                partie.CheckCollides();
            }            
        };
        animationTimer.start();
    }
   
    @FXML
    /**
     * Handler des appuies sur clavier 
     */
    public void handleOnKeyPressed(KeyEvent event)
    {
        switch(event.getCode())
        {
            case Z:  joueurView.bouger(DirectionDeplacement.HAUT); break;
            case S:  joueurView.bouger(DirectionDeplacement.BAS); break;
            case Q:  joueurView.bouger(DirectionDeplacement.GAUCHE); break;
            case D:  joueurView.bouger(DirectionDeplacement.DROITE); break;
            case I:  joueurView.tirer(DirectionTir.HAUT); break;
            case K:  joueurView.tirer(DirectionTir.BAS); break;
            case J:  joueurView.tirer(DirectionTir.GAUCHE); break;
            case L:  joueurView.tirer(DirectionTir.DROITE); break;
            default : break;
        }
    }
       
    @FXML
    /**
     * Handler de la relâche des touches
     */
    public void handleKeyRelease(KeyEvent evt)
    {
        switch(evt.getCode())
        {
            case Z:  joueurView.sArreter(DirectionDeplacement.HAUT); break;
            case S:  joueurView.sArreter(DirectionDeplacement.BAS); break;
            case Q:  joueurView.sArreter(DirectionDeplacement.GAUCHE); break;
            case D:  joueurView.sArreter(DirectionDeplacement.DROITE); break;
            case I:  joueurView.stopTirer(DirectionTir.HAUT); break;
            case K:  joueurView.stopTirer(DirectionTir.BAS); break;
            case J:  joueurView.stopTirer(DirectionTir.GAUCHE); break;
            case L:  joueurView.stopTirer(DirectionTir.DROITE); break;
            default : break;
        }
    }
    
    /**
     * Méthode qui provisoire servant uniqement à montrer l'affichage de trois coeurs
     */
    private void instancierDesCoeurs() {
        for (int i = 0; i < 3; i++) {
            Coordonnee coor = new Coordonnee(200 + i * 100 , 500);
            Coeur c = new Coeur(coor);
            CoeurView coeurView = new CoeurView(c);  
            
            GamePane.get().addView(coeurView);
        }
    }
    
    private void instancierRocher() {
        RocherView rocher = new RocherView(new Rocher(new Coordonnee(500, 200)));
        GamePane.get().addView(rocher);
    }

    /**
     * Méthode provisoire servant uniqement à montrer l'affichage d'ennemis
     */
    private void instancierEnnemis(){
        for (int i = 0; i < 3; i++) {
            Coordonnee coord = new Coordonnee(200 + i * 100 , 300);
            ChauveSouris cS = new ChauveSouris(coord);
            ChauveSourisView csv = new ChauveSourisView(cS);
            GamePane.get().addView(csv);
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
            ImageView img = new ImageView(System.getProperty("user.dir") + "/src/thebindingofalice/Images/Salle/" + c.getSprite());
            int x = 100 + c.getColonne() * size;
            int y = 20 + c.getLigne() * size;
            img.setX(x);
            img.setY(y);
            img.setFitHeight(size);
            img.setFitWidth(size);
            background.getChildren().add(img);
            if (c.getType() == TypeCase.MUR) {
                MurView mur = new MurView(new Coordonnee(x, y));
                GamePane.get().addView(mur);
            }
        }
    }  

}
