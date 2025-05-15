package Controller;

import model.Cliente;
import model.SistemaGestionModel;
import View.SistemaGestionView;
import java.util.Arrays;

public class SistemaGestionController {
    private SistemaGestionModel objModelo;
    private SistemaGestionView objVista;
    private FranjasControlador objFranjasControlador; // Controlador de franjas

    public SistemaGestionController(SistemaGestionModel modelo, SistemaGestionView vista) {
        this.objModelo = modelo;
        this.objVista = vista;
        this.objFranjasControlador = null; // Inicialización como null hasta que se asigne
    }

    // Método para asignar el controlador de franjas
    public void FranjasControlador(FranjasControlador franjasControlador) {
        this.objFranjasControlador = franjasControlador;
    }

    public void mCrearNuevoCliente() {
        Cliente objNuevoCliente = objVista.mSolicitarDatosCliente();
        if (objModelo.crearCliente(objNuevoCliente)) {
            objVista.mMostrarMensaje("Cliente creado exitosamente.");
        } else {
            objVista.mMostrarMensaje("No se pudo crear el cliente (capacidad máxima alcanzada).");
        }
    }

    public void mEditarCliente() {
        String idCliente = objVista.mSolicitarIdCliente();
        Cliente objClienteAEditar = objModelo.obtenerCliente(idCliente);
        if (objClienteAEditar != null) {
            Cliente objClienteEditado = objVista.mSolicitarDatosEdicionCliente(objClienteAEditar);
            if (objModelo.actualizarCliente(objClienteEditado)) {
                objVista.mMostrarMensaje("Cliente editado exitosamente.");
            } else {
                objVista.mMostrarMensaje("Error al editar el cliente.");
            }
        } else {
            objVista.mMostrarMensaje("No se encontró el cliente con el ID proporcionado.");
        }
    }

    public void mMostrarTodosClientes() {
        Cliente[] listaClientes = objModelo.obtenerTodosClientes();
        objVista.mMostrarListaClientes(Arrays.asList(listaClientes));
    }

    // Método para calcular el consumo de energía
    public void mCalcularConsumoEnergia() {
        if (objFranjasControlador != null) {
            objFranjasControlador.mEjecutarAplicacion(); // Llama al controlador de franjas
        } else {
            objVista.mMostrarMensaje("El controlador de franjas no está configurado.");
        }
    }

    public void mEjecutarAplicacion() {
        objVista.mMostrarMensaje("Bienvenido al sistema de gestión de clientes.");
        System.out.println("\n     1. Crear Un nuevo cliente");
        System.out.println("     2. Editar un cliente");
        System.out.println("     3. Mostrar todos los clientes");
        System.out.println("     4. Calcular consumo de energia");
        System.out.println("     5. Salir");


        int opcion;
        do {
            objVista.mMostrarMenuPrincipal();
            opcion = objVista.mObtenerOpcionMenu();

            switch (opcion) {
                
                case 1:
                    mCrearNuevoCliente();
                    break;
                case 2:
                    mEditarCliente();
                    break;
                case 3:
                    mMostrarTodosClientes();
                    break;
                case 4:
                    mCalcularConsumoEnergia();
                    break;
                case 5:
                    objVista.mMostrarMensaje("Saliendo del sistema.");
                    break;
                default:
                    objVista.mMostrarMensaje("Opción inválida.");
            }
        } while (opcion != 5);
        objVista.cerrarScanner();
    }
}