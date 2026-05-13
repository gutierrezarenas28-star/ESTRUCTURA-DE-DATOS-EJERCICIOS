public class PilaEstaciones {
    private Estacion tope;
    private int tamanio;

    public PilaEstaciones() {
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
    public void push(Estacion nueva) {
        nueva.siguiente = tope;
        tope = nueva;
        tamanio++;
    }

    // POP
    public Estacion pop() {
        if (estaVacia()) {
            return null;
        }

        Estacion aux = tope;
        tope = tope.siguiente;
        tamanio--;

        aux.siguiente = null;

        return aux;
    }

    // PEEK
    public Estacion peek() {
        return tope;
    }

    // IMPRIMIR
    public void imprimir() {
        if (estaVacia()) {
            System.out.println("No hay estaciones registradas.");
            return;
        }

        Estacion actual = tope;

        System.out.println("\n=== RUTA DE ESTACIONES ===");

        while (actual != null) {
            if (actual == tope) {
                System.out.print("TOPE -> ");
            } else {
                System.out.print("         ");
            }

            System.out.println(actual);

            actual = actual.siguiente;
        }

        System.out.println("==========================");
    }

    /**
     * Desapila todas las estaciones para volver a la superficie.
     * Si el oxígeno es menor al 18%, muestra alerta.
     */
    public void retrocederASuperficie() {

        if (estaVacia()) {
            System.out.println("No hay ruta registrada para retroceder.");
            return;
        }

        System.out.println("\nIniciando regreso a la superficie...");

        while (!estaVacia()) {

            Estacion actual = pop();

            System.out.println("Pasando por estación: "
                    + actual.nombrePunto);

            if (actual.nivelOxigeno < 18) {
                System.out.println("ALERTA: Uso de Tanque de Emergencia Requerido");
            }
        }

        System.out.println("El equipo ha llegado a la superficie.");
    }
}
