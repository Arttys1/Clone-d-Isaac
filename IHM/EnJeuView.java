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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import thebindingofalice.Controller.Observeur;
import thebindingofalice.IHM.view.ChauveSourisView;
import thebindingofalice.IHM.view.CoeurView;
import thebindingofalice.IHM.view.HitboxView;
import thebindingofalice.IHM.view.JoueurView;
import thebindingofalice.IHM.view.MurView;
import thebindingofalice.IHM.view.RocherView;
import thebindingofalice.Main;
import thebindingofalice.Metier.Partie;
import thebindingofalice.Metier.joueur.DirectionDeplacement;
import thebindingofalice.Metier.Coordonnee;
import thebindingofalice.Metier.ennemis.volant.ChauveSouris;
import thebindingofalice.Metier.niveau.carte.Generateur.Case;
import thebindingofalice.Metier.niveau.carte.Generateur.TypeCase;
import thebindingofalice.Metier.objet.obstacle.Rocher;
import thebindingofalice.Metier.objet.ramassable.Coeur;
import thebindingofalice.Metier.projectiles.DirectionTir;


/**
 * FXML Controller class
 * Vue représentant la fenêtre de jeu.
 * La vue implémente observeur pour voir les modifications du métier
 * au final cette classe correspond à la salleView j'ai l'impression
 * @author Pascaline, Arnaud
 */
public class EnJeuView implements Observeur, Initializable{  
    private Partie partie = Partie.get();     //partie de jeu
    private JoueurView joueurView;    
    private final GamePane gamePane = GamePane.get();
    @FXML
    private AnchorPane background;  //arrière plan
    @FXML
    private AnchorPane root;  //racine
    private HitboxView hitboxJoueur;
    AnimationTimer animationTimer;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Partie.get().GetJoueur().Register(this);
        instancierRocher();
        joueurView = new JoueurView();  
        root.getChildren().add(gamePane.getForeground());
        
        GamePane.get().addView(joueurView);
        
        hitboxJoueur = new HitboxView(Partie.get().GetJoueur().getHitbox());
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
        animationTimer = new AnimationTimer()
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
            Coordonnee coord = new Coordonnee(200 + i * 200 , 300);
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

    @FXML
    /**
     * Lance le menu de game over (pour l'instant quasi identique au menu principal
     * à modifier par les gens qui vont des trucs jolis et tout
     */
    public void AffMenuGameOver(){
        try { 
            Parent root = FXMLLoader.load(getClass().getResource("MenuGameOver.fxml"));
            Stage stage = Main.getPrimaryStage();
            stage.setX(200);
            stage.setY(1);
            stage.setScene(new Scene(root, 800.0, 453.0));
            root.requestFocus(); //I don't know why but this is necessary to keep event working
        } catch (IOException ex) {
            Logger.getLogger(MenuPrincipalView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * La vue est un observeur d'un peu tout
     * @param message 
     */
    @Override
    public void Update(String message) {
        //Si on reçoit le message de la mort du joueur
        if(message.toLowerCase().equals("mortjoueur"))
        {           
            Partie.get().PartiePerdu(); //on clear la liste des collisionables, des ennemis et des evoluables (appelle sur le métier depuis la vue à changer plus tard)
            
            GamePane.get().getForeground().getChildren().clear(); //on clear la liste des vues affichée
            this.animationTimer.stop(); //on stop la boucle de jeu 
            AffMenuGameOver(); // on affiche le menu de game over
        }
    }

}
