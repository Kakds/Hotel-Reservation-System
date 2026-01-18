import java.sql.Connection;
import java.sql.DriverManager;
public class DBConnection {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/hotel",
                    "postgres",
                    "1234"
            );
            System.out.println("Connected successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
