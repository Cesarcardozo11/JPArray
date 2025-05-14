package main;
import model.Contador;
import view.ContadorVista;
import controller.ContadorControlador;

/**
 * Clase principa m,.{
 * +}l que inicializa el sistema, agrega contadores
 * y solicita la visualización de los mismos.
 */
public class Principal {
    public static void main(String[] args) {

        // 1. Crear una instancia del Modelo
        SistemaGestionModel objModelo = new SistemaGestionModel(100, 50, 1000); // Ejemplo de capacidades iniciales

        // 2. Crear una instancia de la Vista
        SistemaGestionView objVista = new SistemaGestionView();

        // 3. Crear una instancia del Controlador, pasándole el Modelo y la Vista
        SistemaGestionController objControlador = new SistemaGestionController(objModelo, objVista);

        // 4. Iniciar la aplicación a través del Controlador
        objControlador.mEjecutarAplicacion();

        // Crear la vista
        ContadorVista vista = new ContadorVista();

        // Crear el controlador con capacidad para 5 contadores
        ContadorControlador controlador = new ContadorControlador(5, vista);

        // Agregar contadores al sistema
        controlador.agregarContador(new Contador("1001", "Zona Norte", "5001"));
        controlador.agregarContador(new Contador("1002", "Zona Sur", "5002"));
        controlador.agregarContador(new Contador("1003", "Zona Este", "5003"));

        // Mostrar todos los contadores almacenados
        controlador.mostrarTodos();
    }
}


