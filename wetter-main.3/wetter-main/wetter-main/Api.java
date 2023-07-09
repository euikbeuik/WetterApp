import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class Api {



    public static void main(String[] args) {
        // API-Anfrage senden und Wetterdaten abrufen
        String stadt = "";
        double temperatur = 0.0;
        String beschreibung = "";
        try {

            URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q=Regensburg&appid=b4bb477e2884238880979a80795be486");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error code : "
                        + conn.getResponseCode());
            }
            InputStreamReader in = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(in);
            StringBuilder responseData = new StringBuilder();
            String output;
            while ((output = br.readLine()) != null) {
                System.out.println(output);
                responseData.append(output);
            }



            String jsonData = responseData.toString();

            if (jsonData.contains("\"cod\":\"200\"")) {
                stadt = getValueFromJSON(jsonData, "name");
                double temperature = Double.parseDouble(getValueFromJSON(jsonData, "temp"));
                temperatur = temperature - 273.15;
                beschreibung = getValueFromJSON(jsonData, "description");
                conn.disconnect();
            } else {
                System.out.println("Fehler bei der API-Anfrage.");
            }
        } catch (Exception e) {
            System.out.println("Exception in NetClientGet: " + e);
        }

        // GUI erstellen und anzeigen
        String finalStadt = stadt;
        double finalTemperatur = temperatur;
        String finalBeschreibung = beschreibung;
        SwingUtilities.invokeLater(() -> {
            Gui gui = new Gui(finalStadt, finalTemperatur, finalBeschreibung);
            gui.setVisible(true);
        });
    }

    private static String getValueFromJSON(String jsonData, String key) {
        if (key.equals("temp")) {
            int startIndex = jsonData.indexOf("\"temp\":") + 7;
            int endIndex = jsonData.indexOf(",", startIndex);
            String tempData = jsonData.substring(startIndex, endIndex);
            return getValueFromJSON(tempData, "day");
        } else {
            int startIndex = jsonData.indexOf("\"" + key + "\":") + key.length() + 3;
            int endIndex = jsonData.indexOf("\"", startIndex);
            return jsonData.substring(startIndex, endIndex);
        }
    }


}