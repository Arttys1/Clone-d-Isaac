package thebindingofalice.Metier.niveau.carte.salle;
import java.util.ArrayList;
import thebindingofalice.Metier.Evoluable;
import thebindingofalice.Metier.joueur.Joueur;
import thebindingofalice.Metier.niveau.carte.Carte;
import thebindingofalice.Metier.niveau.carte.Generateur.Case;
import thebindingofalice.Metier.niveau.carte.Generateur.CaseMur;
import thebindingofalice.Metier.niveau.carte.Generateur.CaseSol;

/**
 * Classe abstraite représentant les salles. Elle est composé de cases
 */
public abstract class Salle {
	private final ArrayList<Case> cases;
	private final ArrayList<Porte> portes;
	private final ArrayList<Evoluable> evoluables;

	public Salle() {
            this.evoluables = new ArrayList<>();
            this.portes = new ArrayList<>();
            this.cases = new ArrayList<>();            
	}

	public void AddEvoluable(Evoluable e) {
		evoluables.add(e);
	}

	public boolean RemoveEvoluable(Evoluable e) {
		return evoluables.remove(e);
	}

	public ArrayList<Case> getCases() {
            return new ArrayList<>(cases);          
	}
        
        protected void AddCase(Case c)
        {
            cases.add(c);
        }
        
        public abstract TypeSalle getType();
        
        protected int getTailleCote(){ return 10; }
               
}