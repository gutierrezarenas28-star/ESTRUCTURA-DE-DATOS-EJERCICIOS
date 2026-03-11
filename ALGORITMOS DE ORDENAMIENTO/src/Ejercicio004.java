import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio004 {
    /*Registro Alfabético de Estudiantes
Algoritmo obligatorio:
Ordenamiento por Inserción (Insertion Sort)
Contexto:
El profesor necesita pasar asistencia y requiere que la lista de nombres ingresada en el sistema seordene alfabéticamente de la A a la Z.
Detalle del ejercicio:
El programa debe preguntar cuántos alumnos hay en clase y solicitar sus nombres (cadenasde texto).
Lógica de Texto:
Se debe usar el método de
Inserción
adaptado para
String
.
Requisito técnico:
El estudiante debe investigar y aplicar el método
nombre1.compareToIgnoreCase(nombre2)
. Esvital explicar que si el resultado es mayor a 0, el primer nombre es alfabéticamente "mayor" que el segundo.
Resultado esperado:
La lista de asistencia impresa en orden alfabético perfecto. */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Cantidad de estudiantes: ");
        int n = sc.nextInt();
        sc.nextLine();

        String[] nombres = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Nombre del estudiante " + (i + 1) + ": ");
            nombres[i] = sc.nextLine();
        }

        // Insertion Sort para Strings
        for (int i = 1; i < n; i++) {

            String key = nombres[i];
            int j = i - 1;

            while (j >= 0 && nombres[j].compareToIgnoreCase(key) > 0) {
                nombres[j + 1] = nombres[j];
                j--;
            }

            nombres[j + 1] = key;
        }

        System.out.println("\nLista ordenada:");
        System.out.println(Arrays.toString(nombres));

        sc.close();
    }
}
