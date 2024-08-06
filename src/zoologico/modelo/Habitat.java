package zoologico.modelo;

public class Habitat {
    private int id;
    private String tamanio;
    private String temperatura;
    private String tipoHabitat;
    private String tipoSuelo;
    private String descripcion;

    public Habitat(String tamanio, String temperatura, String tipoHabitat, String tipoSuelo, String descripcion) {
        this.tamanio = tamanio;
        this.temperatura = temperatura;
        this.tipoHabitat = tipoHabitat;
        this.tipoSuelo = tipoSuelo;
        this.descripcion = descripcion;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public String getTipoHabitat() {
        return tipoHabitat;
    }

    public void setTipoHabitat(String tipoHabitat) {
        this.tipoHabitat = tipoHabitat;
    }

    public String getTipoSuelo() {
        return tipoSuelo;
    }

    public void setTipoSuelo(String tipoSuelo) {
        this.tipoSuelo = tipoSuelo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}