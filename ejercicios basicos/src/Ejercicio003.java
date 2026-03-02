import java.util.Scanner;

public class Ejercicio003 {
    /* ### Ejercicio 3 — Sensor de temperatura
Un sensor industrial registra temperaturas. El sistema recibe:

- Temperatura actual en Celsius (`double`)
- Nombre del sensor (`String`)
- Número de lectura (`int`)
- Si la temperatura supera el límite de 80°C, una variable `boolean` llamada `enAlarma` debe ser `true`.

Imprime el estado del sensor con todos sus datos. */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 📥 Datos de entrada
        System.out.print("Ingrese nombre del sensor: ");
        String nombreSensor = sc.nextLine();

        System.out.print("Ingrese temperatura actual (°C): ");
        double temperatura = sc.nextDouble();

        System.out.print("Ingrese número de lectura: ");
        int numeroLectura = sc.nextInt();

        // 🚨 Verificar alarma
        boolean enAlarma = temperatura > 80;

        // 📤 Mostrar resultados
        System.out.println("\n--- Estado del Sensor ---");
        System.out.println("Sensor: " + nombreSensor);
        System.out.println("Temperatura: " + temperatura + " °C");
        System.out.println("Lectura #: " + numeroLectura);
        System.out.println("¿En alarma?: " + enAlarma);

        sc.close();
    }
}
