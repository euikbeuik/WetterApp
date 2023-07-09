import javax.swing.*;
import java.awt.*;

public class Gui extends JFrame {
    private JLabel stadtLabel;
    private JLabel temperaturLabel;
    private JLabel beschreibungLabel;

    public Gui(String stadt, double temperatur, String beschreibung) {
        // GUI initialisieren
        setTitle("Wetter_Heute");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        // GUI-Komponenten erstellen
        stadtLabel = new JLabel("Stadt: " + stadt);
        temperaturLabel = new JLabel("Temperatur: " + temperatur + "°C");
        beschreibungLabel = new JLabel("Beschreibung: " + beschreibung);

        // GUI-Komponenten hinzufügen
        getContentPane().setLayout(new FlowLayout());
        getContentPane().add(stadtLabel);
        getContentPane().add(temperaturLabel);
        getContentPane().add(beschreibungLabel);
    }
}