/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fes.aragon.oyentes;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 *
 * @author mash
 */
public class Calcular implements PropertyChangeListener{

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        String mensaje=evt.getPropertyName();
        if("cambio".equals(mensaje)){
            System.out.println("Dato anterior: "+(Double)evt.getOldValue());
            System.out.println("Dato nuevo: "+(Double)evt.getNewValue());
            System.out.println("Código para calculos");
        }
    }
    
}
