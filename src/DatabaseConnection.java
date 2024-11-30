import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/ogrenci_sistemi"; // Veritabanı bağlantı URL'si
    private static final String USER = "root"; // MySQL kullanıcı adı
    private static final String PASSWORD = "2701ES23cU.1"; // MySQL şifreniz

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Veritabanı bağlantısı başarısız: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}