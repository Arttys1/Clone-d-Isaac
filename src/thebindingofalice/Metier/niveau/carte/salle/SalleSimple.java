/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thebindingofalice.Metier.niveau.carte.salle;

import thebindingofalice.Metier.fabrique.Fabrique;
import thebindingofalice.Metier.fabrique.FabriqueCase;
import thebindingofalice.Metier.fabrique.TypeFabrique;
import thebindingofalice.Metier.niveau.carte.Generateur.CaseMur;
import thebindingofalice.Metier.niveau.carte.Generateur.CaseSol;
import thebindingofalice.Metier.niveau.carte.Generateur.TypeCase;

/**
 * Classe, héritant de Salle, représentant une salle de base.
 * Cette classe sert de test. Elle ne sera peut être pas gardé par la suite.
 * @author Arnaud
 */
public class SalleSimple extends Salle{

    public SalleSimple() {
        super();
        generateSalle();
    }
    
    /**
     * Méthode générant la salle
     */
    private void generateSalle()
    {
        int tailleCote = getTailleCote();
        FabriqueCase fabriqueCase = (FabriqueCase) Fabrique.get(TypeFabrique.CASE);
        for (int i = 0; i < tailleCote; i++) {
            for (int j = 0; j < tailleCote; j++) {
                TypeCase type;
                if(i == 0 || i == tailleCote - 1 || j == 0 || j == tailleCote - 1)
                {
                    type = TypeCase.MUR;
                }
                else
                {
                    type = TypeCase.SOL;
                }
                AddCase(fabriqueCase.Create(type, j, i));
            }
        }
    }
    
    @Override
    public TypeSalle getType() {
        return TypeSalle.Simple;
    }
    
}
