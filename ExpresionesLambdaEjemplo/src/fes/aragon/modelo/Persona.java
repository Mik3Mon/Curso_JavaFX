/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fes.aragon.modelo;

import java.time.LocalDate;
import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mash
 */
public class Persona {
    private String nombre;
    private LocalDate fechaNacimiento;
    private Sexo genero;
    private String email;

    public Persona(String nombre, LocalDate fechaNacimiento, Sexo genero, String email) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.email = email;
    }
    
    public enum Sexo{
        FEMININO,MASCULINO;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Sexo getGenero() {
        return genero;
    }

    public void setGenero(Sexo genero) {
        this.genero = genero;
    }
    public int getEdad(){
        return fechaNacimiento.until(IsoChronology.INSTANCE.dateNow()).getYears();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    

    @Override
    public String toString() {
        return "Nombre: "+ nombre+ " Edad: "+this.getEdad();
    }
    
    public static List<Persona> crearLista(){
        List<Persona> lista=new ArrayList<>();
        lista.add(new Persona("Miguel Angel",
                IsoChronology.INSTANCE.date(1976, 10, 6),
                Persona.Sexo.MASCULINO,"mikeloco@fes.aragon"));
        lista.add(new Persona("Rebeca",
                IsoChronology.INSTANCE.date(1989, 8, 16),
                Persona.Sexo.FEMININO,"rebe@fes.aragon"));
        lista.add(new Persona("Raul",
                IsoChronology.INSTANCE.date(1986, 2, 21),
                Persona.Sexo.MASCULINO,"rara@fes.aragon"));
        lista.add(new Persona("Maria",
                IsoChronology.INSTANCE.date(1991, 6, 18),
                Persona.Sexo.FEMININO,"maria@fes.aragon"));
        return lista;
    }
    
    
}
