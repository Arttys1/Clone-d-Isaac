/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thebindingofalice.Metier.niveau.carte.salle;

import thebindingofalice.Metier.niveau.carte.Generateur.CaseMur;
import thebindingofalice.Metier.niveau.carte.Generateur.CaseSol;

/**
 *
 * @author Arnaud
 */
public class SalleSimple extends Salle{

    public SalleSimple() {
        super();
        generateSalle();
    }
    
    private void generateSalle()
    {
        int tailleCote = getTailleCote();
        for (int i = 0; i < tailleCote; i++) {
            for (int j = 0; j < tailleCote; j++) {
                if(i == 0 || i == tailleCote - 1 || j == 0 || j == tailleCote - 1)
                {
                    AddCase(new CaseMur(i, j));
                }
                else
                {
                    AddCase(new CaseSol(i, j));
                }
            }
        }
    }
    
    @Override
    public TypeSalle getType() {
        return TypeSalle.Simple;
    }
    
}
