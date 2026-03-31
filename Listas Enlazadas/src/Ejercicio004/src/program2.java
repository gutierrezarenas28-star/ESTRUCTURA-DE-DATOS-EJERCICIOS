/*4. Monitoreo Industrial (Sensores en Tiempo Real)
Una planta química registra lecturas de sus tanques cada hora en una lista enlazada para auditoría.
- **La Clase Lectura (Nodo):** Debe contener `idSensor` (int), `temperatura` (double), `presion` (double) y `hora` (String).
- **El Problema:** Las lecturas se van agregando al inicio para que la más reciente sea siempre la primera que vea el supervisor.
- **Reto:** Implementa un método que busque y muestre la lectura con la **temperatura más alta** registrada en el historial. */

import java.util.Scanner;

public class program2 {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int opcion;

        ListaLectura historial = new ListaLectura();

        do {
            System.out.println("\n==========================================");
            System.out.println("   MONITOREO INDUSTRIAL - Menu Principal");
            System.out.println("==========================================");
            System.out.println("1. Nueva lectura");
            System.out.println("2. Mostrar todas las lecturas");
            System.out.println("3. Mostrar lectura con mayor temperatura");
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
                    System.out.print("Id del sensor: ");
                    int idSensor = sc.nextInt();

                    System.out.print("Temperatura: ");
                    double temperatura = sc.nextDouble();

                    System.out.print("Presion: ");
                    double presion = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Hora: ");
                    String hora = sc.nextLine();

                    Lectura nuevaLectura = new Lectura(idSensor, temperatura, presion, hora);
                    historial.ingresarLectura(nuevaLectura);
                    System.out.println("Lectura registrada con exito.");
                    break;

                case 2:
                    System.out.println("Historial de lecturas:");
                    historial.mostrarLecturas();
                    break;

                case 3:
                    historial.mostrarTemperaturaMasAlta();
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
