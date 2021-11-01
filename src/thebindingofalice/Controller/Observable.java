/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thebindingofalice.Controller;

import java.util.ArrayList;

/**
 *
 * @author Arnaud
 */
public abstract class Observable {
    private ArrayList<Observeur> obs;

    protected Observable() {
        obs = new ArrayList<>();
    }
    
    public void Register(Observeur o){ obs.add(o); }
    
    protected void Notify(String message)
    {
        for(Observeur o : obs)
        {
           o.Update(message);
        }
    }
}
