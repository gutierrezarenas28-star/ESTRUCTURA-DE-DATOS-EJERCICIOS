import java.util.Scanner;

public class Ejercicio003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] notas = new double[5];

        System.out.println("--- REGISTRO DE NOTAS ---");

        // Entrada de datos
        for (int i = 0; i < notas.length; i++) {
            System.out.print("Ingrese nota del Estudiante " + (i + 1) + ": ");
            notas[i] = sc.nextDouble();
        }

        // Encontrar mayor y menor
        double mayor = notas[0];
        double menor = notas[0];

        for (int i = 1; i < notas.length; i++) {
            if (notas[i] > mayor) {
                mayor = notas[i];
            }
            if (notas[i] < menor) {
                menor = notas[i];
            }
        }

        System.out.println("\nLa nota MÁS ALTA del grupo es: " + mayor);
        System.out.println("La nota más BAJA del grupo es: " + menor);

        // Ordenar con Selection Sort (menor a mayor)
        selectionSort(notas);

        System.out.println("\n--- LISTA DE NOTAS ORDENADA (Menor a Mayor) ---");
        mostrarArreglo(notas);

        sc.close();
    }

    // Selection Sort
    public static void selectionSort(double[] x) {
        int n = x.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (x[j] < x[minIndex]) {
                    minIndex = j;
                }
            }

            // Intercambio
            double temp = x[i];
            x[i] = x[minIndex];
            x[minIndex] = temp;
        }
    }

    // Mostrar arreglo
    public static void mostrarArreglo(double[] x) {
        System.out.print("[");
        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i]);
            if (i < x.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
