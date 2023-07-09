
import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;


public class Datenbank {

    private final String url = "jdbc:postgresql://db.uywojsmimxjekbzunkoe.supabase.co/postgres";
    private final String user = "postgres";
    private final String password = "lol";

    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Funktioniert :)");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }


    public static void main(String[] args) {
        Datenbank app = new Datenbank();
        app.connect();
        app.insertWeatherData();
    }

    public void insertWeatherData() {
        int temp = 10;
        int humidity = 20;
        int windspeedlol = 231;
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
        ) {
            // Execute a query
            System.out.println("Inserting records into the table...");
            Timestamp timestampp = new Timestamp(System.currentTimeMillis());
            String SQL = "INSERT INTO archiv(description, temp, humidity, wind_speed) VALUES ('oh yeah', 20.1, 30, 50.2)";
            stmt.executeUpdate(SQL);
            System.out.println("Inserted records into the table...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}