package com.mycompany.thebindingofalice.Metier.fabrique;
import com.mycompany.thebindingofalice.Metier.ennemis.TypeEnnemi;
import com.mycompany.thebindingofalice.Metier.fabrique.constructeurs.ConstructeurEnnemi;
import java.util.ArrayList;

/**
 * Fabrique abstraite, héritant de Fabrique, gérant la création des ennemis
 */
public class FabriqueEnnemi extends Fabrique {
	public ArrayList<ConstructeurEnnemi> constructeurs = new ArrayList<ConstructeurEnnemi>();

	public TypeEnnemi[] Types() {
		throw new UnsupportedOperationException();
	}

	public void Create(TypeEnnemi type) {
		throw new UnsupportedOperationException();
	}
}