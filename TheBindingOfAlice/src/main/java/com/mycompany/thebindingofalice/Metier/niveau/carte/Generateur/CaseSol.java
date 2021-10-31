package com.mycompany.thebindingofalice.Metier.niveau.carte.Generateur;

/**
 * Classe, héritant de Case, représentant le sol
 */
public class CaseSol extends Case {

    public CaseSol(int ligne, int colonne) {
        super(ligne, colonne);
    }

    @Override
    public TypeCase getType() {
        return TypeCase.SOL;
    }
    
    
}