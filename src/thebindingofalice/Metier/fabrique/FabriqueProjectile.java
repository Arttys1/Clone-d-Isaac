package thebindingofalice.Metier.fabrique;
import thebindingofalice.Metier.niveau.carte.salle.TypePorte;
import thebindingofalice.Metier.projectiles.TypeProjectile;
import thebindingofalice.Metier.fabrique.constructeurs.ConstructeurProjectile;
import java.util.ArrayList;

/**
 * Fabrique abstraite, héritant de Fabrique, gérant la création des projectiles
 */
public class FabriqueProjectile extends Fabrique {
	private ArrayList<ConstructeurProjectile> constructeurs = new ArrayList<ConstructeurProjectile>();

	public TypeProjectile[] Types() {
		throw new UnsupportedOperationException();
	}

	public void Create(TypePorte type) {
		throw new UnsupportedOperationException();
	}
}