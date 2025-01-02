module joel.dein.ejercicio2_jasper {
    requires javafx.controls;
    requires javafx.fxml;
    requires jasperreports;
    requires java.sql;


    opens joel.dein.ejercicio2_jasper to javafx.fxml;
    exports joel.dein.ejercicio2_jasper;
}