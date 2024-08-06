package zoologico.dao;

import java.sql.Connection;
import java.sql.SQLException;
import zoologico.dao.DatabaseConnection;

public class TestConnection {
    public static void main(String[] args) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            if (conn != null) {
                System.out.println("Conexión exitosa a la base de datos.");
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al conectar a la base de datos.");
        }
    }
}


// Prueba de conexion BD