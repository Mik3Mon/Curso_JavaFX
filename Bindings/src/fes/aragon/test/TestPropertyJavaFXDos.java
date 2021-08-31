/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fes.aragon.test;

import fes.aragon.beans.EmpleadoJavaFX;
import fes.aragon.oyentes.BaseDeDatosDos;
import fes.aragon.oyentes.SocketDos;

/**
 *
 * @author mash
 */
public class TestPropertyJavaFXDos {
    public static void main(String[] args) {
        EmpleadoJavaFX datos=new EmpleadoJavaFX("FES", 23.4);
        datos.nombreProperty().set("Aragon");
        datos.salarioProperty().addListener(SocketDos::mensajeSocket);        
        datos.setSalario(40.3);
        datos.setSalario(10.3);
        datos.nombreProperty().addListener(SocketDos::mensajeSocketGeneral);
        datos.setNombre("FES");
        BaseDeDatosDos oyenteNuevo=new BaseDeDatosDos();
        datos.nombreProperty().addListener(oyenteNuevo);
        datos.setNombre("FES ARAGON");
        //remover un listener
        datos.nombreProperty().removeListener(oyenteNuevo);
        datos.setNombre("FES ARAGON es lo mejor");
        datos.nombreProperty().removeListener(SocketDos::mensajeSocketGeneral);        
        datos.setNombre("FES ARAGON es lo mejor, por siempre");
        
        
    }
    
}
