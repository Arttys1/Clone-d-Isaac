package thebindingofalice.Metier.niveau.carte.Generateur;
/**
 * Classe abstraite représentant les cases qui composent les pièces.
 */
public abstract class Case {
	private final int ligne;
	private final int colonne;

	public Case(int colonne, int ligne) {
		this.ligne = ligne;
                this.colonne = colonne;
	}

        public int getLigne() { return ligne; }
        
        public int getColonne() { return colonne; }
        
	public abstract TypeCase getType();
        public abstract String getSprite();
}