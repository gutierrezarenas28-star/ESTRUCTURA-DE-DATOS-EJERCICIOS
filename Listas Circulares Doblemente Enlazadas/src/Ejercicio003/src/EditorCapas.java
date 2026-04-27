public class EditorCapas {
     Capa cabeza;
    Capa cola;
    Capa capaActiva;

    public EditorCapas() {
        cabeza = null;
        cola = null;
        capaActiva = null;
    }

    public boolean estaVacio() {
        return cabeza == null;
    }

    public void agregarCapa(String nombre, boolean visible, String tipo) {
        Capa nueva = new Capa(nombre, visible, tipo);

        if (estaVacio()) {
            nueva.siguiente = nueva;
            nueva.anterior = nueva;
            cabeza = nueva;
            cola = nueva;
        } else {
            cola.siguiente = nueva;
            nueva.anterior = cola;
            nueva.siguiente = cabeza;
            cabeza.anterior = nueva;
            cola = nueva;
        }

        capaActiva = nueva;
    }

    public void subirCapa() {
        if (estaVacio()) {
            System.out.println("No hay capas.");
            return;
        }

        capaActiva = capaActiva.siguiente;
        System.out.println("Subiste a la capa superior.");
        mostrarActiva();
    }

    public void bajarCapa() {
        if (estaVacio()) {
            System.out.println("No hay capas.");
            return;
        }

        capaActiva = capaActiva.anterior;
        System.out.println("Bajaste a la capa inferior.");
        mostrarActiva();
    }

    public void toggleVisibilidad() {
        if (estaVacio()) {
            System.out.println("No hay capas.");
            return;
        }

        capaActiva.visible = !capaActiva.visible;

        if (capaActiva.visible) {
            System.out.println("La capa ahora está visible.");
        } else {
            System.out.println("La capa ahora está oculta.");
        }

        mostrarActiva();
    }

    public void eliminarActiva() {
        if (estaVacio()) {
            System.out.println("No hay capas para eliminar.");
            return;
        }

        System.out.println("Eliminando capa: " + capaActiva.nombre);

        if (cabeza == cola) {
            cabeza = null;
            cola = null;
            capaActiva = null;
            return;
        }

        Capa siguiente = capaActiva.siguiente;

        capaActiva.anterior.siguiente = capaActiva.siguiente;
        capaActiva.siguiente.anterior = capaActiva.anterior;

        if (capaActiva == cabeza) {
            cabeza = capaActiva.siguiente;
        }

        if (capaActiva == cola) {
            cola = capaActiva.anterior;
        }

        capaActiva = siguiente;
    }

    public void mostrarActiva() {
        if (estaVacio()) {
            System.out.println("No hay capa activa.");
            return;
        }

        System.out.println("\n=== Capa activa ===");
        System.out.println("Nombre: " + capaActiva.nombre);
        System.out.println("Tipo: " + capaActiva.tipo);
        System.out.println("Visible: " + (capaActiva.visible ? "Sí" : "No"));
    }

    public void mostrarCapas() {
        if (estaVacio()) {
            System.out.println("No hay capas.");
            return;
        }

        System.out.println("\n=== Capas del diseño ===");

        Capa actual = cabeza;
        int numero = 1;

        do {
            String activa = actual == capaActiva ? "[✓] " : "[ ] ";
            String estado = actual.visible ? "visible" : "oculta";

            System.out.println(activa + numero + ". " + actual.nombre
                    + " | Tipo: " + actual.tipo
                    + " | Estado: " + estado);

            actual = actual.siguiente;
            numero++;
        } while (actual != cabeza);

        System.out.println("(estructura circular: después de la última vuelve a la primera)");
    }
}
