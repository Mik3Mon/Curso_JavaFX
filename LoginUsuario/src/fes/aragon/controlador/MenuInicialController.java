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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mike
 */
public class MenuInicialController extends BaseControlador implements Initializable {

    @FXML
    private Label lblNombreUsuario;
    @FXML
    private Button btnCerrarSesion;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.lblNombreUsuario.setText(datos.getNombre());
    }    

    @FXML
    private void cerrarSesion(ActionEvent event) throws IOException {
        datos.setNombre("");
        Parent padre = FXMLLoader.load(getClass().getResource("/fes/aragon/fxml/Login.fxml"));
        Scene escena = new Scene(padre);
        Stage appEscenario = (Stage)((Node)event.getSource()).getScene().getWindow();
        appEscenario.hide();
        appEscenario.setScene(escena);
        appEscenario.show();
    }
    
}
