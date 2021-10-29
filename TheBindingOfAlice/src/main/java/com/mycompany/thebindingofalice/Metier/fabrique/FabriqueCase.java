package com.mycompany.thebindingofalice.Metier.fabrique;

import com.mycompany.thebindingofalice.Metier.carte.Generateur.TypeCase;
import java.util.ArrayList;
import com.mycompany.thebindingofalice.Metier.fabrique.constructeurs.ConstructeurCase;
import com.mycompany.thebindingofalice.Metier.niveau.carte.Generateur.Case;

/**
 * Fabrique abstraite, héritant de Fabrique, gérant la création des cases
 */
public class FabriqueCase extends Fabrique {  
    
    public ArrayList<ConstructeurCase> constructeurs = new ArrayList<ConstructeurCase>();

    public TypeCase[] Types() {
            throw new UnsupportedOperationException();
    }

    public Case Create(TypeCase type, int ligne, int colonne) {
            throw new UnsupportedOperationException();
    }
}