package es.juliogtrenard.gestionarpersonasBBDDV2;

import es.juliogtrenard.gestionarpersonasBBDDV2.db.DBConnect;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * Clase principal de la aplicación que extiende {@link Application}.
 * Esta clase se encarga de iniciar la interfaz gráfica de usuario
 * y cargar la vista definida en el archivo FXML.
 */
public class HelloApplication extends Application {
    /**
     * Metodo principal que inicia la aplicación.
     *
     * @param args Argumentos de la línea de comandos (no se utilizan).
     */
    public static void main(String[] args) {
        launch();
    }

    /**
     * Metodo que se llama al iniciar la aplicación.
     *
     * @param stage El escenario principal donde se muestra la interfaz gráfica.
     * @throws IOException Si ocurre un error al cargar el archivo FXML.
     */
    @Override
    public void start(Stage stage) throws IOException {
        Properties properties = DBConnect.getConfiguracion();
        String language = properties.getProperty("language");
        Locale locale = new Locale.Builder().setLanguage(language).build();
        ResourceBundle bundle = ResourceBundle.getBundle("es/juliogtrenard/gestionarpersonasBBDDV2/languages/lang", locale);

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/es/juliogtrenard/gestionarpersonasBBDDV2/fxml/hello-view.fxml"),bundle);
        Scene scene = new Scene(fxmlLoader.load(), 750, 450);

        stage.getIcons().add(new Image(String.valueOf(getClass().getResource("/es/juliogtrenard/gestionarpersonasBBDDV2/img/library_icon.png"))));

        stage.setTitle("PERSONAS");
        stage.setScene(scene);

        stage.setMinWidth(700);
        stage.setMinHeight(400);

        stage.setTitle("PERSONAS");
        stage.setScene(scene);
        stage.show();
    }
}