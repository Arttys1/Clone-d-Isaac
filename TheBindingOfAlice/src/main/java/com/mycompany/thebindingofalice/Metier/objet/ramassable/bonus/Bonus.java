package com.mycompany.thebindingofalice.Metier.objet.ramassable.bonus;

import com.mycompany.thebindingofalice.Metier.objet.ramassable.ObjetRamassable;

/**
 * Classe abstraite, héritant de ObjetRamassable, représentant les bonus du jeu
 */
public abstract class Bonus extends ObjetRamassable {

	public abstract void effet();
}