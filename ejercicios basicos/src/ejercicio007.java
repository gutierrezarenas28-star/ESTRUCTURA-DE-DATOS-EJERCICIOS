public class ejercicio007 {
    //inventario compartido
    /*### Ejercicio 7 — Inventario compartido
Un almacén tiene un arreglo con el stock de 5 productos. El sistema de ventas y el sistema de reportes **apuntan al mismo arreglo**.

- Crea el arreglo `stockAlmacen` con valores iniciales.
- Asigna `stockReportes = stockAlmacen`.
- Simula una venta reduciendo el stock de un producto desde `stockReportes`.
- Muestra que `stockAlmacen` **también cambió** y explica en comentarios por qué. */
    public static void main(String[] args) {

       
        int[] stockAlmacen = {50, 30, 20, 15, 10};
       
        int[] stockReportes = stockAlmacen;

        stockReportes[1] -= 5; // Se venden 5 unidades

        // Mostramos el stock desde ambos sistemas
        System.out.println("Stock desde Almacén:");
        for (int i = 0; i < stockAlmacen.length; i++) {
            System.out.println("Producto " + i + ": " + stockAlmacen[i]);
        }

        System.out.println("\nStock desde Reportes:");
        for (int i = 0; i < stockReportes.length; i++) {
            System.out.println("Producto " + i + ": " + stockReportes[i]);
        }

        /*
         EXPLICACIÓN:
         En Java, los arreglos son objetos.
         Cuando hacemos:
             int[] stockReportes = stockAlmacen;
         NO se copia el arreglo, sino que ambas variables
         apuntan al mismo espacio en memoria.

         Por eso, al modificar stockReportes,
         también cambia stockAlmacen.
        */
    }
}
