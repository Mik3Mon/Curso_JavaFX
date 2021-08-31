/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fes.aragon.modelo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Mike
 */
public class Usuario {
    private final StringProperty nombre;
    private final StringProperty clave;
    
    public Usuario(String nombre, String clave){
        this.nombre = new SimpleStringProperty(nombre);
        this.clave = new SimpleStringProperty(clave);
    }
    
    public StringProperty nombreProperty(){
        return this.nombre;
    }
    
    public StringProperty claveProperty(){
        return this.clave;
    }
    
    public String getNombre(){
        return this.nombre.get();
    }
    
    public void setNombre(String nombre){
        this.nombre.set(nombre);
    }
    
    public String getClave(){
        return this.clave.get();
    }
    
    public void setClave(String clave){
        this.clave.set(clave);
    }
    
    
}
