package zoologico.modelo;

public abstract class Zoo {
    protected Animales[] jaulas;
    protected String nombre;

    public Zoo(String nombre, int capacidad) {
        this.nombre = nombre;
        this.jaulas = new Animales[capacidad];
    }

    public abstract void gestionarHabitat();
    public abstract void gestionarAnimales();
    public abstract void gestionarAlimentos();

    // Métodos comunes
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return jaulas.length;
    }

    public Animales[] getJaulas() {
        return jaulas;
    }

    public void agregarAnimal(Animales animal, int posicion) {
        if (posicion >= 0 && posicion < jaulas.length) {
            jaulas[posicion] = animal;
        } else {
            throw new IndexOutOfBoundsException("Posición fuera del rango de capacidad.");
        }
    }

    public Animales obtenerAnimal(int posicion) {
        if (posicion >= 0 && posicion < jaulas.length) {
            return jaulas[posicion];
        } else {
            throw new IndexOutOfBoundsException("Posición fuera del rango de capacidad.");
        }
    }
}
