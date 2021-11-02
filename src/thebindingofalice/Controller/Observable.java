package thebindingofalice.Controller;

import java.util.ArrayList;

/**
 * Classe abstraite représentant les observables qui peuvent notifier les oberseveurs d'un changement du model.
 * @author Arnaud
 */
public abstract class Observable {
    private final ArrayList<Observeur> obs;   //observable à avertir

    protected Observable() {
        obs = new ArrayList<>();
    }
    
    /**
     * Méthode permettant de s'enregistrer à ce controlleur. La vue sera averti en cas de chanement du model.
     * @param o Observeur à enregistrer.
     */
    public void Register(Observeur o){ obs.add(o); }
    
    /**
     * Méthode, appelé lors d'un changement du model, avertissant toutes les vues du changement.
     * @param message Destinataire du changement.
     */
    protected void Notify(String message)
    {
        for(Observeur o : obs)
        {
           o.Update(message);
        }
    }
}
