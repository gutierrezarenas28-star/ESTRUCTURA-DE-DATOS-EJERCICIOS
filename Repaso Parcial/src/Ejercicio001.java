import java.util.Scanner;

public class Ejercicio001 {
    // TecnoStore

    public static class Producto {
        int id;
        String nombre;
        double precio;
        int stock;

        public Producto(int id, String nombre, double precio, int stock) {
            this.id = id;
            this.nombre = nombre;
            this.precio = precio;
            this.stock = stock;
        }

        @Override
        public String toString() {
            return "ID: " + id + " | Nombre: " + nombre + " | Precio: " + precio + " | Stock: " + stock;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Producto[] productos = new Producto[5];

        System.out.println("*** REGISTRO DE PRODUCTOS ***");

        for (int i = 0; i < productos.length; i++) {
            System.out.println("Producto " + (i + 1) + ":");

            System.out.print("Ingrese el ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Ingrese el nombre: ");
            String nombre = sc.nextLine();

            System.out.print("Ingrese el precio: ");
            double precio = sc.nextDouble();

            System.out.print("Ingrese el stock: ");
            int stock = sc.nextInt();
            sc.nextLine();

            productos[i] = new Producto(id, nombre, precio, stock);
        }

        // ordenar con Shell Sort
        shellSort(productos);

        System.out.println("\n*** INVENTARIO ORDENADO POR ID ***");
        for (Producto producto : productos) {
            System.out.println(producto);
        }

        // Búsqueda Binaria
        System.out.println("\n--- BÚSQUEDA DE PRODUCTO ---");
        System.out.print("Ingrese el ID a buscar: ");
        int idBuscar = sc.nextInt();

        Producto encontrado = busquedaBinaria(productos, idBuscar);

        if (encontrado != null) {
            System.out.println(">> PRODUCTO ENCONTRADO: " + encontrado.nombre +
                    " - Precio: $" + encontrado.precio +
                    " - Stock: " + encontrado.stock);
        } else {
            System.out.println("Producto no encontrado.");
        }

        sc.close();
    }

    public static void shellSort(Producto[] x) {
        int n = x.length;

        for (int brecha = n / 2; brecha > 0; brecha /= 2) {
            for (int i = brecha; i < n; i++) {
                Producto temp = x[i];
                int j;

                for (j = i; j >= brecha && x[j - brecha].id > temp.id; j -= brecha) {
                    x[j] = x[j - brecha];
                }
                x[j] = temp;
            }
        }
    }

    public static Producto busquedaBinaria(Producto[] x, int objetivo) {
        int izquierda = 0;
        int derecha = x.length - 1;

        while (izquierda <= derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;

            if (x[medio].id == objetivo) {
                return x[medio];
            }

            if (x[medio].id < objetivo) {
                izquierda = medio + 1;
            } else {
                derecha = medio - 1;
            }
        }

        return null;
    }   
}
