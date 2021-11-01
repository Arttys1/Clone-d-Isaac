/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thebindingofalice.Metier.niveau.carte.salle;

import thebindingofalice.Metier.niveau.carte.Generateur.CaseSol;

/**
 *
 * @author Arnaud
 */
public class SalleSimple extends Salle{

    public SalleSimple() {
        super();
        AddCase(new CaseSol(0, 0));
        AddCase(new CaseSol(0, 0));
    }
    
    @Override
    public TypeSalle getType() {
        return TypeSalle.Simple;
    }
    
}
