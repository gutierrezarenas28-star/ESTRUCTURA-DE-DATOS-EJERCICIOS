import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio002 {
    /*Organización de Biblioteca Dinámica
Algoritmo obligatorio:
Ordenamiento por Inserción (Insertion Sort)
Contexto:
Un bibliotecario recibe una caja de libros y los va colocando uno a uno en el estante en su posicióncorrecta.
Detalle del ejercicio:
El usuario debe ingresar la cantidad de libros y luego el código ISBN (número entero) decada uno.
Lógica de Inserción:
A medida que el usuario ingresa un número, o una vez llenado el arreglo, el algoritmo debesimular el proceso de "insertar" el elemento comparándolo con los que ya están a su izquierda.
Visualización Paso a Paso:
En cada ciclo del ordenamiento, el programa debe imprimir cómo va quedando elarreglo (ej:
[10, 25, 5, 30] -> [5, 10, 25, 30]
). Esto permite al estudiante ver cómo los elementos sedesplazan para abrir espacio al nuevo valor. */

    

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Cantidad de libros: ");
        int n = sc.nextInt();

        int[] isbn = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Ingrese ISBN del libro " + (i + 1) + ": ");
            isbn[i] = sc.nextInt();
        }

        // Insertion Sort
        for (int i = 1; i < n; i++) {

            int key = isbn[i];
            int j = i - 1;

            while (j >= 0 && isbn[j] > key) {
                isbn[j + 1] = isbn[j];
                j--;
            }

            isbn[j + 1] = key;

            System.out.println("Paso " + i + ": " + Arrays.toString(isbn));
        }

        System.out.println("\nArreglo ordenado:");
        System.out.println(Arrays.toString(isbn));

        sc.close();
    }
}
