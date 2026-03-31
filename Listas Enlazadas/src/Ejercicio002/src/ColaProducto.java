public class ColaProducto {

    Producto cabeza;

    public ColaProducto() {
        this.cabeza = null;
    }

    public void ingresarProducto(Producto nuevoProducto) {

        if (nuevoProducto.diasVencer < 3) {
            nuevoProducto.siguiemte = cabeza;
            cabeza = nuevoProducto;
        } else {
            if (cabeza == null) {
                cabeza = nuevoProducto;
            } else {
                Producto actual = cabeza;
                while (actual.siguiemte != null) {
                    actual = actual.siguiemte;
                }
                actual.siguiemte = nuevoProducto;
            }
        }
    }

    public void mostarProductos() {
        if (cabeza == null) {
            System.out.println("No hay productos en el inventario...");
            return;
        }

        Producto actual = cabeza;
        while (actual != null) {
            System.out.println(actual);
            actual = actual.siguiemte;
        }
    }

    public void mostarProductosVencer() {
        if (cabeza == null) {
            System.out.println("No hay productos en el inventario...");
            return;
        }

        Producto actual = cabeza;
        boolean encontrado = false;

        System.out.println("Productos con menos de 5 dias para vencer:");
        while (actual != null) {
            if (actual.diasVencer < 5) {
                System.out.println(actual);
                encontrado = true;
            }
            actual = actual.siguiemte;
        }

        if (!encontrado) {
            System.out.println("No hay productos con menos de 5 dias de vencimiento...");
        }
    }
}
