package zoologico.dao;

import zoologico.modelo.Habitat;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HabitatDAO {
    private static final String INSERT_HABITAT = "INSERT INTO habitats (tamanio, temperatura, tipo_habitat, tipo_suelo, descripcion) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_ALL_HABITATS = "SELECT * FROM habitats";

    public void insertar(Habitat habitat) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(INSERT_HABITAT)) {
            pstmt.setString(1, habitat.getTamanio());
            pstmt.setString(2, habitat.getTemperatura());
            pstmt.setString(3, habitat.getTipoHabitat());
            pstmt.setString(4, habitat.getTipoSuelo());
            pstmt.setString(5, habitat.getDescripcion());
            pstmt.executeUpdate();
        }
    }

    public List<Habitat> obtenerTodos() throws SQLException {
        List<Habitat> habitats = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SELECT_ALL_HABITATS)) {
            while (rs.next()) {
                Habitat habitat = new Habitat(
                    rs.getString("tamanio"),
                    rs.getString("temperatura"),
                    rs.getString("tipo_habitat"),
                    rs.getString("tipo_suelo"),
                    rs.getString("descripcion")
                );
                habitat.setId(rs.getInt("id"));
                habitats.add(habitat);
            }
        }
        return habitats;
    }

    // Podemos agregar más métodos CRUD aquí según sea necesario. Mirar ejemplo de AlimentosDAO
}