package joel.dein.ejercicio2_jasper;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class InterfazController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void Aceptar(ActionEvent event) {
    }

    public void Cancelar(ActionEvent event) {
    }
}