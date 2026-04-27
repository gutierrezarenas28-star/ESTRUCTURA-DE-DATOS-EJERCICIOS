/*2. Historial de Comandos de Terminal

Los terminales guardan un historial de comandos. Al presionar flecha arriba el usuario retrocede al comando anterior;
 flecha abajo avanza al más reciente. El historial es circular: después del más antiguo vuelve al más nuevo.

- **La Clase Comando (Nodo):** Debe contener `texto` (String), `exitoso` (boolean — si ejecutó sin errores)
 y `directorio` (String — el path desde donde se ejecutó).
- **El Problema:** El historial mantiene un puntero `cursor` al comando que se está consultando. Navegar con "arriba"
 mueve el cursor al anterior (`anterior`); "abajo" lo mueve al siguiente (`siguiente`). El usuario puede eliminar
  el comando actual (para borrar contraseñas escritas por error), y el cursor pasa automáticamente al siguiente.
- **Reto:** Implementa los métodos `arriba()`, `abajo()`, `mostrarCursor()` y `eliminarActual()`.
 Simula: agrega 5 comandos, navega 3 veces hacia arriba, elimina el comando actual, navega una vez hacia abajo y muestra el historial completo con el cursor marcado. */

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HistorialTerminal historial = new HistorialTerminal();
        int opcion;

        do {
            System.out.println("\n==============================================");
            System.out.println("   Historial de Terminal  Menú");
            System.out.println("==============================================");
            System.out.println("1. Agregar comando");
            System.out.println("2. Flecha arriba");
            System.out.println("3. Flecha abajo");
            System.out.println("4. Mostrar comando actual");
            System.out.println("5. Eliminar comando actual");
            System.out.println("6. Mostrar historial completo");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Texto del comando: ");
                    String texto = sc.nextLine();

                    System.out.print("¿Fue exitoso? (true/false): ");
                    boolean exitoso = sc.nextBoolean();
                    sc.nextLine();

                    System.out.print("Directorio: ");
                    String directorio = sc.nextLine();

                    historial.agregarComando(texto, exitoso, directorio);
                    System.out.println("Comando agregado.");
                    break;

                case 2:
                    historial.arriba();
                    break;

                case 3:
                    historial.abajo();
                    break;

                case 4:
                    historial.mostrarCursor();
                    break;

                case 5:
                    historial.eliminarActual();
                    break;

                case 6:
                    historial.mostrarHistorial();
                    break;

                case 0:
                    System.out.println("¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 0);

        sc.close();
    }
}
