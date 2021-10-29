package com.mycompany.thebindingofalice.Metier.fabrique;
import com.mycompany.thebindingofalice.Metier.niveau.carte.salle.TypePorte;
import com.mycompany.thebindingofalice.Metier.projectiles.TypeProjectile;
import com.mycompany.thebindingofalice.Metier.fabrique.constructeurs.ConstructeurProjectile;
import java.util.ArrayList;

/**
 * Fabrique abstraite, héritant de Fabrique, gérant la création des projectiles
 */
public class FabriqueProjectile extends Fabrique {
	public ArrayList<ConstructeurProjectile> constructeurs = new ArrayList<ConstructeurProjectile>();

	public TypeProjectile[] Types() {
		throw new UnsupportedOperationException();
	}

	public void Create(TypePorte type) {
		throw new UnsupportedOperationException();
	}
}