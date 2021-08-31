/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fes.aragon.ui.controlador;

import fes.aragon.modelo.Nota;
import fes.aragon.ui.BaseControlador;
import static fes.aragon.ui.PaginasFXML.AGREGAR;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import static javafx.scene.control.ButtonType.OK;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Mike
 */
public class ListaNotasController extends BaseControlador implements Initializable {

    @FXML
    private Label numeroNotas;
    @FXML
    private TableView<Nota> listaNotasTabla;
    @FXML
    private TableColumn tblTitulo;
    @FXML
    private TableColumn tblDescripcion;
    @FXML
    private TextField txtBuscarNota;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.tblTitulo.setCellValueFactory(new PropertyValueFactory<>("Titulo"));
        this.tblDescripcion.setCellValueFactory(new PropertyValueFactory<>("Descripcion"));
        this.numeroNotas.textProperty().bind(Bindings.createStringBinding(() -> datos.size() + " Notas ", datos));
        alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("Dialogo de Confirmación");
        alerta.setHeaderText("Confirmacion de eliminación");
        alerta.setContentText("¿Estas de acuerdo en eliminar la nota?");
        FilteredList<Nota> filtroDato = new FilteredList<>(datos, n -> true);
        this.txtBuscarNota.setOnKeyTyped(e -> {
            filtroDato.setPredicate(n -> {
                if(this.txtBuscarNota.getText() == null || this.txtBuscarNota.getText().isEmpty()){
                    return true;
                }
                return n.getTitulo().contains(txtBuscarNota.getText()) || n.getDescripcion().contains(txtBuscarNota.getText());
            });
        });
        this.listaNotasTabla.setItems(filtroDato);
    }    
    
    private Nota getItem(){
        return Nota.class.cast(listaNotasTabla.getSelectionModel().getSelectedItem());
    }
    
    @FXML
    private void nuevaNota(ActionEvent event) throws IOException {
        editarNota = null;
        navegar(event, AGREGAR.getPagina());
    }

    @FXML
    private void borrar(ActionEvent event) {
        Optional<ButtonType> resultado = alerta.showAndWait();
        if(resultado.get().equals(OK)){
            datos.remove(getItem());
        }
    }

    @FXML
    private void editar(ActionEvent event) throws IOException {
        editarNota = null;
        editarNota = getItem();
        if(Objects.nonNull(editarNota)){
            navegar(event, AGREGAR.getPagina());
        }
    }
    
}
