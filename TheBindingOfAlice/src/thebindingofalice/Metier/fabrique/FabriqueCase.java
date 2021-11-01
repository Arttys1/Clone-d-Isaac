package thebindingofalice.Metier.fabrique;

import java.util.ArrayList;
import thebindingofalice.Metier.fabrique.constructeurs.ConstructeurCase;
import thebindingofalice.Metier.niveau.carte.Generateur.Case;
import thebindingofalice.Metier.niveau.carte.Generateur.TypeCase;

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