package thebindingofalice.IHM;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import thebindingofalice.Controller.ControlleurNiveau;
import thebindingofalice.Controller.Observeur;
import thebindingofalice.Metier.Partie;
import thebindingofalice.Metier.niveau.Niveau;
import thebindingofalice.Metier.niveau.carte.Generateur.Case;

/**
 * FXML Controller class
 * Vue représentant la fenêtre de jeu.
 * @author Pascaline, Arnaud
 */
public class EnJeuView implements Initializable, Observeur{
    
    private final Partie partie = Partie.get();     //partie de jeu
    private ControlleurNiveau controlleurNiveau;    //controlleur du niveau
    private Niveau niveau;                          //niveau

    @FXML
    private AnchorPane anchorPane;  //objet qui dispose les objets à afficher
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {  
        niveau = partie.getNiveauCourant();
        controlleurNiveau = new ControlleurNiveau(niveau);
        displaySalle();
    }    
    
    /**
     * Méthode permettant d'afficher la salle en court.
     */
    private void displaySalle()
    {  
        anchorPane.getChildren().clear();
        int size = 60;
        for (Case c : niveau.getSalleCourante().getCases()) {
            
            ImageView img = new ImageView("C:/Users/Arnaud/Desktop/Cours/Semestre 3/Projet Tutoré/TheBindingOfAlice/src/thebindingofalice/Images/Salle/" + c.getSprite());
            img.setX(100 + c.getColonne() * size);
            img.setY(50 + c.getLigne() * size);
            img.setFitHeight(size);
            img.setFitWidth(size);
            anchorPane.getChildren().add(img);
        }
        
    }

    @Override
    public void Update(String message) {
        switch(message.toLowerCase())
        {
            case "salle" : displaySalle(); break;
            default: break;
        }
    }
    
}
