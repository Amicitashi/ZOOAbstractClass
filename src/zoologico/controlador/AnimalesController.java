package zoologico.controlador;

import zoologico.dao.AnimalesDAO;
import zoologico.modelo.Animales;

import java.sql.SQLException;
import java.util.List;

public class AnimalesController {
    private AnimalesDAO dao = new AnimalesDAO();

    public void agregarAnimal(Animales animal) throws SQLException {
        dao.insertar(animal);
    }

    public List<Animales> obtenerTodosLosAnimales() throws SQLException {
        return dao.obtenerTodos();
    }

    // Podemos agregar más métodos aquí según sea necesario. Mirar ejemplo AlimentosController
}