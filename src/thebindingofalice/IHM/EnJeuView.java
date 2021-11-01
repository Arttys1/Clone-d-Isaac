/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thebindingofalice.IHM;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import thebindingofalice.Controller.ControlleurNiveau;
import thebindingofalice.Controller.Observeur;
import thebindingofalice.Metier.niveau.Niveau;
import thebindingofalice.Metier.niveau.carte.Generateur.Case;
import thebindingofalice.Metier.niveau.carte.salle.Salle;
import thebindingofalice.Metier.niveau.carte.salle.SalleSimple;

/**
 * FXML Controller class
 *
 * @author Pascaline
 */
public class EnJeuView implements Initializable, Observeur{

    private ControlleurNiveau controlleurNiveau;
    private Niveau niveau;
    
    @FXML
    private AnchorPane anchorPane;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {  
        niveau = new Niveau();
        controlleurNiveau = new ControlleurNiveau(niveau);
        displaySalle();
    }    
    
    private void displaySalle()
    {  
        int size = 60;
        for (Case c : niveau.getSalleCourante().getCases()) {
            //Rectangle r = new Rectangle(200 + c.getColonne() * size, 50 + c.getLigne() * size, size, size);
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
