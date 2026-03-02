public class ejercicio011 {
    //lista de pasajeros
    /*Ejercicio 11 — Lista de pasajeros (lineal)
Una aerolínea registra los nombres de los pasajeros de un vuelo en un arreglo de `String` con capacidad para 6 personas.

- Llena el arreglo con nombres.
- Recórrelo con un `for` e imprime el número de asiento y el nombre.
- Muestra cuántos asientos están ocupados. */
    public static void main(String[] args) {

        // Arreglo con capacidad para 6 pasajeros
        String[] pasajeros = new String[6];

        pasajeros[0] = "Ana";
        pasajeros[1] = "Luis";
        pasajeros[2] = "Carlos";
        pasajeros[3] = "Marta";
        pasajeros[4] = "Sofia";
        pasajeros[5] = "Diego";

        int ocupados = 0;

        for (int i = 0; i < pasajeros.length; i++) {
            System.out.println("Asiento " + (i + 1) + ": " + pasajeros[i]);
            ocupados++;
        }

        // Mostrar total ocupados
        System.out.println("Asientos ocupados: " + ocupados);
    }
}
