/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fes.aragon.ui.controlador;

import fes.aragon.modelo.Alumno;
import fes.aragon.ui.BaseControlador;
import static fes.aragon.ui.PaginasFXML.LISTA;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Mike
 */
public class AgregarAlumnosController extends BaseControlador implements Initializable {

    @FXML
    private Button btnGuardar;
    @FXML
    private Button btnCancelar;
    @FXML
    private Button btnLimpiar;
    @FXML
    private Button btnRegistros;
    @FXML
    private TextField txtNombres;
    @FXML
    private TextField txtApellidoPaterno;
    @FXML
    private TextField txtApellidoMaterno;
    @FXML
    private TextField txtEdad;
    @FXML
    private TextField txtCorreo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("Dialogo de Aviso");
        alerta.setHeaderText("Dato invalido para salvar");
        alerta.setContentText("El titulo o descripcion no deben ser vacios");
        
        if(Objects.nonNull(editarAlumno)){
            txtNombres.setText(editarAlumno.getNombres());
            txtApellidoPaterno.setText(editarAlumno.getApellidoPaterno());
            txtApellidoMaterno.setText(editarAlumno.getApellidoMaterno());
            txtEdad.setText(String.valueOf(editarAlumno.getEdad()));
            txtCorreo.setText(editarAlumno.getCorreoElectronico());
            btnGuardar.setText("Guardar");
        }
    }    

    @FXML
    private void guardar(ActionEvent event) throws IOException {
        if(Objects.nonNull(editarAlumno)){
            datos.remove(editarAlumno);
        }
        if(txtNombres.getText().trim().equals("") || txtApellidoPaterno.getText().trim().equals("") || txtApellidoMaterno.getText().trim().equals("") || txtEdad.getText().trim().equals("") || txtCorreo.getText().trim().equals("") ){
            alerta.showAndWait();
            return;
        }
        datos.add(new Alumno(txtNombres.getText(), txtApellidoPaterno.getText(), txtApellidoMaterno.getText(), Integer.valueOf(txtEdad.getText()), txtCorreo.getText()));
        navegar(event, LISTA.getPagina());
    }

    @FXML
    private void cancelar(ActionEvent event) throws IOException {
        navegar(event, LISTA.getPagina());
    }

    @FXML
    private void limpiar(ActionEvent event) {
        txtNombres.clear();
        txtApellidoPaterno.clear();
        txtApellidoMaterno.clear();
        txtEdad.clear();
        txtCorreo.clear();
    }

    @FXML
    private void resgistros(ActionEvent event) throws IOException {
        navegar(event, LISTA.getPagina());
    }
    
}
