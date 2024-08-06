package zoologico.dao;

import zoologico.modelo.Alimento;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlimentosDAO {
    public void insertar(Alimento alimento) throws SQLException {
        String sql = "INSERT INTO alimentos (cantidad, tipo_comida, frecuencia_alimentacion, notas) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, alimento.getCantidad());
            pstmt.setString(2, alimento.getTipoComida());
            pstmt.setString(3, alimento.getFrecuenciaAlimentacion());
            pstmt.setString(4, alimento.getNotas());
            pstmt.executeUpdate();
        }
    }

    public void actualizar(Alimento alimento) throws SQLException {
        String sql = "UPDATE alimentos SET cantidad = ?, tipo_comida = ?, frecuencia_alimentacion = ?, notas = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, alimento.getCantidad());
            pstmt.setString(2, alimento.getTipoComida());
            pstmt.setString(3, alimento.getFrecuenciaAlimentacion());
            pstmt.setString(4, alimento.getNotas());
            pstmt.setInt(5, alimento.getId());
            pstmt.executeUpdate();
        }
    }

    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM alimentos WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }

    public Alimento obtenerPorId(int id) throws SQLException {
        String sql = "SELECT * FROM alimentos WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Alimento(
                    rs.getInt("id"),
                    rs.getDouble("cantidad"),
                    rs.getString("tipo_comida"),
                    rs.getString("frecuencia_alimentacion"),
                    rs.getString("notas")
                );
            }
            return null;
        }
    }

    public List<Alimento> obtenerTodos() throws SQLException {
        String sql = "SELECT * FROM alimentos";
        List<Alimento> alimentos = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                alimentos.add(new Alimento(
                    rs.getInt("id"),
                    rs.getDouble("cantidad"),
                    rs.getString("tipo_comida"),
                    rs.getString("frecuencia_alimentacion"),
                    rs.getString("notas")
                ));
            }
        }
        return alimentos;
    }
}
