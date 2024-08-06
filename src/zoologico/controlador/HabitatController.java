package zoologico.controlador;

import zoologico.dao.HabitatDAO;
import zoologico.modelo.Habitat;
import java.sql.SQLException;
import java.util.List;

public class HabitatController {
    private HabitatDAO dao = new HabitatDAO();

    public void agregarHabitat(Habitat habitat) throws SQLException {
        dao.insertar(habitat);
    }

    public List<Habitat> obtenerTodosLosHabitats() throws SQLException {
        return dao.obtenerTodos();
    }

    // Podemos agregar más métodos aquí según sea necesario. Mirar ejemplo AlimentosController
}