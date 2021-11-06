package thebindingofalice.Metier.niveau.carte.Generateur;

/**
 * Classe, héritant de Case, représentant les murs
 */
public class CaseMur extends Case {

    public CaseMur(int ligne, int colonne) {
        super(ligne, colonne);
    }

    @Override
    public TypeCase getType() {
        return TypeCase.MUR;
    }
    
}