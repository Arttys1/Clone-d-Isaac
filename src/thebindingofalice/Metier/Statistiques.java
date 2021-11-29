package thebindingofalice.Metier;

public class Statistiques {
    private double vitesseDeplacement = 5;
    private double degats;
    private double cadenveTir = 50.0;
    private double porteeTir;
    private double vitesseProjectile = 2.5;
    private double chance;
    
    public double getVitesseDeplacement() {
        return vitesseDeplacement;
    }

    public void setVitesseDeplacement(double vitesseDeplacement) {
        this.vitesseDeplacement = vitesseDeplacement;
    }

    public double getDegats() {
        return degats;
    }

    public void setDegats(double degats) {
        this.degats = degats;
    }

    public double getCadenveTir() {
        return cadenveTir;
    }

    public void setCadenveTir(double cadenveTir) {
        this.cadenveTir = cadenveTir;
    }

    public double getPorteeTir() {
        return porteeTir;
    }

    public void setPorteeTir(double porteeTir) {
        this.porteeTir = porteeTir;
    }

    public double getVitesseProjectile() {
        return vitesseProjectile;
    }

    public void setVitesseProjectile(double vitesseProjectile) {
        this.vitesseProjectile = vitesseProjectile;
    }

    public double getChance() {
        return chance;
    }

    public void setChance(double chance) {
        this.chance = chance;
    }

}
