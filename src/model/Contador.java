package model;

/**
 * Clase modelo que representa un contador con 3 atributos básicos:
 * - número de identificación
 * - ubicación
 * - ID del cliente asociado
 */
public class Contador {
    private String numeroIdentificacion;
    private String ubicacion;
    private String idClienteAsociado;

    public Contador(String numeroIdentificacion, String ubicacion, String idClienteAsociado) {
        this.numeroIdentificacion = numeroIdentificacion;
        this.ubicacion = ubicacion;
        this.idClienteAsociado = idClienteAsociado;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getIdClienteAsociado() {
        return idClienteAsociado;
    }
}
