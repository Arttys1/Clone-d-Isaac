package com.mycompany.thebindingofalice.Metier;

import com.mycompany.thebindingofalice.Metier.niveau.carte.salle.Salle;

/**
 * Classe abstraite, représentant les objets pouvant evoluer au cours du temps.
 */
public abstract class Evoluable {
	private Salle unnamed_Salle_;
	private Coordonnee coordonnee;

	/**
	 * Méthode appelé à chaque frame du jeu. Le paramètre pas représente le pas de temps entre deux appel de la méthode.
	 */
	public abstract void evoluer(long pas);
}