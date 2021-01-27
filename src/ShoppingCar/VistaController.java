package ShoppingCar;

import Compra.Compra;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class VistaController implements Initializable {

    // Declaramos los botones
    @FXML private Button aniadirBT;
    @FXML private Button modificarBT;
    @FXML private Button eliminarBT;
    @FXML private Button nuevoBT;
    
    // Declaramos los textfileds
    @FXML private TextField nombreProductoTF;
    @FXML private TextField cantidadTF;
    @FXML private TextField costoUnitarioTF;
    @FXML private TextField costoTotalTF;
    
    // Declaramos la tabla y las columnas
    @FXML private TableView<Compra> tablaCompras;
    @FXML private TableColumn nombreProductoCL;
    @FXML private TableColumn cantidadCL;
    @FXML private TableColumn costoUnitarioCL;
    @FXML private TableColumn costoTotalCL;
    ObservableList<Compra> Compras;
    
    private int posicionCompraEnTabla;

    /**
     * Método que realiza las acciones tras pulsar el boton "Nuevo"
     *
     * @param event
     */
    @FXML private void nuevo(ActionEvent event) {
        nombreProductoTF.setText("");
        cantidadTF.setText("");
        Compra.this.costoUnitarioTF.setText("");
        Compra.this.costoTotalTF.setText("");
        modificarBT.setDisable(true);
        eliminarBT.setDisable(true);
        aniadirBT.setDisable(false);
    }

    /**
     * Método que realiza las acciones tras pulsar el boton "Añadir"
     *
     * @param event
     */
    @FXML private void aniadir(ActionEvent event) {
        Compra Compra = new Compra();
        Compra.nombreProducto.set(nombreProductoTF.getText());
        Compra.cantidad.set(cantidadTF.getText());
        Compra.costoUnitario.set(Integer.parseInt(Compra.this.costoUnitarioTF.getText()));
        Compra.costoTotal.set(Compra.this.costoTotalTF.getText());
        Compras.add(Compra);
    }

    /**
     * Método que realiza las acciones tras pulsar el boton "Modificar"
     *
     * @param event
     */
    @FXML private void modificar(ActionEvent event) {
        Compra Compra = new Compra();
        Compra.nombreProducto.set(nombreProductoTF.getText());
        Compra.cantidad.set(cantidadTF.getText());
        Compra.costoUnitario.set(Integer.parseInt(Compra.this.costoUnitarioTF.getText()));
        Compra.costoTotal.set(Compra.this.costoTotalTF.getText());
        Compras.set(posicionCompraEnTabla, Compra);
    }

    /**
     * Método que realiza las acciones tras pulsar el boton "Eliminar"
     *
     * @param event
     */
    @FXML private void eliminar(ActionEvent event) {
        Compras.remove(posicionCompraEnTabla);
    }
    /**
     * Listener de la tabla Compras
     */
    private final ListChangeListener<Compra> selectorTablaCompras =
            new ListChangeListener<Compra>() {
                @Override
                public void onChanged(ListChangeListener.Change<? extends Compra> c) {
                    ponerCompraSeleccionada();
                }
            };

    /**
     * PARA SELECCIONAR UNA CELDA DE LA TABLA "tablaCompras"
     */
    public Compra getTablaComprasSeleccionada() {
        if (tablaCompras != null) {
            List<Compra> tabla = tablaCompras.getSelectionModel().getSelectedItems();
            if (tabla.size() == 1) {
                final Compra competicionSeleccionada = tabla.get(0);
                return competicionSeleccionada;
            }
        }
        return null;
    }

    /**
     * Método para poner en los textFields la tupla que selccionemos
     */
    private void ponerCompraSeleccionada() {
        final Compra Compra = getTablaComprasSeleccionada();
        posicionCompraEnTabla = Compras.indexOf(Compra);

        if (Compra != null) {

            // Pongo los textFields con los datos correspondientes
            nombreProductoTF.setText(Compra.getNombreProducto());
            cantidadTF.setText(Compra.getcantidad());
            Compra.this.costoUnitarioTF.setText(Compra.getcostoUnitario().toString());
            Compra.this.costoTotalTF.setText(Compra.getcostoTotal());

            // Pongo los botones en su estado correspondiente
            modificarBT.setDisable(false);
            eliminarBT.setDisable(false);
            aniadirBT.setDisable(true);

        }
    }

    /**
     * Método para inicializar la tabla
     */
    private void inicializarTablaCompras() {
        nombreProductoCL.setCellValueFactory(new PropertyValueFactory<Compra, String>("nombreProducto"));
        cantidadCL.setCellValueFactory(new PropertyValueFactory<Compra, String>("cantidad"));
        Compra.this.costoUnitarioCL.setCellValueFactory(new PropertyValueFactory<Compra, Integer>("costoUnitario"));
        Compra.this.costoTotalCL.setCellValueFactory(new PropertyValueFactory<Compra, String>("costoTotal"));

        Compras = FXCollections.observableArrayList();
        tablaCompras.setItems(Compras);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // Inicializamos la tabla
        this.inicializarTablaCompras();

        // Ponemos estos dos botones para que no se puedan seleccionar
        modificarBT.setDisable(true);
        eliminarBT.setDisable(true);

        // Seleccionar las tuplas de la tabla de las Compras
        final ObservableList<Compra> tablaCompraSel = tablaCompras.getSelectionModel().getSelectedItems();
        tablaCompraSel.addListener(selectorTablaCompras);

        // Inicializamos la tabla con algunos datos aleatorios
        for (int i = 0; i < 20; i++) {
            Compra p1 = new Compra();
            p1.nombreProducto.set("NombreProducto " + i);
            p1.cantidad.set("cantidad " + i);
            p1.costoUnitario.set(20 + i);
            p1.costoTotal.set("67589458" + i);
            Compras.add(p1);
        }
    }
}
