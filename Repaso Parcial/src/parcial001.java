import java.util.Scanner;

public class parcial001 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] precios = new double[5];
        int suma= 0;

        System.out.println("*** REGISTRO DE PRECIOS ***");

        // Entrada de datos
        for (int i = 0; i < precios.length; i++) {
            System.out.print("Ingrese precio " + (i + 1) + ": ");
            precios[i] = sc.nextDouble();
            suma+=precios[i];
        }
        System.out.println();
        System.out.println("PRECIOS SIN ORDENAR");
        mostrarArreglo(precios);

        // Ordenar de MAYOR a MENOR
        selectionSortDesc(precios);

        System.out.println("\n PRECIOS ORDENADOS ");
        mostrarArreglo(precios);

        // Búsqueda lineal
        System.out.print("\nIngrese el precio a buscar: ");
        double objetivo = sc.nextDouble();

        int posicion = busquedaLineal(precios, objetivo);

        if (posicion != -1) {
            System.out.println("El precio se encuentra en la posición: " + posicion);
        } else {
            System.out.println("El precio no se encontró en la lista.");
        }

        double promedio = (double) suma / precios.length;
        System.out.println("\nEl promedio total de los precios es: " + promedio);



        sc.close();
    }

    // Selection Sort (Mayor a Menor)
    public static void selectionSortDesc(double[] x) {
        int n = x.length;

        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (x[j] > x[maxIndex]) { 
                    maxIndex = j;
                }
            }

            // Intercambio
            double temp = x[i];
            x[i] = x[maxIndex];
            x[maxIndex] = temp;
        }
    }

    
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

    // Búsqueda lineal
    public static int busquedaLineal(double[] x, double objetivo) {
        for (int i = 0; i < x.length; i++) {
            if (x[i] == objetivo) {
                return i;
            }
        }
        return -1;
    }
}
