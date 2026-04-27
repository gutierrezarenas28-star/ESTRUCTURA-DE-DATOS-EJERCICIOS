/*3. Editor de Capas (Diseño Gráfico)

Los editores gráficos organizan el diseño en capas. El usuario navega a la capa superior (`siguiente`) o inferior (`anterior`) y puede ocultar o mostrar cada capa. La estructura es circular: después de la capa más alta vuelve a la más baja.

- **La Clase Capa (Nodo):** Debe contener `nombre` (String), `visible` (boolean) y `tipo` (String — "fondo", "objeto", "texto").
- **El Problema:** El editor mantiene un puntero `capaActiva` a la capa seleccionada. El usuario puede moverse entre capas, alternar la visibilidad de la activa y eliminarla (el foco pasa a la siguiente).
- **Reto:** Implementa los métodos `subirCapa()`, `bajarCapa()`, `toggleVisibilidad()`, `eliminarActiva()` y `mostrarCapas()`. `mostrarCapas()` imprime todas las capas marcando la activa con `[✓]` e indicando si cada una es visible. Simula: crea 4 capas, activa la del medio, sube una vez, oculta la activa, elimínala y muestra el estado final. */

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EditorCapas editor = new EditorCapas();
        int opcion;

        do {
            System.out.println("\n==============================================");
            System.out.println("   Editor de Capas — Menú Principal");
            System.out.println("==============================================");
            System.out.println("1. Agregar capa");
            System.out.println("2. Subir capa");
            System.out.println("3. Bajar capa");
            System.out.println("4. Mostrar capa activa");
            System.out.println("5. Ocultar / Mostrar capa activa");
            System.out.println("6. Eliminar capa activa");
            System.out.println("7. Mostrar todas las capas");
            System.out.println("8. Cargar ejemplo");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre de la capa: ");
                    String nombre = sc.nextLine();

                    System.out.print("¿Está visible? (true/false): ");
                    boolean visible = sc.nextBoolean();
                    sc.nextLine();

                    System.out.print("Tipo de capa (fondo/objeto/texto): ");
                    String tipo = sc.nextLine();

                    editor.agregarCapa(nombre, visible, tipo);
                    System.out.println("Capa agregada.");
                    break;

                case 2:
                    editor.subirCapa();
                    break;

                case 3:
                    editor.bajarCapa();
                    break;

                case 4:
                    editor.mostrarActiva();
                    break;

                case 5:
                    editor.toggleVisibilidad();
                    break;

                case 6:
                    editor.eliminarActiva();
                    break;

                case 7:
                    editor.mostrarCapas();
                    break;

                case 8:
                    editor = new EditorCapas();
                    editor.agregarCapa("Fondo azul", true, "fondo");
                    editor.agregarCapa("Logo", true, "objeto");
                    editor.agregarCapa("Título principal", true, "texto");
                    editor.agregarCapa("Iconos", true, "objeto");

                    editor.bajarCapa();        // activa una capa del medio
                    editor.subirCapa();        // sube una vez
                    editor.toggleVisibilidad();// oculta la activa
                    editor.eliminarActiva();   // elimina la activa

                    System.out.println("Ejemplo cargado y simulado.");
                    editor.mostrarCapas();
                    break;

                case 0:
                    System.out.println("¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0);

        sc.close();
    }
}
