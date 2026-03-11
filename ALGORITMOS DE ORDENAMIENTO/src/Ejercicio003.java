import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio003 {
    /*El Salto de Shell (Optimización de Datos)
Algoritmo obligatorio:
Ordenamiento Shell (Shell Sort)
Contexto:
Una empresa de logística maneja paquetes con diferentes pesos y necesita ordenarlos de forma máseficiente que el método de burbuja o inserción simple.
Detalle del ejercicio:
Solicita al usuario el peso de
N
paquetes (se recomienda probar con al menos 10 paranotar el efecto).
Lógica de Shell:
Implementa el algoritmo usando el salto (gap) inicial de $N/2$. El estudiante debe explicar encomentarios por qué este método es generalmente más rápido que la inserción simple al trabajar con elementosque están muy lejos de su posición final.
Resultado esperado:
Mostrar el arreglo original y el arreglo final ordenado después de aplicar todas las fases dereducción de saltos. */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Cantidad de paquetes: ");
        int n = sc.nextInt();

        int[] pesos = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Peso del paquete " + (i + 1) + ": ");
            pesos[i] = sc.nextInt();
        }

        System.out.println("\nArreglo original:");
        System.out.println(Arrays.toString(pesos));

        // Shell Sort
        for (int gap = n / 2; gap > 0; gap /= 2) {

            for (int i = gap; i < n; i++) {

                int temp = pesos[i];
                int j = i;

                while (j >= gap && pesos[j - gap] > temp) {
                    pesos[j] = pesos[j - gap];
                    j -= gap;
                }

                pesos[j] = temp;
            }
        }

        System.out.println("\nArreglo ordenado:");
        System.out.println(Arrays.toString(pesos));

        sc.close();
    }
}
