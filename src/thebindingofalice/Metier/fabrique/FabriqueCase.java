package thebindingofalice.Metier.fabrique;

import java.util.HashMap;
import java.util.Set;
import thebindingofalice.Metier.fabrique.constructeurs.constructeurCase.ConstructeurCase;
import thebindingofalice.Metier.fabrique.constructeurs.constructeurCase.ConstructeurCaseMur;
import thebindingofalice.Metier.fabrique.constructeurs.constructeurCase.ConstructeurCaseSol;
import thebindingofalice.Metier.fabrique.constructeurs.constructeurCase.ConstructeurCaseVide;
import thebindingofalice.Metier.niveau.carte.Generateur.Case;
import thebindingofalice.Metier.niveau.carte.Generateur.TypeCase;

/**
 * Fabrique abstraite, héritant de Fabrique, gérant la création des cases
 * @author Arnaud
 */
public class FabriqueCase extends Fabrique {      
    private final HashMap<TypeCase, ConstructeurCase> constructeurs; //constructeurs de case

    public FabriqueCase() {
        this.constructeurs = new HashMap<>();
        constructeurs.put(TypeCase.MUR, new ConstructeurCaseMur());
        constructeurs.put(TypeCase.SOL, new ConstructeurCaseSol());
        constructeurs.put(TypeCase.VIDE, new ConstructeurCaseVide());
        Fabrique.register(TypeFabrique.CASE, this);
    }

    /**
     * Méthode renvoyant les types supportés par la fabrique
     * @return les types supportés par la fabrique
     */
    public Set<TypeCase> Types() {
            return constructeurs.keySet();
    }

    /**
     * Méthode permettant de creér un case
     * @param type le type de la case
     * @param ligne la ligne de la case
     * @param colonne la colonne de la case
     * @return la case ainsi créer
     */
    public Case Create(TypeCase type, int colonne, int ligne) {
        ConstructeurCase cons = constructeurs.get(type);
        return cons.Create(colonne, ligne);
    }
}