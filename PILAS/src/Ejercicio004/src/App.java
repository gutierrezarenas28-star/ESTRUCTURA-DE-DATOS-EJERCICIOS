/*4. Farmacia Automatizada (Dispensador Tubo LIFO)
En una farmacia de alta tecnología, los medicamentos de alta rotación se almacenan en tubos dispensadores verticales. El personal introduce las cajas por la parte superior y las retira de la misma forma (el último lote en llegar es el primero en ser despachado).
- **La Clase Medicamento (Nodo):** Debe contener `nombre` (String), `lote` (String) y `diasParaVencer` (int).
- **El Problema:** Por norma de seguridad, no se puede despachar un medicamento si le quedan menos de 10 días para vencer.
- **Reto:** Implementa un método `validarDespacho()` que revise el medicamento en el **tope**. Si está a punto de vencer, debe ser retirado automáticamente y el sistema debe revisar el siguiente. El proceso se repite hasta que el tope sea un medicamento seguro o la pila quede vacía. */

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        PilaMedicamentos dispensador = new PilaMedicamentos();
        Scanner scanner = new Scanner(System.in);

        // Datos de prueba
        dispensador.push(new Medicamento("Acetaminofén", "LOT-001", 45));
        dispensador.push(new Medicamento("Ibuprofeno", "LOT-002", 30));
        dispensador.push(new Medicamento("Amoxicilina", "LOT-003", 8));
        dispensador.push(new Medicamento("Loratadina", "LOT-004", 5));
        dispensador.push(new Medicamento("Omeprazol", "LOT-005", 20));

        int opcion;

        do {
            System.out.println("\n--- FARMACIA AUTOMATIZADA (PILAS) ---");
            System.out.println("1. Ver medicamentos en el dispensador");
            System.out.println("2. Registrar nuevo medicamento (Push)");
            System.out.println("3. Despachar medicamento seguro");
            System.out.println("4. Validar medicamento del tope");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:
                    dispensador.imprimir();
                    break;

                case 2:
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Lote: ");
                    String lote = scanner.nextLine();

                    System.out.print("Días para vencer: ");
                    int dias = scanner.nextInt();

                    dispensador.push(new Medicamento(nombre, lote, dias));

                    System.out.println("Medicamento agregado correctamente.");
                    break;

                case 3:
                    Medicamento seguro = dispensador.validarDespacho();

                    if (seguro != null) {
                        System.out.println("Medicamento despachado: " + seguro);
                    } else {
                        System.out.println("No hay medicamentos seguros para despachar.");
                    }
                    break;

                case 4:
                    Medicamento disponible = dispensador.validarDespachoSinRetirarSeguro();

                    if (disponible != null) {
                        System.out.println("Medicamento seguro en el tope: " + disponible);
                    } else {
                        System.out.println("La pila quedó vacía o no hay medicamento seguro.");
                    }
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
