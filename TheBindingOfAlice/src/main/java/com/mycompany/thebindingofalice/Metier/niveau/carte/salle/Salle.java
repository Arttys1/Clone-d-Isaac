package com.mycompany.thebindingofalice.Metier.niveau.carte.salle;
import java.util.ArrayList;
import com.mycompany.thebindingofalice.Metier.Evoluable;
import com.mycompany.thebindingofalice.Metier.joueur.Joueur;
import com.mycompany.thebindingofalice.Metier.niveau.carte.Carte;
import com.mycompany.thebindingofalice.Metier.niveau.carte.Generateur.Case;
import com.mycompany.thebindingofalice.Metier.niveau.carte.Generateur.CaseMur;

/**
 * Classe abstraite représentant les salles. Elle est composé de cases
 */
public abstract class Salle {
	private TypeSalle type;
	private CaseMur[] murs;
	private Joueur joueur;
	private Carte carte;
	private ArrayList<Case> cases = new ArrayList<Case>();
	private ArrayList<Porte> portes = new ArrayList<Porte>();
	private ArrayList<Evoluable> evoluables = new ArrayList<Evoluable>();

	public Salle(TypeSalle type) {
		throw new UnsupportedOperationException();
	}

	public void AddEvoluable(Evoluable e) {
		throw new UnsupportedOperationException();
	}

	public boolean RemoveEvoluable(Evoluable e) {
		throw new UnsupportedOperationException();
	}

	public Case[] getCases() {
		throw new UnsupportedOperationException();
	}
}