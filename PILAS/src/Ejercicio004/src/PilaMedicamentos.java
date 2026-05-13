public class PilaMedicamentos {
    private Medicamento tope;
    private int tamanio;

    public PilaMedicamentos() {
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
    public void push(Medicamento nuevo) {
        nuevo.siguiente = tope;
        tope = nuevo;
        tamanio++;
    }

    // POP
    public Medicamento pop() {
        if (estaVacia()) {
            return null;
        }

        Medicamento aux = tope;
        tope = tope.siguiente;
        tamanio--;

        aux.siguiente = null;

        return aux;
    }

    // PEEK
    public Medicamento peek() {
        return tope;
    }

    // IMPRIMIR
    public void imprimir() {
        if (estaVacia()) {
            System.out.println("El dispensador está vacío.");
            return;
        }

        Medicamento actual = tope;

        System.out.println("\n=== DISPENSADOR DE MEDICAMENTOS ===");

        while (actual != null) {
            if (actual == tope) {
                System.out.print("TOPE -> ");
            } else {
                System.out.print("         ");
            }

            System.out.println(actual);

            actual = actual.siguiente;
        }

        System.out.println("===================================");
    }

    /**
     * Revisa el tope.
     * Si el medicamento tiene menos de 10 días para vencer,
     * lo retira automáticamente y revisa el siguiente.
     *
     * Cuando encuentra un medicamento seguro, también lo despacha.
     */
    public Medicamento validarDespacho() {

        while (!estaVacia()) {

            if (tope.diasParaVencer < 10) {
                Medicamento vencido = pop();

                System.out.println("Medicamento retirado por seguridad: "
                        + vencido);
            } else {
                return pop();
            }
        }

        return null;
    }

    /**
     * Variante para solo validar el tope sin despachar
     * el medicamento seguro.
     */
    public Medicamento validarDespachoSinRetirarSeguro() {

        while (!estaVacia()) {

            if (tope.diasParaVencer < 10) {
                Medicamento vencido = pop();

                System.out.println("Medicamento retirado por seguridad: "
                        + vencido);
            } else {
                return tope;
            }
        }

        return null;
    }
}
