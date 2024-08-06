package zoologico.controlador;

import zoologico.dao.AlimentosDAO;
import zoologico.modelo.Alimento;

import java.sql.SQLException;
import java.util.List;

public class AlimentosController {
    private AlimentosDAO dao = new AlimentosDAO();

    public void agregarAlimento(Alimento alimento) throws SQLException {
        dao.insertar(alimento);
    }

    public void actualizarAlimento(Alimento alimento) throws SQLException {
        dao.actualizar(alimento);
    }

    public void eliminarAlimento(int id) throws SQLException {
        dao.eliminar(id);
    }

    public Alimento obtenerAlimentoPorId(int id) throws SQLException {
        return dao.obtenerPorId(id);
    }

    public List<Alimento> obtenerTodosAlimentos() throws SQLException {
        return dao.obtenerTodos();
    }
}
