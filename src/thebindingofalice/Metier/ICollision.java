package thebindingofalice.Metier;
/**
 * Interface représentant les objets avec des collisions
 */
public interface ICollision {

	public void Collision(ICollision o);

	public boolean EstLeJoueur();

	public boolean EstBloquant();
}