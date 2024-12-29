package aplikasipenjualanbuku.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/PenjualanBuku";
    private static final String USER = "root"; // Ganti sesuai username MySQL kamu
    private static final String PASSWORD = ""; // Ganti sesuai password MySQL kamu

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
