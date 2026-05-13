/*3. Logística de Distribución (Callejón sin Salida)
Un centro de logística urbana tiene un muelle de carga ubicado al final de un callejón muy estrecho. Los camiones de reparto entran uno tras otro y quedan "atrapados" en el orden de llegada. El último camión en entrar debe ser obligatoriamente el primero en salir para permitir que los demás se retiren.
- **La Clase Camion (Nodo):** Debe contener `placa` (String), `conductor` (String) y `cargaToneladas` (double).
- **El Problema:** El supervisor necesita saber cuánta carga total hay en el callejón sin mover los camiones físicamente (solo consultando la estructura).
- **Reto:** Implementa un método que recorra la pila (sin destruirla permanentemente, o reconstruyéndola) y calcule la suma total de `cargaToneladas` de todos los camiones estacionados. */

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        PilaCamiones callejon = new PilaCamiones();
        Scanner scanner = new Scanner(System.in);

        // Datos de prueba
        callejon.push(new Camion("ABC-123", "Carlos Pérez", 12.5));
        callejon.push(new Camion("DEF-456", "María Gómez", 8.3));
        callejon.push(new Camion("GHI-789", "Juan Torres", 15.0));
        callejon.push(new Camion("JKL-321", "Ana Ruiz", 10.7));

        int opcion;

        do {

            System.out.println("\n--- LOGÍSTICA DE DISTRIBUCIÓN (PILAS) ---");
            System.out.println("1. Ver camiones estacionados");
            System.out.println("2. Registrar nuevo camión (Push)");
            System.out.println("3. Retirar camión del tope (Pop)");
            System.out.println("4. Calcular carga total");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:

                    callejon.imprimir();
                    break;

                case 2:

                    System.out.print("Placa: ");
                    String placa = scanner.nextLine();

                    System.out.print("Conductor: ");
                    String conductor = scanner.nextLine();

                    System.out.print("Carga en toneladas: ");
                    double carga = scanner.nextDouble();

                    callejon.push(new Camion(placa, conductor, carga));

                    System.out.println("Camión agregado correctamente.");
                    break;

                case 3:

                    Camion retirado = callejon.pop();

                    if (retirado != null) {
                        System.out.println("Se retiró el camión: " + retirado);
                    } else {
                        System.out.println("El callejón está vacío.");
                    }

                    break;

                case 4:

                    double total = callejon.calcularCargaTotal();

                    System.out.println("Carga total en el callejón: "
                            + total + " toneladas");

                    break;

                case 5:

                    System.out.println("Saliendo del sistema...");
                    break;

                default:

                    System.out.println("Opción inválida.");
            }

        } while (opcion != 5);

        scanner.close();
    

    }
}
