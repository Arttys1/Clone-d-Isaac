package thebindingofalice.Metier;
/**
 * Classe représentant des coordonnées 2D. Elle compose tout objet qui doit "évoluer a chaque frame".
 */
public class Coordonnee {
    private int x;
    private int y;

    public Coordonnee(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX(){
        return x;
    }
    
    public void setX(int x){
        this.x=x;
    }
    
    public void setY(int y){
        this.y=y;
    }
    
    public int getY(){
        return y;
    }
}