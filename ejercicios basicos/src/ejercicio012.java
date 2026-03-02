public class ejercicio012 {
    /*Ejercicio 12 — Historial de ventas (lineal)
Una tienda online guarda las ventas del día en un arreglo de `double`:

- Almacena 7 ventas de ejemplo.
- Calcula e imprime: la venta más alta, la venta más baja y el total del día. */
    // historial de ventas
    public static void main(String[] args) {

        // Arreglo con 7 ventas del día
        double[] ventas = {150.50, 230.00, 99.99, 310.75, 450.20, 120.00, 275.40};

        double ventaMayor = ventas[0];
        double ventaMenor = ventas[0];
        double total = 0;

        for (int i = 0; i < ventas.length; i++) {

            total += ventas[i];

            if (ventas[i] > ventaMayor) {
                ventaMayor = ventas[i];
            }

            if (ventas[i] < ventaMenor) {
                ventaMenor = ventas[i];
            }
        }

        System.out.println("Venta más alta: $" + ventaMayor);
        System.out.println("Venta más baja: $" + ventaMenor);
        System.out.println("Total del día: $" + total);
    }
}
