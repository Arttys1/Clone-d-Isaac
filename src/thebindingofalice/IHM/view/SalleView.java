/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thebindingofalice.IHM.view;

import thebindingofalice.Controller.Observeur;
import thebindingofalice.IHM.GamePane;
import thebindingofalice.Metier.Coordonnee;
import thebindingofalice.Metier.Partie;
import thebindingofalice.Metier.ennemis.volant.ChauveSouris;
import thebindingofalice.Metier.niveau.carte.salle.Salle;
import thebindingofalice.Metier.objet.ramassable.Cle;

/**
 *
 * @author Arnaud
 */
public class SalleView implements Observeur{

    private Salle salle;

    public SalleView() {
        salle = Partie.get().getNiveauCourant().getSalleCourante();
        salle.Register(this);
        instancierEnnemis();
    }   
    
    @Override
    public void Update(String message) {
        switch(message.toLowerCase())
        {
            case "loot" : InstanciateLoot(); break;
            case "destroy" : ennemiMort(); break;
        }
    }

    private void InstanciateLoot() {
        CléView cle = new CléView(new Cle(new Coordonnee(200, 200)));
        GamePane.get().addView(cle);
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
            salle.addEnnemi(cS);
            cS.Register(this);
        }
    }

    private void ennemiMort() {
        salle.removeOne();
    }
    
    
    
}
