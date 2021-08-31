/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fes.aragon.oyentes;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 *
 * @author mash
 */
public class BaseDeDatosDos implements ChangeListener {

    @Override
    public void changed(ObservableValue ov, Object t, Object t1) {
        System.out.println("Nuevo dato: "+t1);
    }
    
}
