package joel.dein.ejercicio2_jasper;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Clase principal que lanza la aplicación de informes, cargando la interfaz gráfica.
 * Esta clase extiende de {@link javafx.application.Application} para inicializar y mostrar la interfaz.
 */
public class LanzarInforme extends Application {

    /**
     * Metodo principal de inicio de la aplicación. Carga la interfaz desde un archivo FXML
     * y la muestra en una ventana de tipo {@link Stage}.
     *
     * @param stage El escenario principal donde se mostrará la interfaz gráfica.
     * @throws IOException Si hay un error al cargar el archivo FXML.
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LanzarInforme.class.getResource("/fxml/interfaz.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("INFORMES");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Metodo principal de ejecución de la aplicación. Llama al metodo {@link #start(Stage)}
     * para inicializar y mostrar la interfaz.
     *
     * @param args Argumentos de línea de comandos.
     */
    public static void main(String[] args) {
        launch();
    }
}
