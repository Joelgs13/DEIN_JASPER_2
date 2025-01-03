package joel.dein.ejercicio2_jasper;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import BBDD.ConexionBBDD;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class InterfazController {

    @FXML
    private Button btAceptar;

    @FXML
    private Button btCancelar;

    @FXML
    private ToggleGroup grupoIformes;

    @FXML
    private RadioButton rbPersonas;

    @FXML
    private RadioButton rbPCalculos;

    @FXML
    private RadioButton rbPSubinformes;

    private void generarReporte(String reportePath, Map<String, Object> parameters) {
        try {
            ConexionBBDD db = new ConexionBBDD();
            InputStream reportStream = getClass().getResourceAsStream(reportePath);

            if (reportStream == null) {
                System.out.println("El archivo no está ahí: " + reportePath);
                return;
            }

            JasperReport report = (JasperReport) JRLoader.loadObject(reportStream);
            JasperPrint jprint = JasperFillManager.fillReport(report, parameters, db.getConnection());
            JasperViewer viewer = new JasperViewer(jprint, false);
            viewer.setVisible(true);

        } catch (SQLException | JRException e) {
            e.printStackTrace();
            mostrarError("Error en la base de datos", "No se pudo conectar a la base de datos o generar el informe.");
        }
    }

    private void mostrarError(String titulo, String mensaje) {
        // Crear una ventana emergente de tipo "error"
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null); // No queremos un encabezado
        alert.setContentText(mensaje); // El mensaje que queremos mostrar
        alert.showAndWait(); // Mostrar el mensaje y esperar a que el usuario lo cierre
    }

    @FXML
    void Aceptar(ActionEvent event) {
        if (rbPersonas.isSelected()) {
            generarReporte("/JasperReport/InformePersonas.jasper", null);
        } else if (rbPCalculos.isSelected()) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("IMAGE_PATH", getClass().getResource("/img/").toString());
            generarReporte("/JasperReport/InformePConCalculos.jasper", parameters);
        } else if (rbPSubinformes.isSelected()) {
            //este informe no me funciona
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("Resource_PATH", getClass().getResource("/jrxml/").toString());
            generarReporte("/JasperReport/Subinformes.jasper", parameters);
        }
    }

    @FXML
    void Cancelar(ActionEvent event) {
        System.exit(0); // O usa una referencia a la ventana principal si deseas cerrarla específicamente
    }
}
