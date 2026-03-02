import java.util.Scanner;

public class ejercicio015 {
    /*Ejercicio 15 — Registro de temperaturas semanales (lineal)
Una estación meteorológica registra la temperatura máxima de cada día de la semana en un arreglo.

- Llena el arreglo con 7 valores.
- Calcula el promedio semanal.
- Indica qué días estuvieron por encima del promedio. */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double[] temperaturas = new double[7];
        double suma = 0;

        // 📥 Llenar arreglo
        for (int i = 0; i < 7; i++) {
            System.out.print("Ingrese la temperatura del día " + (i + 1) + ": ");
            temperaturas[i] = sc.nextDouble();
            suma += temperaturas[i];
        }

        // 📊 Calcular promedio
        double promedio = suma / 7;

        System.out.println("\nPromedio semanal: " + promedio);

        // 📈 Días por encima del promedio
        System.out.println("Días con temperatura por encima del promedio:");

        for (int i = 0; i < 7; i++) {
            if (temperaturas[i] > promedio) {
                System.out.println("Día " + (i + 1) + " con " + temperaturas[i] + "°");
            }
        }

        sc.close();
    }
}
