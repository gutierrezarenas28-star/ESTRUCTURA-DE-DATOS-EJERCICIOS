import java.util.Scanner;

public class Ejercicio001 {
    /* 1. El Podio de la Competencia
Algoritmo obligatorio:
Ordenamiento por Selección (Selection Sort)
Contexto:
Se ha realizado una carrera de 100 metros planos y el comité olímpico necesita determinar quiénesganaron las medallas.
Detalle del ejercicio:
El programa debe solicitar primero cuántos corredores participaron (ej. 5 a 10). Luego, debepedir el tiempo en segundos (con decimales) de cada corredor.
Lógica de Selección:
El algoritmo debe buscar el tiempo más bajo (el más rápido) en cada iteración y colocarlo alinicio.
Resultado esperado:
El programa debe imprimir el arreglo totalmente ordenado y, adicionalmente, mostrar unmensaje claro indicando quién obtuvo el Oro (1er lugar), Plata (2do lugar) y Bronce (3er lugar).*/

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de corredores: ");
        int n = sc.nextInt();

        double[] tiempos = new double[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Ingrese el tiempo del corredor " + (i + 1) + ": ");
            tiempos[i] = sc.nextDouble();
        }

        // Selection Sort
        for (int i = 0; i < n - 1; i++) {
            int min = i;

            for (int j = i + 1; j < n; j++) {
                if (tiempos[j] < tiempos[min]) {
                    min = j;
                }
            }

            double temp = tiempos[min];
            tiempos[min] = tiempos[i];
            tiempos[i] = temp;
        }

        System.out.println("\nTiempos ordenados:");
        for (double t : tiempos) {
            System.out.println(t);
        }

        if (n >= 3) {
            System.out.println("\n Oro: " + tiempos[0]);
            System.out.println(" Plata: " + tiempos[1]);
            System.out.println(" Bronce: " + tiempos[2]);
        }

        sc.close();
    }
}
