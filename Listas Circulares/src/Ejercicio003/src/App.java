/*3. Planificador de CPU (Algoritmo Round Robin)
Los sistemas operativos usan el algoritmo Round Robin para repartir el tiempo del procesador entre varios procesos de forma justa: cada 
proceso recibe un pequeño intervalo de tiempo llamado **quantum**. Si no termina, espera su siguiente turno.
- **La Clase Proceso (Nodo):** Debe contener `nombre` (String), `pid` (int), `tiempoRestante` (int) y `prioridad` (int - del 1 al 3).
- **El Problema:** El planificador debe recorrer la lista circular en bucle. En cada turno, descuenta el `quantum` del `tiempoRestante` del proceso actual. 
Cuando `tiempoRestante <= 0`, el proceso **termina y se elimina** de la lista.
- **Reto:** Implementa el método `ejecutar(int quantum)` que simule el planificador. Imprime en cada turno cuál proceso se está ejecutando, 
cuánto tiempo le queda y si terminó. El ciclo debe terminar cuando la lista quede vacía. Al final, imprime el **orden en que terminaron** los procesos. */

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int opcion;
        PlanificadorCPU planificador = new PlanificadorCPU();

        do {
            System.out.println("\n==============================================");
            System.out.println("     Planificador CPU Round Robin");
            System.out.println("==============================================");
            System.out.println("  [1] Insertar proceso");
            System.out.println("  [2] Mostrar procesos");
            System.out.println("  [3] Ejecutar Round Robin");
            System.out.println();
            System.out.println("  [0] Salir");
            System.out.println("==============================================");
            System.out.print("Elige una opción: ");

            opcion = sc.nextInt();
            sc.nextLine();
            System.out.println();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del proceso: ");
                    String nombre = sc.nextLine();

                    System.out.print("Ingrese el PID: ");
                    int pid = sc.nextInt();

                    System.out.print("Ingrese el tiempo restante: ");
                    int tiempoRestante = sc.nextInt();

                    System.out.print("Ingrese la prioridad (1 a 3): ");
                    int prioridad = sc.nextInt();

                    planificador.insertarAlFinal(nombre, pid, tiempoRestante, prioridad);
                    System.out.println("Proceso insertado correctamente.");
                    break;

                case 2:
                    planificador.mostrar();
                    break;

                case 3:
                    if (planificador.estaVacia()) {
                        System.out.println("No hay procesos en la cola.");
                    } else {
                        System.out.print("Ingrese el quantum: ");
                        int quantum = sc.nextInt();
                        planificador.ejecutar(quantum);
                    }
                    break;

                case 0:
                    System.out.println("¡Saliendo del módulo de Listas Circulares!");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0);

        sc.close();
    }
    
}
