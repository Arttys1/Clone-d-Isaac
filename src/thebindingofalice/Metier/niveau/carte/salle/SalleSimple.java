/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thebindingofalice.Metier.niveau.carte.salle;

import thebindingofalice.IHM.GamePane;
import thebindingofalice.IHM.view.CoeurView;
import thebindingofalice.Metier.Coordonnee;
import thebindingofalice.Metier.fabrique.FabriqueCase;
import thebindingofalice.Metier.niveau.carte.Generateur.TypeCase;
import thebindingofalice.Metier.objet.ramassable.Coeur;

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
        int tailleCote = Salle.getTailleCote();
        for (int i = 0; i < tailleCote; i++) {
            for (int j = 0; j < tailleCote; j++) {
                TypeCase type;
                if(i == 0 && j == 5 ||
                   i == tailleCote -1 && j == 5 ||
                   i == 5 && j == 0 ||
                   i == 5 && j == tailleCote -1)
                {
                    type = TypeCase.PORTE;
                }
                else if(i == 0 || i == tailleCote - 1 || j == 0 || j == tailleCote - 1)
                {
                    type = TypeCase.MUR;
                }
                else
                {
                    type = TypeCase.SOL;
                }
                AddCase(FabriqueCase.Create(type, j, i));
            }
        }        
    }

    @Override
    public TypeSalle getType() {
        return TypeSalle.Simple;
    }
}
