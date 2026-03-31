import java.util.Scanner;

public class Ejercicio002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] puntajes = new int[6];
        int suma = 0;

        System.out.println("--- INGRESO DE PUNTAJES ---");

        for (int i = 0; i < puntajes.length; i++) {
            System.out.print("Puntaje del Intento " + (i + 1) + ": ");
            puntajes[i] = sc.nextInt();
            suma += puntajes[i];
        }

        // Ordenar de mayor a menor con Insertion Sort
        insertionSortDesc(puntajes);

        System.out.println("\n--- TABLA DE RESULTADOS (De mayor a menor) ---");
        for (int i = 0; i < puntajes.length; i++) {
            System.out.println((i + 1) + "° Lugar: " + puntajes[i]);
        }

        double promedio = (double) suma / puntajes.length;
        System.out.println("\nEl promedio total de los puntajes fue: " + promedio);

        // Búsqueda lineal
        System.out.println("\n--- BÚSQUEDA LINEAL ---");
        System.out.print("Ingrese puntaje a buscar: ");
        int buscar = sc.nextInt();

        int posicion = busquedaLineal(puntajes, buscar);

        if (posicion != -1) {
            System.out.println(">> El puntaje " + buscar + " se encuentra en el " + (posicion + 1) + "° lugar de la tabla.");
        } else {
            System.out.println("Puntaje no encontrado.");
        }

        sc.close();
    }

    public static void insertionSortDesc(int[] x) {
        for (int i = 1; i < x.length; i++) {
            int clave = x[i];
            int j = i - 1;

            while (j >= 0 && x[j] < clave) {
                x[j + 1] = x[j];
                j--;
            }

            x[j + 1] = clave;
        }
    }

    public static int busquedaLineal(int[] x, int objetivo) {
        for (int i = 0; i < x.length; i++) {
            if (x[i] == objetivo) {
                return i;
            }
        }
        return -1;
    }
}
