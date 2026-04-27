public class HistorialTerminal {
     Comando cabeza;
    Comando cola;
    Comando cursor;

    public HistorialTerminal() {
        this.cabeza = null;
        this.cola = null;
        this.cursor = null;
    }

    public boolean estaVacio() {
        return cabeza == null;
    }

    public void agregarComando(String texto, boolean exitoso, String directorio) {
        Comando nuevo = new Comando(texto, exitoso, directorio);

        if (estaVacio()) {
            nuevo.siguiente = nuevo;
            nuevo.anterior = nuevo;
            cabeza = nuevo;
            cola = nuevo;
            cursor = nuevo;
        } else {
            cola.siguiente = nuevo;
            nuevo.anterior = cola;
            nuevo.siguiente = cabeza;
            cabeza.anterior = nuevo;
            cola = nuevo;

            cursor = nuevo;
        }
    }

    public void arriba() {
        if (estaVacio()) {
            System.out.println("El historial está vacío.");
            return;
        }

        cursor = cursor.anterior;
        System.out.println("Flecha arriba:");
        mostrarCursor();
    }

    public void abajo() {
        if (estaVacio()) {
            System.out.println("El historial está vacío.");
            return;
        }

        cursor = cursor.siguiente;
        System.out.println("Flecha abajo:");
        mostrarCursor();
    }

    public void mostrarCursor() {
        if (estaVacio()) {
            System.out.println("No hay comando seleccionado.");
            return;
        }

        System.out.println("Comando actual:");
        System.out.println("  Texto: " + cursor.texto);
        System.out.println("  Directorio: " + cursor.directorio);
        System.out.println("  Exitoso: " + (cursor.exitoso ? "Sí" : "No"));
    }

    public void eliminarActual() {
        if (estaVacio()) {
            System.out.println("No hay comandos para eliminar.");
            return;
        }

        System.out.println("Comando eliminado: " + cursor.texto);

        if (cabeza == cola) {
            cabeza = null;
            cola = null;
            cursor = null;
            return;
        }

        Comando eliminar = cursor;
        Comando siguiente = cursor.siguiente;

        eliminar.anterior.siguiente = eliminar.siguiente;
        eliminar.siguiente.anterior = eliminar.anterior;

        if (eliminar == cabeza) {
            cabeza = eliminar.siguiente;
        }

        if (eliminar == cola) {
            cola = eliminar.anterior;
        }

        cursor = siguiente;
    }

    public void mostrarHistorial() {
        if (estaVacio()) {
            System.out.println("El historial está vacío.");
            return;
        }

        Comando actual = cabeza;
        int numero = 1;

        do {
            String marca = actual == cursor ? "  <-- cursor" : "";

            System.out.println(numero + ". " + actual.texto
                    + "  [" + actual.directorio + "]"
                    + "  (" + (actual.exitoso ? "exitoso" : "fallido") + ")"
                    + marca);

            actual = actual.siguiente;
            numero++;
        } while (actual != cabeza);

        System.out.println("(historial circular: después del último vuelve al primero)");
    }
}
