package model;
import View.ContadorVista;

import java.util.Scanner;

import Controller.FranjasControlador;
import Controller.SistemaGestionController;
import View.FranjaVista;
import View.SistemaGestionView;
import Controller.ContadorControlador;

public class Principal {
    private static Scanner objScanner;

    public static void main(String[] args) {
        // Inicializar el Scanner
        objScanner = new Scanner(System.in);

        // 1. Crear una instancia del Modelo
        SistemaGestionModel objModelo = new SistemaGestionModel(100, 50, 1000);

        // 2. Crear una instancia de la Vista
        SistemaGestionView objVista = new SistemaGestionView();

        // 3. Crear una instancia del Controlador principal
        SistemaGestionController objControlador = new SistemaGestionController(objModelo, objVista);

        // Crear la vista para franjas
        FranjaVista objFranjaVista = new FranjaVista(objScanner);

        // Crear el controlador para franjas
        FranjasControlador objFranjasControlador = new FranjasControlador(objFranjaVista);
        
        // Iniciar la aplicación a través del Controlador principal
        objControlador.mEjecutarAplicacion();

        // Pasar el controlador de franjas al controlador principal
        objControlador.FranjasControlador(objFranjasControlador);



        // Crear la vista para contadores
        ContadorVista vista = new ContadorVista();

        // Crear el controlador para contadores con capacidad para 5 contadores
        ContadorControlador controlador = new ContadorControlador(5, vista);

        // Agregar contadores al sistema
        controlador.agregarContador(new Contador("1001", "Zona Norte", "5001"));
        controlador.agregarContador(new Contador("1002", "Zona Sur", "5002"));
        controlador.agregarContador(new Contador("1003", "Zona Este", "5003"));

        // Mostrar todos los contadores almacenados
        controlador.mostrarTodos();

        // Ejecutar la lógica principal del controlador de contadores
        controlador.ejecutar();
    }
}