package thebindingofalice.Metier.niveau.carte.Generateur;

/**
 * Classe, héritant de Case, représentant les cases de vide
 */
public class CaseVide extends Case {

    public CaseVide(int ligne, int colonne) {
        super(ligne, colonne);
    }

    @Override
    public TypeCase getType() {
        return TypeCase.VIDE;
    }
    
}