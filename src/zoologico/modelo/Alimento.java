package zoologico.modelo;

public class Alimento {
    private int id;
    private double cantidad;
    private String tipoComida;
    private String frecuenciaAlimentacion;
    private String notas;

    // Constructor completo
    public Alimento(int id, double cantidad, String tipoComida, String frecuenciaAlimentacion, String notas) {
        this.id = id;
        this.cantidad = cantidad;
        this.tipoComida = tipoComida;
        this.frecuenciaAlimentacion = frecuenciaAlimentacion;
        this.notas = notas;
    }

    // Constructor sin ID
    public Alimento(double cantidad, String tipoComida, String frecuenciaAlimentacion, String notas) {
        this.cantidad = cantidad;
        this.tipoComida = tipoComida;
        this.frecuenciaAlimentacion = frecuenciaAlimentacion;
        this.notas = notas;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public String getTipoComida() {
        return tipoComida;
    }

    public void setTipoComida(String tipoComida) {
        this.tipoComida = tipoComida;
    }

    public String getFrecuenciaAlimentacion() {
        return frecuenciaAlimentacion;
    }

    public void setFrecuenciaAlimentacion(String frecuenciaAlimentacion) {
        this.frecuenciaAlimentacion = frecuenciaAlimentacion;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }
}
