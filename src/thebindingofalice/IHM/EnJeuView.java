package thebindingofalice.IHM;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import thebindingofalice.IHM.view.CoeurHUDDroitView;
import thebindingofalice.IHM.view.CoeurHUDGaucheView;
import thebindingofalice.IHM.view.JoueurView;
import thebindingofalice.IHM.view.MurView;
import thebindingofalice.Metier.Partie;
import thebindingofalice.Metier.joueur.DirectionDeplacement;
import thebindingofalice.Metier.Coordonnee;
import thebindingofalice.Metier.niveau.carte.Generateur.Case;
import thebindingofalice.Metier.niveau.carte.Generateur.CaseMur;
import thebindingofalice.Metier.niveau.carte.Generateur.TypeCase;
import thebindingofalice.Metier.objet.HUD.CoeurHUDDroit;
import thebindingofalice.Metier.objet.HUD.CoeurHUDGauche;
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
        joueurView = new JoueurView();  
        root.getChildren().add(gamePane.getForeground());
        GamePane.get().addView(joueurView);
        
        
        displaySalle();
        InstanceVie();
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
                partie.Evoluer(1);
                partie.CheckCollides();
            }            
        };
        animationTimer.start();
    }
   
    @FXML
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
                MurView mur = new MurView(new Coordonnee(x, y), (CaseMur)c);
                GamePane.get().addView(mur);
            }
        }
    }
    
    private void InstanceVie() {
        float posx = 0;
        //float espaceEntreCoeur = 2.5f;
        float ligne = 20;
        int nbmaxvieLigne = 4;
        int vieActu = 0;
        for(int x = 0 ; x < this.partie.GetJoueur().getVie().size(); x++)
        {
            Coordonnee coord = new Coordonnee(posx,ligne);
            if(x % 2 == 0 || x == 0)
            {
                //Paire soit gauche
            //peut-etre faire le cas pour le 0
                CoeurHUDGauche cg = new CoeurHUDGauche(coord);
                CoeurHUDGaucheView CoeurGauche = new CoeurHUDGaucheView(cg);  
                GamePane.get().addView(CoeurGauche);
                posx += CoeurGauche.getImage().getWidth();
            }else
            {
                //Impaire soit droite
                CoeurHUDDroit cd = new CoeurHUDDroit(coord);
                CoeurHUDDroitView CoeurDroit = new CoeurHUDDroitView(cd);
                GamePane.get().addView(CoeurDroit); 
                posx += CoeurDroit.getImage().getWidth();
                vieActu +=1;
                if(vieActu == nbmaxvieLigne)
                {
                    ligne += CoeurDroit.getImage().getHeight();
                    posx = 0;
                }
            }
        
        }
    }

    

    
}
