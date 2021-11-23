/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thebindingofalice.IHM;

import java.util.ArrayList;
import javafx.scene.layout.AnchorPane;
import thebindingofalice.IHM.view.View;

/**
 *
 * @author Noa BARBOSA
 */
public class GamePane{
    private static GamePane instance = null;
    private final AnchorPane foreground;
    
    private GamePane(){ 
        foreground= new AnchorPane();
    }
    
    public static GamePane get() {
        if (instance == null) {
            instance = new GamePane();
        }
        return instance;
    }

    public void addView(View v) {
        foreground.getChildren().add(v);
    }
    
    public void removeView(View v) {
        foreground.getChildren().remove(v);
    }

    public AnchorPane getForeground(){
         return foreground;
     }
}
