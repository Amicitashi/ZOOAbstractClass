package zoologico.modelo;

public class Animales {
    private int id;
    private String nombre;
    private String tipoClima;
    private boolean enPeligro;
    private boolean vacunado;
    private String enfermedades;

    public Animales(String nombre, String tipoClima) {
        this.nombre = nombre;
        this.tipoClima = tipoClima;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoClima() {
        return tipoClima;
    }

    public void setTipoClima(String tipoClima) {
        this.tipoClima = tipoClima;
    }

    public boolean isEnPeligro() {
        return enPeligro;
    }

    public void setEnPeligro(boolean enPeligro) {
        this.enPeligro = enPeligro;
    }

    public boolean isVacunado() {
        return vacunado;
    }

    public void setVacunado(boolean vacunado) {
        this.vacunado = vacunado;
    }

    public String getEnfermedades() {
        return enfermedades;
    }

    public void setEnfermedades(String enfermedades) {
        this.enfermedades = enfermedades;
    }
}