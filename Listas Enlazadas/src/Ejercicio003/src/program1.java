/*3. Torre de Control (Aterrizajes de Emergencia)
Simula la cola de aviones esperando para aterrizar en un aeropuerto congestionado.
- **La Clase Vuelo (Nodo):** Debe contener `numeroVuelo` (String), `aerolinea` (String), `combustibleRestante` (int) y `pasajeros` (int).
- **El Problema:** Normalmente los vuelos se forman al final de la cola. Sin embargo, si un vuelo reporta menos de 10 unidades de combustible, debe ser movido inmediatamente al **inicio** de la lista (Cabeza).
- **Reto:** Implementar el método `reportarEmergencia(String numeroVuelo)` que busque un vuelo en la cola y lo mueva al principio. */

import java.util.Scanner;

public class program1 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        ColaVuelo cola = new ColaVuelo();

        do {
            System.out.println("\n==========================================");
            System.out.println("     TORRE DE CONTROL - Menu Principal");
            System.out.println("==========================================");
            System.out.println("1. Ingresar vuelo");
            System.out.println("2. Mostrar vuelos");
            System.out.println("3. Reportar emergencia");
            System.out.println("0. Salir");
            System.out.println("==========================================");
            System.out.print("Elige una opcion: ");

            if (sc.hasNextInt()) {
                opcion = sc.nextInt();
                sc.nextLine();
            } else {
                System.out.println("Debes ingresar un numero.");
                sc.nextLine();
                opcion = -1;
            }

            switch (opcion) {
                case 1:
                    System.out.print("Numero de vuelo: ");
                    String numeroVuelo = sc.nextLine();

                    System.out.print("Aerolinea: ");
                    String aerolinea = sc.nextLine();

                    System.out.print("Combustible restante: ");
                    int combustibleRestante = sc.nextInt();

                    System.out.print("Pasajeros: ");
                    int pasajeros = sc.nextInt();
                    sc.nextLine();

                    Vuelo nuevoVuelo = new Vuelo(numeroVuelo, aerolinea, combustibleRestante, pasajeros);
                    cola.ingresarVuelo(nuevoVuelo);
                    System.out.println("Vuelo ingresado con exito.");
                    break;

                case 2:
                    System.out.println("Lista de vuelos en espera:");
                    cola.mostrarVuelos();
                    break;

                case 3:
                    System.out.print("Ingrese el numero de vuelo en emergencia: ");
                    String vueloEmergencia = sc.nextLine();
                    cola.reportarEmergencia(vueloEmergencia);
                    break;

                case 0:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opcion no valida.");
            }

        } while (opcion != 0);

        sc.close();
    }
    
}
