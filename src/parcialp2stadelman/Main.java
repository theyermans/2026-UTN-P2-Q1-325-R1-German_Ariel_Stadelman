/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package parcialp2stadelman;

import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author yerman
 */
public class Main {
    private static GestorColeccion gestor = new GestorColeccion();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        cargarDatosDePrueba();
        int opcion = 0;

        do {
            mostrarMenu();
            opcion = Validador.leerEntero("Seleccione una opcion: ");
            procesarOpcion(opcion);
        } while (opcion != 9);
    }

    private static void mostrarMenu() {
        System.out.println("\n=============================================");
        System.out.println("   SISTEMA DE GESTION         ");
        System.out.println("=============================================");
        System.out.println("1. Registrar un nuevo viaje (solicitando datos por consola)");
        System.out.println("2. Mostrar todos los viajes realizados");
        System.out.println("3. Ordenar los viajes por costo");
        System.out.println("4. Ordenar los viajes por nombre de pasajero");
        System.out.println("5. Mostrar el total recaudado");

        System.out.println("9. Salir");
        System.out.println("=============================================");
    }

    private static void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                menuRegistrarViaje();
                break;
            case 2:
                mostrarLista(gestor.obtenerTodos(), "Viajes Realizados");
                break;
            case 3:
                gestor.obtenerOrdenadosPorCostoDesc();
                break;
            case 4:
                gestor.obtenerOrdenadosPorNombreAsc();
                break;
            case 5:
                System.out.println("Caja");
                System.out.println("Pasajes: "+ gestor.obtenerTodos().size());
                System.out.println("Recaudado: "+ String.format("%.2f",gestor.calcularTotalRecaudado()));
                break;
            case 6:
                
                break;
            case 7:
                
                break;
            case 8:
                cargarDatosDePrueba();
                System.out.println("Datos recargados.");
                break;
            case 9:
                System.out.println("Saliendo del sistema...");
                break;
            default:
                System.out.println("Opción invalida.");
        }
    }

    private static void menuRegistrarViaje() {
        System.out.println("\n--- REGISTRAR NUEVO VIAJE / EMISION DE PASAJE ---");
        
        // 1. Validar ID Único
        String id = Validador.leerStringNoVacio("Ingrese ID/Código Único de Pasaje (Ej: PAS-999): ");
        if (gestor.buscarPorId(id) != null) {
            System.out.println(" Error: Ya existe un pasaje emitido con ese ID.");
            return;
        }

        // 2. Carga del Pasajero
        String pasajero = Validador.leerStringNoVacio("Ingrese el Nombre del Pasajero: ");

        // 3. Creación y Validación del Vehículo
        System.out.println("\nSeleccione el Medio de Transporte:");
        System.out.println("1. Colectivo");
        System.out.println("2. Tren");
        System.out.println("3. Subte");
        int tipoVehiculo = Validador.leerEntero("Seleccione opción: ");
        if (!Validador.esRangoValido(tipoVehiculo, 1, 3)) {
            System.out.println("Tipo de transporte invalido. Cancelando registro.");
            return;
        }

        String patente = Validador.leerStringNoVacio("Ingrese Patente del Vehiculo: ");
        String empresa = Validador.leerStringNoVacio("Ingrese Empresa de Transporte: ");
        
        int capacidad = -1;
        while (!Validador.esCapacidadValida(capacidad)) {
            capacidad = Validador.leerEntero("Ingrese la capacidad del vehiculo (> 0): ");
            if (!Validador.esCapacidadValida(capacidad)) {
                System.out.println("Capacidad no valida. Debe ser mayor a 0.");
            }
        }

        double costoSugerido = -1.0;
        while (!Validador.esCostoBaseValido(costoSugerido)) {
            costoSugerido = Validador.leerDouble("Ingrese Costo de Tarifa Sugerido: ");
            if (!Validador.esCostoBaseValido(costoSugerido)) {
                System.out.println(" El costo sugerido debe ser mayor a 0.");
            }
        }

        // Instanciación del vehículo adecuado
        VehiculoTransporte vehiculo = null;
        if (tipoVehiculo == 1) {
            vehiculo = new Colectivo(patente, capacidad, empresa, costoSugerido);
        } else if (tipoVehiculo == 2) {
            vehiculo = new Tren(patente, capacidad, empresa, costoSugerido);
        } else if (tipoVehiculo == 3) {
            vehiculo = new Subte(patente, capacidad, empresa, costoSugerido);
        }

        // 4. Selección del Tipo de Pasaje
        System.out.println("\nSeleccione el Tipo de Pasaje:");
        System.out.println("1. Pasaje Comun (Paga tarifa base)");
        System.out.println("2. Pasaje Estudiante (50% de descuento)");
        System.out.println("3. Pasaje Jubilado (75% de descuento)");
        int tipoPasaje = Validador.leerEntero("Seleccione opción: ");
        if (!Validador.esRangoValido(tipoPasaje, 1, 3)) {
            System.out.println("Tipo de pasaje invalido. Cancelando registro.");
            return;
        }

        // Instanciación del pasaje polimórfico
        PasajeBase pasaje = null;
        if (tipoPasaje == 1) {
            pasaje = new PasajeComun(id, pasajero, vehiculo);
        } else if (tipoPasaje == 2) {
            pasaje = new PasajeEstudiante(id, pasajero, vehiculo);
        } else if (tipoPasaje == 3) {
            pasaje = new PasajeJubilado(id, pasajero, vehiculo);
        }

        // Guardado definitivo en la colección
        if (gestor.agregarElemento(pasaje)) {
            System.out.println("\nPasaje emitido con exito.");
            System.out.println("Detalles del viaje:");
            System.out.println(pasaje);
            pasaje.mostrarDetalleEspecifico();
        }
    }

    private static void mostrarLista(ArrayList<PasajeBase> listaAMostrar, String titulo) {
        System.out.println("\n===== " + titulo + " =====");
        if (listaAMostrar.isEmpty()) {
            System.out.println("No hay viajes registrados en el sistema.");
            return;
        }
        for (int i = 0; i < listaAMostrar.size(); i++) {
            System.out.println((i + 1) + ". " + listaAMostrar.get(i));
        }
        System.out.println("Total de viajes: " + listaAMostrar.size());
    }
/*
    private static void menuBuscar() {
        System.out.println("\n--- BÚSQUEDA ---");
        String id = Validador.leerStringNoVacio("Ingrese el ID: ");
        VehiculoTransporte buscado = gestor.buscarPorId(id);

        if (buscado != null) {
            System.out.println("\n🔍 Encontrado: " + buscado);
            buscado.calcularCostoBase();
        } else {
            System.out.println("❌ No encontrado.");
        }
    }*/



    private static void cargarDatosDePrueba() {
        VehiculoTransporte v1 = new Colectivo("AA123BB", 45, "Mercedes Benz",200.0 );
        VehiculoTransporte v2 = new Colectivo("BB123AA", 50, "Ford", 220.0);
        VehiculoTransporte v3 = new Tren("CCC123AA", 150, "Roca", 300.0);
        VehiculoTransporte v4 = new Subte("DDD123AA", 200, "C", 150.0);
       
        
        
        
        if (gestor.buscarPorId("PAS-101") == null) {
            gestor.agregarElemento(new PasajeComun("PAS-101", "Ger", v1));
        }
        if (gestor.buscarPorId("PAS-102") == null) {
            gestor.agregarElemento(new PasajeEstudiante("PAS-102", "juan", v2));
        }
        if (gestor.buscarPorId("PAS-103") == null) {
            gestor.agregarElemento(new PasajeJubilado("PAS-103", "pepito", v3));
        }
        if (gestor.buscarPorId("PAS-104") == null) {
            gestor.agregarElemento(new PasajeEstudiante("PAS-104", "lucas", v4));
        }
    }

    

    
}