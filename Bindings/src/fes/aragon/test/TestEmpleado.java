/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fes.aragon.test;

import fes.aragon.beans.Empleado;
import fes.aragon.oyentes.BaseDeDatos;
import fes.aragon.oyentes.Calcular;
import fes.aragon.oyentes.Gui;
import fes.aragon.oyentes.Socket;

/**
 *
 * @author mash
 */
public class TestEmpleado {
    public static void main(String[] args) {
        Empleado informacion=new Empleado();
        Calcular oyenteUno=new Calcular();
        Gui oyenteDos=new Gui();
        BaseDeDatos oyenteTres=new BaseDeDatos();        
        informacion.agregarOyente(oyenteUno);
        informacion.agregarOyente(oyenteDos);
        informacion.agregarOyente(oyenteTres);
        informacion.agregarOyente(Socket::eventoCambio);
        informacion.setNombre("Miguel");
        informacion.setSalario(20.34);    
        System.out.println("----------");
        informacion.setSalario(10.23);
    }
    
}
