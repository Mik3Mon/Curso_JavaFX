/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fes.aragon.test;

import fes.aragon.modelo.Persona;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 *
 * @author mash
 */
public class ListaTest {
    interface ChecarPersona{
        boolean test(Persona persona);
    }
    
    public static void mostrarEdadMayor(List<Persona> lista, int edad){
        for(Persona persona : lista){
            if(persona.getEdad() >= edad){
                System.out.println(persona);
            }
        }
    }
    
    public static void mostrarEdadRango(List<Persona> lista, int primero, int segundo){
        for(Persona persona : lista){
            if(primero <= persona.getEdad() && persona.getEdad() <= segundo){
                System.out.println(persona);
            }
        }
    }
    
    public static void criterioPersona(List<Persona> lista, ChecarPersona test){
        for(Persona persona : lista){
            if(test.test(persona)){
                System.out.println(persona);
            }
        }
    }
    
    public static void mostrarPersonaConPredicado(List<Persona> lista, Predicate<Persona>afirmar){
        for(Persona persona : lista){
           if(afirmar.test(persona)){
               System.out.println(persona.toString());
           } 
        }
    }
    
    public static void procesarPersonas(List<Persona> lista, Predicate<Persona> afirmar, Consumer<Persona> bloque){
        for(Persona persona : lista){
           if(afirmar.test(persona)){
               bloque.accept(persona);
           } 
        }
    }
    
    public static void procesarPersonasConFuncion(List<Persona> lista, Predicate<Persona> afirmar, Function<Persona, String> mapeo, Consumer<String> bloque){
        for(Persona persona : lista){
           if(afirmar.test(persona)){
               String dato = mapeo.apply(persona);
               bloque.accept(dato);
           } 
        }
    }
    
    public static <X, Y> void procesarElementosGenericos(Iterable<X> lista, Predicate<X> afirmar, Function<X, Y> mapeo, Consumer<Y> bloque){
        for(X x : lista){
           if(afirmar.test(x)){
               Y dato = mapeo.apply(x);
               bloque.accept(dato);
           } 
        }
    }
    
    public static void main(String[] args) {
        List<Persona> lista = Persona.crearLista();
        System.out.println("Personas mayores o iguales que 35");
        ListaTest.mostrarEdadMayor(lista, 35);
        System.out.println("----------");
        System.out.println("Personas entre 18 y 35");
        ListaTest.mostrarEdadRango(lista, 31, 35);
        System.out.println("------------");
        System.out.println("Criterio con una interfaz");
        class ChecarPersonas implements ListaTest.ChecarPersona{

            @Override
            public boolean test(Persona persona) {
                return persona.getGenero() == Persona.Sexo.FEMININO && persona.getEdad() >= 18 && persona.getEdad() <= 31;
            }
        }
        ListaTest.criterioPersona(lista, new ChecarPersonas());
        System.out.println("------------");
        System.out.println("Criterio de busqueda con una clase anonima");
        ListaTest.criterioPersona(lista, new ChecarPersona() {
            @Override
            public boolean test(Persona persona) {
                return persona.getGenero() == Persona.Sexo.MASCULINO && persona.getEdad() >= 18 && persona.getEdad() <= 35;
            }
        });
        System.out.println("............");
        System.out.println("Especificar el código de criterios de búsqueda con una expesión Lambda");
        ListaTest.criterioPersona(lista, (Persona persona) -> persona.getGenero() == Persona.Sexo.MASCULINO 
                && persona.getEdad() >= 18 && persona.getEdad() <= 35);
        System.out.println("............");
        System.out.println("Interfaces funcionales estándar con Lambda");
        ListaTest.mostrarPersonaConPredicado(lista, persona -> persona.getGenero() == Persona.Sexo.MASCULINO 
                && persona.getEdad() >= 18 && persona.getEdad() <= 35);
        System.out.println("............");
        System.out.println("Expresiones Lambda en toda la aplicación");
        ListaTest.procesarPersonas(lista, persona -> persona.getGenero() == Persona.Sexo.MASCULINO 
                && persona.getEdad() >= 18 && persona.getEdad() <= 35, persona -> {
            System.out.println(persona);
            System.out.println("Mas cosas");
        });
        System.out.println(".............");
        System.out.println("Expresiones Lambda en toda la aplicación con Function");
        ListaTest.procesarPersonasConFuncion(lista, persona -> persona.getGenero() == Persona.Sexo.MASCULINO 
                && persona.getEdad() >= 18 && persona.getEdad() <= 35, persona -> persona.getEmail(), email -> System.out.println(email));
        System.out.println(".............");
        System.out.println("Expresiones Lambda en toda la aplicacion con Function Genericas");
        ListaTest.procesarElementosGenericos(lista, persona -> persona.getGenero() == Persona.Sexo.MASCULINO 
                && persona.getEdad() >= 18 && persona.getEdad() <= 35, persona -> persona.getEdad(), edad -> System.out.println(edad));
        System.out.println(".............");
    }
}
