package com.mycompany.thebindingofalice.Metier.fabrique;
import java.util.ArrayList;

/**
 * Classe Multiton, gérant toutes les instances des fabriques abstraite.
 */
public abstract class Fabrique {
	public ArrayList<Fabrique> instances = new ArrayList<Fabrique>();
	public Fabrique unnamed_Fabrique_;

	public static void register(TypeFabrique type) {
		throw new UnsupportedOperationException();
	}

	public static Fabrique get(TypeFabrique key) {
		throw new UnsupportedOperationException();
	}
}