import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Api {

    public static void main(String[] args) {

        try {

            URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q=Regensburg&appid=HIERAPIKEYEINFÜGEN!!!!");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error code : "
                        + conn.getResponseCode());
            }
            InputStreamReader in = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(in);
            String output;
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }
            conn.disconnect();

            Gson gson = new Gson();
            WetterTag weatherData = gson.fromJson(responseData, WetterTag.class);

        } catch (Exception e) {
            System.out.println("Exception in NetClientGet:- " + e);
        }

    }

    }
