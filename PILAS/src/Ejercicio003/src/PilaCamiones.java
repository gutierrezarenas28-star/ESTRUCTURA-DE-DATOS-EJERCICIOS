public class PilaCamiones {
    private Camion tope;
    private int tamanio;

    public PilaCamiones() {

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
    public void push(Camion nuevo) {

        nuevo.siguiente = tope;

        tope = nuevo;

        tamanio++;
    }

    // POP
    public Camion pop() {

        if (estaVacia()) {
            return null;
        }

        Camion aux = tope;

        tope = tope.siguiente;

        tamanio--;

        aux.siguiente = null;

        return aux;
    }

    // PEEK
    public Camion peek() {
        return tope;
    }

    // IMPRIMIR
    public void imprimir() {

        if (estaVacia()) {

            System.out.println("No hay camiones en el callejón.");
            return;
        }

        Camion actual = tope;

        System.out.println("\n=== CAMIONES EN EL CALLEJÓN ===");

        while (actual != null) {

            if (actual == tope) {
                System.out.print("TOPE -> ");
            } else {
                System.out.print("         ");
            }

            System.out.println(actual);

            actual = actual.siguiente;
        }

        System.out.println("================================");
    }

    /**
     * Recorre la pila sin perder la información
     * y calcula la carga total.
     */
    public double calcularCargaTotal() {

        if (estaVacia()) {
            return 0;
        }

        double suma = 0;

        // Pila auxiliar
        PilaCamiones auxiliar = new PilaCamiones();

        // Vaciar temporalmente
        while (!estaVacia()) {

            Camion actual = pop();

            suma += actual.cargaToneladas;

            auxiliar.push(actual);
        }

        // Reconstruir pila original
        while (!auxiliar.estaVacia()) {

            push(auxiliar.pop());
        }

        return suma;
    }
}
