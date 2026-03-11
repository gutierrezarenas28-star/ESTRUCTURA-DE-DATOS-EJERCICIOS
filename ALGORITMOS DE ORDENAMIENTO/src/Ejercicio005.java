import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio005 {
    /*El Inspector de Eficiencia (Duelo de Métodos) Algoritmos obligatorios:
     Selección vs Inserción Contexto: Un analista de sistemas quiere saber cuál algoritmo es más "pesado" en términos de operaciones paraun caso específico.
    Detalle del ejercicio: El usuario debe ingresar 6 números enteros desordenados. 
    El programa aplicará AMBOSmétodos al mismo conjunto de datos (puedes usar una copia del arreglo original).
    Lógica de Conteo: i. En Selección : 
    Cuenta cada vez que ocurre un swap (intercambio físico de posiciones).
    ii. En Inserción : Cuenta cada vez que un elemento se "mueve" hacia la izquierda dentro del bucle interno.
    Resultado esperado: El programa debe imprimir cuántos intercambios hizo Selección y cuántos movimientoshizo Inserción.
    El estudiante debe concluir cuál fue más eficiente para esos datos ingresados por el teclado. Instrucciones de entrega: Cada ejercicio debe estar en su propio archivo .java dentro de la carpeta src .
    Los nombres de las clases deben ser descriptivos (ej: Ejercicio1Podio.java ). Incluir un encabezado con el nombre del estudiante y la explicación del algoritmo usado. */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] arr = new int[6];

        System.out.println("Ingrese 6 numeros...");

        for (int i = 0; i < 6; i++) {
            System.out.print("Numero " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }

        int[] arrSelection = arr.clone();
        int[] arrInsertion = arr.clone();

        int swaps = selectionSort(arrSelection);
        int moves = insertionSort(arrInsertion);

        System.out.println("\nSelection Sort: " + Arrays.toString(arrSelection));
        System.out.println("Intercambios: " + swaps);

        System.out.println("\nInsertion Sort: " + Arrays.toString(arrInsertion));
        System.out.println("Movimientos: " + moves);

        sc.close();
    }

    public static int selectionSort(int[] arr) {

        int swaps = 0;

        for (int i = 0; i < arr.length - 1; i++) {

            int min = i;

            for (int j = i + 1; j < arr.length; j++) {

                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;

            swaps++;
        }

        return swaps;
    }

    public static int insertionSort(int[] arr) {

        int moves = 0;

        for (int i = 1; i < arr.length; i++) {

            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {

                arr[j + 1] = arr[j];
                j--;
                moves++;
            }

            arr[j + 1] = key;
        }

        return moves;
    }
    
}
