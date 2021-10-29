package com.mycompany.thebindingofalice.Metier.fabrique.constructeurs;

import com.mycompany.thebindingofalice.Metier.ennemis.Ennemi;

/**
 * Interface représentant les différents  Constructeur pour les types d'ennemis
 */
public interface ConstructeurEnnemi {

	public Ennemi Create();
}