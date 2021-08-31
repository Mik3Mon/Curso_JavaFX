/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fes.aragon.beans;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 *
 * @author mash
 */
public class Empleado {
    private String nombre;
    private double salario;
    private PropertyChangeSupport datos=new PropertyChangeSupport(this);

    public Empleado() {
        this.nombre="Sin nombre";
        this.salario=0.0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        double viejoSalario=this.salario;        
        this.salario = salario;
        //notificar a todos los oyentes registrados el cambio
        //que se llama "cambio"
        datos.firePropertyChange("cambio", viejoSalario, this.salario);
    }
    
    public void agregarOyente(PropertyChangeListener oyente){
        datos.addPropertyChangeListener(oyente);
    }
    public void eliminarOyente(PropertyChangeListener oyente){
        datos.removePropertyChangeListener(oyente);
    }    

    @Override
    public String toString() {
        return "Empleado{" + "salario=" + salario + '}';
    }
    
}
