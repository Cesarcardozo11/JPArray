package View;

/**
 * Clase vista que se encarga únicamente de mostrar la información
 * almacenada en la matriz de contadores.
 */
public class ContadorVista {

    /**
     * Recorre la matriz y muestra todos los contadores registrados.
     * Cada fila representa un contador.
     */
    public void mostrarContadores(String[][] matrizContadores) {
        System.out.println("=== Lista de Contadores Registrados ===");
        for (int i = 0; i < matrizContadores.length; i++) {
            if (matrizContadores[i][0] != null) { // Solo mostramos si hay datos
                System.out.println("----- Contador " + (i + 1) + " -----");
                System.out.println("ID: " + matrizContadores[i][0]);
                System.out.println("Ubicación: " + matrizContadores[i][1]);
                System.out.println("ID Cliente Asociado: " + matrizContadores[i][2]);
            }
        }
        System.out.println("=======================================");
    }
}