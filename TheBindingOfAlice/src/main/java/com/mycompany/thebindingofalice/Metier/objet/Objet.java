package com.mycompany.thebindingofalice.Metier.objet;

import com.mycompany.thebindingofalice.Metier.Evoluable;
import com.mycompany.thebindingofalice.Metier.ICollision;

/**
 * Classe abstraite, héritant de Evoluable, représentant les objets au sols
 */
public abstract class Objet extends Evoluable implements ICollision {
	private TypeObjet type;

	public void setType(TypeObjet type) {
		this.type = type;
	}

	public TypeObjet getType() {
		return this.type;
	}
}