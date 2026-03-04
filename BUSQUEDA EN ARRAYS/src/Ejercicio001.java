public class Ejercicio001 {

    /*1. El Cajero del Supermercado (Inventario)
Un cajero escanea un producto con el código de barras `770123`. El sistema tiene un arreglo desordenado con los códigos de los productos disponibles en la estantería actual.
- **El Problema:** Debes recorrer la lista para verificar si el producto existe y en qué posición de la estantería se encuentra.
- **Algoritmo a usar:** **Búsqueda Lineal**. Es el ideal porque los productos en la estantería no tienen un orden numérico específico.
 */

    
    public static void main(String[] args) {

        int[] productos = {123456, 456789, 770123, 987654, 345678};

        int codigoBuscado = 770123;
        boolean encontrado = false;

        for (int i = 0; i < productos.length; i++) {

            if (productos[i] == codigoBuscado) {
                System.out.println("Producto encontrado en la posición: " + i);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Producto no encontrado.");
        }
    }

    
    
}