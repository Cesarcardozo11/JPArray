package Controller;

import model.Cliente;
import model.SistemaGestionModel;
import View.SistemaGestionView;
import java.util.Arrays;

public class SistemaGestionController {
    private SistemaGestionModel objModelo;
    private SistemaGestionView objVista;

    public SistemaGestionController(SistemaGestionModel modelo, SistemaGestionView vista) {
        this.objModelo = modelo;
        this.objVista = vista;
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

    // Otros métodos para interactuar con el Modelo y la Vista para las demás funcionalidades
    // (crear/editar registrador, cargar consumos, generar factura, etc.)

    public void mMostrarTodosClientes() {
        Cliente[] listaClientes = objModelo.obtenerTodosClientes();
        objVista.mMostrarListaClientes(Arrays.asList(listaClientes));
    }

    public void mEjecutarAplicacion() {
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
                case 5: // Ejemplo de mostrar todos los clientes
                    mMostrarTodosClientes();
                    break;
                case 0:
                    objVista.mMostrarMensaje("Saliendo del sistema.");
                    break;
                default:
                    objVista.mMostrarMensaje("Opción inválida.");
            }
        } while (opcion != 0);
        objVista.cerrarScanner();
    }
}