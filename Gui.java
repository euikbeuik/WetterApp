
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Gui {
    private String city;
    private WetterTag wetterTag;

    public Gui(String city, WetterTag wetterTag) {
        this.city = city;
        this.wetterTag = wetterTag;
    }

    @Override
    public void start(Stage primaryStage) {
        // GUI-Komponenten erstellen
        Label cityLabel = new Label("Stadt: " + city);
        Label temperatureLabel = new Label("Temperatur: " + wetterTag.getTemperatur() + "°C");
        Label descriptionLabel = new Label("Beschreibung: " + wetterTag.getBeschreibung());

        // Layout erstellen und Komponenten hinzufügen
        VBox layout = new VBox(10);
        layout.getChildren().addAll(cityLabel, temperatureLabel, descriptionLabel);

        // Szene erstellen und dem Hauptfenster hinzufügen
        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setTitle("Wetteranzeige");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void show() {
        launch();
    }
}
