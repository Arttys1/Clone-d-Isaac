package com.mycompany.thebindingofalice.Metier.niveau.carte.Generateur;

import com.mycompany.thebindingofalice.Metier.niveau.carte.salle.Salle;

/**
 * Classe abstraite représentant les cases qui composent les pièces.
 */
public abstract class Case {
	private TypeCase type;
	private int ligne;
	private int colonne;
	private Salle salle;

	public Case(int ligne, int colonne) {
		throw new UnsupportedOperationException();
	}

	public void setType(TypeCase type) {
		this.type = type;
	}

	public TypeCase getType() {
		return this.type;
	}
}