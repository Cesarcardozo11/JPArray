package View;

import model.Cliente;

import java.util.List;
import java.util.Scanner;

public class SistemaGestionView {
    private Scanner scanner = new Scanner(System.in);

    public void mMostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public Cliente mSolicitarDatosCliente() {
        System.out.println("Ingrese el número de identificación del cliente:");
        String numeroIdentificacion = scanner.nextLine();
        System.out.println("Ingrese el nombre del cliente:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese la dirección del cliente:");
        String direccion = scanner.nextLine();
        return new Cliente(numeroIdentificacion, nombre, direccion);
    }

    public String mSolicitarIdCliente() {
        System.out.println("Ingrese el número de identificación del cliente:");
        return scanner.nextLine();
    }

    public Cliente mSolicitarDatosEdicionCliente(Cliente objCliente) {
        System.out.println("Editando cliente con ID: " + objCliente.getNumeroIdentificacion());
        System.out.println("Ingrese el nuevo nombre (deje en blanco para no cambiar):");
        String nuevoNombre = scanner.nextLine();
        if (!nuevoNombre.isEmpty()) {
            objCliente.setNombre(nuevoNombre);
        }
        System.out.println("Ingrese la nueva dirección (deje en blanco para no cambiar):");
        String nuevaDireccion = scanner.nextLine();
        if (!nuevaDireccion.isEmpty()) {
            objCliente.setDireccion(nuevaDireccion);
        }
        return objCliente;
    }

    public void mMostrarListaClientes(List<Cliente> listaClientes) {
        System.out.println("Listado de clientes:");
        for (Cliente cliente : listaClientes) {
            System.out.println(cliente);
        }
    }

    // Métodos para solicitar/mostrar información de otras entidades (Registrador, Consumo, etc.)
    // Métodos para mostrar el menú principal y obtener la opción del usuario
    public void mMostrarMenuPrincipal() { /* ... */ }
    public int mObtenerOpcionMenu() {
        System.out.println("Ingrese una opción del menú:");
        return scanner.nextInt();
    }
    public void cerrarScanner() { /* ... */ }
}
