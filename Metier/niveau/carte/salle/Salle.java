package thebindingofalice.Metier.niveau.carte.salle;

import java.util.ArrayList;
import thebindingofalice.Controller.Observable;
import thebindingofalice.Metier.Evoluable;
import thebindingofalice.Metier.ennemis.Ennemi;
import thebindingofalice.Metier.niveau.carte.Generateur.Case;

/**
 * Classe abstraite représentant les salles. Elle est composé de cases.
 * @author Arnaud
 */
public abstract class Salle extends Observable{
    private final ArrayList<Case> cases;            //Liste des cases composant la salle
    private final ArrayList<Porte> portes;          //Liste des portes de la salle
    private final ArrayList<Evoluable> evoluables;  //Liste des evoluables présent dans la salle
    private final ArrayList<Ennemi> ennemies;

    public ArrayList<Evoluable> getEvoluables() {
        return evoluables;
    }

    public Salle() {
        this.evoluables = new ArrayList<>();
        this.portes = new ArrayList<>();
        this.cases = new ArrayList<>();
        this.ennemies = new ArrayList<>();
    }

    public void addEnnemi(Ennemi e) { ennemies.add(e); }
    
    public void removeEnnemi(Ennemi e) {
        ennemies.remove(e); 
        if(ennemies.isEmpty())
        {
            Notify("loot");
        }
    }
    
    /**
     * Méthode permettant d'ajouter un évoluable à la salle.
     *
     * @param e évoluable
     */
    public void AddEvoluable(Evoluable e) {
        evoluables.add(e);
    }

    /**
     * Méthode permettant de supprimer un évoluable de la salle.
     *
     * @param e évoluable que l'on souhaite supprimer
     * @return true si l'élément était présent dans la liste, false sinon
     */
    public boolean RemoveEvoluable(Evoluable e) {
        return evoluables.remove(e);
    }

    /**
     * Méthode permettant de retourner une copie des cases de la salle.
     *
     * @return une copie des cases de la salle.
     */
    public ArrayList<Case> getCases() {
        return new ArrayList<>(cases);
    }

    /**
     * Méthode permettant d'ajouter une case à la salle.
     *
     * @param c la case que l'on souhaite ajouter.
     */
    protected void AddCase(Case c) {
        cases.add(c);
    }

    /**
     * Accesseur du type de la salle.
     *
     * @return le type de la salle
     */
    public abstract TypeSalle getType();

    /**
     * Accesseur de la taille de coté de la salle
     *
     * @return la taille de coté de la salle
     */
    public static int getTailleCote() {
        return 11;
    }

    public void evoluer(double pas) {
        for(int i = 0; i < evoluables.size(); i++)
        {
            evoluables.get(i).evoluer(pas);
        }
    }

    /**
     * Méthode appelé lors d'un game over,
     * vide la liste des ennemies et celle des evoluables
     */
    public void PartiePerdu() {
        this.ennemies.clear();
        this.evoluables.clear();
    }
               
}