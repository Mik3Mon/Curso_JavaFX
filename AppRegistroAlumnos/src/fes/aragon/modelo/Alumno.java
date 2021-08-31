/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fes.aragon.modelo;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Mike
 */
public class Alumno {
    private final SimpleStringProperty nombres;
    private final SimpleStringProperty ap_paterno;
    private final SimpleStringProperty ap_materno;
    private final SimpleIntegerProperty edad;
    private final SimpleStringProperty correo;
    
    public Alumno(String nombres, String ap_paterno, String ap_materno, int edad, String correo){
        this.nombres = new SimpleStringProperty(nombres);
        this.ap_paterno = new SimpleStringProperty(ap_paterno);
        this.ap_materno = new SimpleStringProperty(ap_materno);
        this.edad = new SimpleIntegerProperty(edad);
        this.correo = new SimpleStringProperty(correo);
    }
    
    public String getNombres(){
        return this.nombres.get();
    }
    
    public void setNombres(String nombres){
        this.nombres.set(nombres);
    }
    
    public String getApellidoPaterno(){
        return this.ap_paterno.get();
    }
    
    public void setApellidoPaterno(String ap_paterno){
        this.ap_paterno.set(ap_paterno);
    }
    
    public String getApellidoMaterno(){
        return this.ap_materno.get();
    }
    
    public void setApellidoMaterno(String ap_materno){
        this.ap_materno.set(ap_materno);
    }
    
    public int getEdad(){
        return this.edad.get();
    }
    
    public void setEdad(int edad){
        this.edad.set(edad);
    }
    
    public String getCorreoElectronico(){
        return this.correo.get();
    }
    
    public void setCorreoElectronico(String correo){
        this.correo.set(correo);
    }
}
