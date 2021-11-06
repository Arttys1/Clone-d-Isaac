package thebindingofalice.Metier.niveau.carte.Generateur;

/**
 * Classe, héritant de Case, représentant les murs
 * @author Arnaud
 */
public class CaseMur extends Case {

    public CaseMur(int colonne, int ligne) {
        super(colonne, ligne);
    }    

    @Override
    public TypeCase getType() {
        return TypeCase.MUR;
    }

    @Override
    public String getSprite() {
        return "caseMur.png";
    }
    
}