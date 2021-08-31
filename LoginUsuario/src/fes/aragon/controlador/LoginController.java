/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fes.aragon.controlador;

import fes.aragon.BaseControlador;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mike
 */
public class LoginController extends BaseControlador implements Initializable {

    @FXML
    private TextField txtUsuario;
    @FXML
    private TextField txtClave;
    @FXML
    private Button btnAceptar;
    @FXML
    private Button btnCancelar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void compararCredenciales(ActionEvent event) throws IOException {
        if(!datos.getNombre().equals(txtUsuario.getText()) && !datos.getClave().equals(txtClave.getText())){
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Mensaje...");
            alerta.setHeaderText("Datos invalidos");
            alerta.setContentText("Usuario o Clave invalidos");
            alerta.showAndWait();
            txtUsuario.setText("");
            txtClave.setText("");
        }else{
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Mensaje...");
            alerta.setHeaderText("Datos validos");
            alerta.setContentText("Presione para continuar");
            alerta.showAndWait();
            Parent padre = FXMLLoader.load(getClass().getResource("/fes/aragon/fxml/MenuInicial.fxml"));
            Scene escena = new Scene(padre);
            Stage appEscenario = (Stage)((Node)event.getSource()).getScene().getWindow();
            appEscenario.hide();
            appEscenario.setScene(escena);
            appEscenario.show();
        }
        
    }

    @FXML
    private void cerrarAplicacion(ActionEvent event) {
        Platform.exit();
    }
    
}
