/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fes.aragon.ui;

import fes.aragon.modelo.Alumno;
import java.io.IOException;
import java.net.URL;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

/**
 *
 * @author Mike
 */
public class BaseControlador {
    protected Alert alerta;
    protected static ObservableList<Alumno> datos = FXCollections.<Alumno>observableArrayList(
            new Alumno("Miguel Angel", "Monzón", "Lucero", 20, "demo@demo.com"),
            new Alumno("Valentina", "Monzón", "Lucero", 15, "demo@demo.com"),
            new Alumno("Jose Angel", "López", "Hernández", 18, "demo@demo.com"),
            new Alumno("Daniela", "Covarrubias", "Pérez", 22, "demo@demo.com"),
            new Alumno("Hugo", "Rojas", "Feregrino", 21, "demo@demo.com"));
    protected static Alumno editarAlumno = null;
    
    protected void navegar(Event event, URL fxmlDoc) throws IOException{
        Parent pagina = FXMLLoader.load(fxmlDoc);
        Scene escena = new Scene(pagina);
        Stage appEscenario = (Stage)((Node)event.getSource()).getScene().getWindow();
        appEscenario.hide();
        appEscenario.setScene(escena);
        appEscenario.show();
    }       
}
