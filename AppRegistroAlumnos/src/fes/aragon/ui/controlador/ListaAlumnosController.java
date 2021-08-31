/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fes.aragon.ui.controlador;

import fes.aragon.modelo.Alumno;
import fes.aragon.ui.BaseControlador;
import static fes.aragon.ui.PaginasFXML.AGREGAR;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import static javafx.scene.control.ButtonType.OK;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Mike
 */
public class ListaAlumnosController extends BaseControlador implements Initializable {

    @FXML
    private TextField txtBuscarAlumno;
    @FXML
    private Button btnAgregarAlumno;
    @FXML
    private Button btnEditarAlumno;
    @FXML
    private Button btnEliminarAlumno;
    @FXML
    private TableColumn tblNombres;
    @FXML
    private TableColumn tblApPaterno;
    @FXML
    private TableColumn tblApMaterno;
    @FXML
    private TableColumn tblEdad;
    @FXML
    private TableColumn tblCorreo;
    @FXML
    private TableView<Alumno> listaAlumnosTabla;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.tblNombres.setCellValueFactory(new PropertyValueFactory<>("Nombres"));
        this.tblApPaterno.setCellValueFactory(new PropertyValueFactory<>("ApellidoPaterno"));
        this.tblApMaterno.setCellValueFactory(new PropertyValueFactory<>("ApellidoMaterno"));
        this.tblEdad.setCellValueFactory(new PropertyValueFactory<>("Edad"));
        this.tblCorreo.setCellValueFactory(new PropertyValueFactory<>("CorreoElectronico"));
        alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("Dialogo de Confirmación");
        alerta.setHeaderText("Confirmacion de eliminación");
        alerta.setContentText("¿Estas de acuerdo en eliminar al Alumno?");
        FilteredList<Alumno> filtroDato = new FilteredList<>(datos, n -> true);
        this.txtBuscarAlumno.setOnKeyTyped(e -> {
            filtroDato.setPredicate(n -> {
                if(this.txtBuscarAlumno.getText() == null || this.txtBuscarAlumno.getText().isEmpty()){
                    return true;
                }
                return n.getNombres().contains(txtBuscarAlumno.getText()) || n.getApellidoPaterno().contains(txtBuscarAlumno.getText());
            });
        });
        this.listaAlumnosTabla.setItems(filtroDato);
    }    
    
    private Alumno getItem(){
        return Alumno.class.cast(listaAlumnosTabla.getSelectionModel().getSelectedItem());
    }

    @FXML
    private void agregar(ActionEvent event) throws IOException {
        editarAlumno = null;
        navegar(event, AGREGAR.getPagina());
    }

    @FXML
    private void editar(ActionEvent event) throws IOException {
        editarAlumno = null;
        editarAlumno = getItem();
        if(Objects.nonNull(editarAlumno)){
            navegar(event, AGREGAR.getPagina());
        }
    }

    @FXML
    private void eliminar(ActionEvent event) {
        Optional<ButtonType> resultado = alerta.showAndWait();
        if(resultado.get().equals(OK)){
            datos.remove(getItem());
        }
    }
    
}
