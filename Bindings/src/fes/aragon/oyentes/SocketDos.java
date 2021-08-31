/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fes.aragon.oyentes;

import javafx.beans.value.ObservableValue;

/**
 *
 * @author mash
 */
public class SocketDos {

    public static void mensajeSocket(ObservableValue<? extends Number> evt,
            Number viejoDato, Number nuevoDato) {
        System.out.println("Valor nuevo: " + nuevoDato);

    }
    public static void mensajeSocketGeneral(ObservableValue<? extends Object> evt,
            Object viejoDato, Object nuevoDato) {
        System.out.println("Valor nuevo: "+nuevoDato);
    }

}
