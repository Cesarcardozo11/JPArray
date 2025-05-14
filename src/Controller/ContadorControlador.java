package Controller;

import model.Contador;
import View.ContadorVista;

/**
 * maneja la lógica de agregar y mostrar contadores y los
 * almacena en una matriz bidimensional.
 */
public class ContadorControlador {
    private String[][] matrizContadores; // Matriz [filas][columnas]
    private int indice; // Controla la cantidad de contadores agregados
    private ContadorVista vista;

    /**
     * Constructor que inicializa la matriz con una capacidad dada.
     * @param capacidad Número máximo de contadores a guardar.
     * @param vista Instancia de la clase vista para mostrar datos.
     */
    public ContadorControlador(int capacidad, ContadorVista vista) {
        matrizContadores = new String[capacidad][3]; // 3 columnas: ID, ubicación, cliente
        this.indice = 0;
        this.vista = vista;
    }

    /**
     * Agrega un contador a la matriz desde el modelo.
     * @param contador Objeto Contador que contiene los datos.
     */
    public void agregarContador(Contador contador) {
        if (indice < matrizContadores.length) {
            matrizContadores[indice][0] = contador.getNumeroIdentificacion();
            matrizContadores[indice][1] = contador.getUbicacion();
            matrizContadores[indice][2] = contador.getIdClienteAsociado();
            indice++;
        } else {
            System.out.println("Límite de contadores alcanzado.");
        }
    }

    /**
     * Muestra todos los contadores usando la vista.
     */
    public void mostrarTodos() {
        vista.mostrarContadores(matrizContadores);
    }

    public void ejecutar() {
        throw new UnsupportedOperationException("Unimplemented method 'ejecutar'");
    }

    
    

    
}
