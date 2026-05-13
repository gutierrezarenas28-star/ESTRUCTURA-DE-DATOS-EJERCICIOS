/*2. Control de Calidad (Línea de Ensamblaje)
Un brazo robótico en una fábrica de motores apila componentes siguiendo una secuencia precisa. Un sensor de visión artificial inspecciona cada pieza después de ser colocada.
- **La Clase Pieza (Nodo):** Debe contener `nombrePieza` (String), `numeroSerie` (String) y `esDefectuosa` (boolean).
- **El Problema:** Si el sensor detecta una pieza defectuosa, la línea de producción debe detenerse inmediatamente.
- **Reto:** Crea un método `limpiarHastaDefecto()` que extraiga (`pop`) todas las piezas de la pila hasta encontrar la primera que tenga `esDefectuosa = true`. El método debe imprimir el nombre de todas las piezas "buenas" que tuvieron que ser retiradas y descartadas antes de llegar a la pieza fallida. */

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        PilaProduccion linea = new PilaProduccion();
        Scanner scanner = new Scanner(System.in);

        // Datos de prueba
        linea.push(new Pieza("Pistón", "SER-001", false));
        linea.push(new Pieza("Biela", "SER-002", false));
        linea.push(new Pieza("Cigüeñal", "SER-003", false));
        linea.push(new Pieza("Válvula", "SER-004", true)); // Pieza defectuosa
        linea.push(new Pieza("Tornillo", "SER-005", false));
        linea.push(new Pieza("Tuerca", "SER-006", false));

        int opcion;

        do {
            System.out.println("\n--- CONTROL DE CALIDAD (PILAS) ---");
            System.out.println("1. Ver línea de ensamblaje");
            System.out.println("2. Registrar nueva pieza (Push)");
            System.out.println("3. Retirar pieza del tope (Pop)");
            System.out.println("4. Ejecutar limpieza hasta defecto");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:
                    System.out.println("\nEstado actual de la pila:");
                    linea.imprimir();
                    break;

                case 2:
                    System.out.print("Nombre de la pieza: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Número de serie: ");
                    String serie = scanner.nextLine();

                    System.out.print("¿Es defectuosa? (true/false): ");
                    boolean defecto = scanner.nextBoolean();

                    linea.push(new Pieza(nombre, serie, defecto));

                    System.out.println("Pieza apilada correctamente.");
                    break;

                case 3:
                    Pieza retirada = linea.pop();

                    if (retirada != null) {
                        System.out.println("Se retiró: " + retirada);
                    } else {
                        System.out.println("La pila está vacía.");
                    }
                    break;

                case 4:
                    linea.limpiarHastaDefecto();
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
