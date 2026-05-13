public class PilaProduccion {
    private Pieza tope;
    private int tamanio;

    public PilaProduccion() {

        this.tope = null;
        this.tamanio = 0;
    }

    public boolean estaVacia() {
        return tope == null;
    }

    public int getTamanio() {
        return tamanio;
    }

    // PUSH
    public void push(Pieza nueva) {

        nueva.siguiente = tope;
        tope = nueva;

        tamanio++;
    }

    // POP
    public Pieza pop() {

        if (estaVacia()) {
            return null;
        }

        Pieza aux = tope;

        tope = tope.siguiente;

        tamanio--;

        aux.siguiente = null;

        return aux;
    }

    // PEEK
    public Pieza peek() {
        return tope;
    }

    // IMPRIMIR
    public void imprimir() {

        if (estaVacia()) {
            System.out.println("La pila está vacía.");
            return;
        }

        Pieza actual = tope;

        System.out.println("=== LÍNEA DE ENSAMBLAJE ===");

        while (actual != null) {

            if (actual == tope) {
                System.out.print("TOPE -> ");
            } else {
                System.out.print("         ");
            }

            System.out.println(actual);

            actual = actual.siguiente;
        }

        System.out.println("============================");
    }

    /**
     * Extrae piezas hasta encontrar la primera defectuosa.
     * Imprime las piezas buenas descartadas.
     */
    public void limpiarHastaDefecto() {

        if (estaVacia()) {
            System.out.println("La línea está vacía.");
            return;
        }

        System.out.println("\nIniciando limpieza de seguridad...");

        while (tope != null) {

            // Si encuentra pieza defectuosa
            if (tope.esDefectuosa) {

                System.out.println("¡¡PIEZA DEFECTUOSA ENCONTRADA!!");
                System.out.println("Pieza defectuosa: " + tope);

                // También se retira la pieza defectuosa
                pop();

                System.out.println("Producción detenida.");
                return;
            }

            // Retirar piezas buenas antes del defecto
            Pieza retirada = pop();

            System.out.println("Pieza buena descartada: "
                    + retirada.nombrePieza);
        }

        System.out.println("No se encontró ninguna pieza defectuosa.");
    }
}
