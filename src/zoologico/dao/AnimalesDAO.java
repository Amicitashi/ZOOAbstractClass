package zoologico.dao;

import zoologico.modelo.Animales;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnimalesDAO {
    private static final String INSERT_ANIMAL = "INSERT INTO animales (nombre, tipo_clima, en_peligro, vacunado, enfermedades) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_ALL_ANIMALES = "SELECT * FROM animales";

    public void insertar(Animales animal) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(INSERT_ANIMAL)) {
            pstmt.setString(1, animal.getNombre());
            pstmt.setString(2, animal.getTipoClima());
            pstmt.setBoolean(3, animal.isEnPeligro());
            pstmt.setBoolean(4, animal.isVacunado());
            pstmt.setString(5, animal.getEnfermedades());
            pstmt.executeUpdate();
        }
    }

    public List<Animales> obtenerTodos() throws SQLException {
        List<Animales> animales = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SELECT_ALL_ANIMALES)) {
            while (rs.next()) {
                Animales animal = new Animales(rs.getString("nombre"), rs.getString("tipo_clima"));
                animal.setId(rs.getInt("id"));
                animal.setEnPeligro(rs.getBoolean("en_peligro"));
                animal.setVacunado(rs.getBoolean("vacunado"));
                animal.setEnfermedades(rs.getString("enfermedades"));
                animales.add(animal);
            }
        }
        return animales;
    }

    // Podemos agregar más métodos CRUD aquí según sea necesario. Mirar ejemplo de AlimentosDAO
}