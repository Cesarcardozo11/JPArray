package model;


public class SistemaGestionModel {
    private Cliente[] matrizClientes;
    private int capacidadMaximaClientes;
    private int cantidadClientes;

    public SistemaGestionModel(int capacidadInicialClientes, int i, int j) {
        this.capacidadMaximaClientes = capacidadInicialClientes;
        this.matrizClientes = new Cliente[capacidadMaximaClientes];
        this.cantidadClientes = 0;
    }

    public boolean crearCliente(Cliente cliente) {
        if (cantidadClientes < capacidadMaximaClientes) {
            matrizClientes[cantidadClientes++] = cliente;
            return true;
        }
        return false;
    }

    public Cliente obtenerCliente(String idCliente) {
        for (int i = 0; i < cantidadClientes; i++) {
            if (matrizClientes[i].getNumeroIdentificacion().equals(idCliente)) {
                return matrizClientes[i];
            }
        }
        return null;
    }

    public boolean actualizarCliente(Cliente clienteActualizado) {
        for (int i = 0; i < cantidadClientes; i++) {
            if (matrizClientes[i].getNumeroIdentificacion().equals(clienteActualizado.getNumeroIdentificacion())) {
                matrizClientes[i].setNombre(clienteActualizado.getNombre());
                matrizClientes[i].setDireccion(clienteActualizado.getDireccion());
                return true;
            }
        }
        return false;
    }

    public Cliente[] obtenerTodosClientes() {
        Cliente[] clientesActuales = new Cliente[cantidadClientes];
        System.arraycopy(matrizClientes, 0, clientesActuales, 0, cantidadClientes);
        return clientesActuales;
    }

    // Métodos similares para Registrador, Consumo, etc. (con sus respectivas matrices)
    
   
}