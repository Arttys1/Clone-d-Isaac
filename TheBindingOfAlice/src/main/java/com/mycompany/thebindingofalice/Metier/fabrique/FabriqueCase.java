package com.mycompany.thebindingofalice.Metier.fabrique;

import java.util.ArrayList;
import com.mycompany.thebindingofalice.Metier.fabrique.constructeurs.ConstructeurCase;
import com.mycompany.thebindingofalice.Metier.niveau.carte.Generateur.Case;
import com.mycompany.thebindingofalice.Metier.niveau.carte.Generateur.TypeCase;

/**
 * Fabrique abstraite, héritant de Fabrique, gérant la création des cases
 */
public class FabriqueCase extends Fabrique {  
    
    private ArrayList<ConstructeurCase> constructeurs = new ArrayList<ConstructeurCase>();

    public TypeCase[] Types() {
            throw new UnsupportedOperationException();
    }

    public Case Create(TypeCase type, int ligne, int colonne) {
            throw new UnsupportedOperationException();
    }
}