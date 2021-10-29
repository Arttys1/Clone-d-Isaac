package com.mycompany.thebindingofalice.Metier.fabrique;
import com.mycompany.thebindingofalice.Metier.niveau.carte.salle.TypePorte;
import com.mycompany.thebindingofalice.Metier.fabrique.constructeurs.ConctructeurPorte;
import java.util.ArrayList;

/**
 * Fabrique abstraite, héritant de Fabrique, gérant la création des portes
 */
public class FabriquePorte extends Fabrique {
	public ArrayList<ConctructeurPorte> constructeurs = new ArrayList<ConctructeurPorte>();

	public TypePorte[] Types() {
		throw new UnsupportedOperationException();
	}

	public void Create(TypePorte type) {
		throw new UnsupportedOperationException();
	}
}