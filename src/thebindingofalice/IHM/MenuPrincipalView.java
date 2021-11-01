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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import thebindingofalice.Main;

/**
 * FXML Controller class
 *
 * @author Pascaline
 */
public class MenuPrincipalView implements Initializable {

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
            Main.getPrimaryStage().setScene(new Scene(root));
        } catch (IOException ex) {
            Logger.getLogger(MenuPrincipalView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    public void MCQuitter(MouseEvent event){
        Main.getPrimaryStage().close();
    }
}