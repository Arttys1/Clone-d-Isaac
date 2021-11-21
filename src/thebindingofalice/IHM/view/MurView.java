package thebindingofalice.IHM.view;

import thebindingofalice.Controller.Observeur;
import thebindingofalice.Metier.Coordonnee;
import thebindingofalice.Metier.Partie;
import thebindingofalice.Metier.niveau.carte.Generateur.CaseMur;
import thebindingofalice.Metier.objet.obstacle.Mur;

/**
 * Classe IHM représentant les obstacles "Mur"
 * @author Arnaud
 */
public class MurView extends View implements Observeur{
    private final Mur mur;
    
    public MurView(Coordonnee coordonnee, CaseMur caseMur) {
        super(System.getProperty("user.dir") + "/src/thebindingofalice/Images/Salle/mur.png");
        mur = new Mur(coordonnee, caseMur); 
        setFitHeight(60);
        setFitWidth(60);  
        translate(coordonnee.getX(), coordonnee.getY());              
        Partie partie = Partie.get();
        partie.addICollision(mur);
        partie.getNiveauCourant().getSalleCourante().AddEvoluable(mur);
    }
    
    @Override
    public void Update(String message) {
        if(message.equals("mur"))
        {
            
        }
    }

    public Mur getMur() {
        return mur;
    }
    
}
