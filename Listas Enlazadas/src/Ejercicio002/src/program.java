/*2. Inventario de Alimentos (Control de Caducidad)
Un supermercado necesita gestionar su estante de lácteos. Los productos que vencen más pronto deben colocarse al principio para ser vendidos primero.
- **La Clase Producto (Nodo):** Debe contener `nombre` (String), `cantidad` (int) y `diasParaVencer` (int).
- **El Problema:** Si llega un producto que vence en menos de 3 días, debe insertarse al **inicio** de la lista (prioridad de venta). Si vence en más tiempo, se pone al final.
- **Reto:** Crea un método que imprima solo los productos que tienen menos de 5 días para vencer. */

import java.util.Scanner;

public class program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion;

        ColaProducto inventario = new ColaProducto();

        do {
            System.out.println("\n==============================================");
            System.out.println("   PRODUCTOS - Menu Principal");
            System.out.println("==============================================");
            System.out.println("1. Nuevo Producto");
            System.out.println("2. Mostrar todos los productos");
            System.out.println("3. Mostrar productos con <5 dias para vencer");
            System.out.println("0. Salir");
            System.out.println("==============================================");
            System.out.print("Elige una opcion: ");

            opcion = sc.nextInt();
            sc.nextLine();

            System.out.println();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del producto: ");
                    String nombre = sc.nextLine();

                    System.out.print("Cantidad: ");
                    int contenido = sc.nextInt();

                    System.out.print("Dias para vencer: ");
                    int diasVencer = sc.nextInt();
                    sc.nextLine();

                    Producto nuevoProducto = new Producto(nombre, contenido, diasVencer);
                    inventario.ingresarProducto(nuevoProducto);
                    System.out.println("Producto agregado con exito...");
                    break;

                case 2:
                    System.out.println("Lista de Productos:");
                    inventario.mostarProductos();
                    break;

                case 3:
                    
                    inventario.mostarProductosVencer();
                    break;

                case 0:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opcion no valida. Intenta de nuevo.");
            }

        } while (opcion != 0);

        sc.close();
    }
}
