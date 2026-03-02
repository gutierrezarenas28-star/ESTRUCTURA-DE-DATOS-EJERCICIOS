import java.util.LinkedList;
import java.util.Queue;

public class ejercicio014 {
    /*Ejercicio 14 — Árbol de empleados (no lineal)
Una empresa tiene la siguiente jerarquía:

```
         Gerente
        /       \
   Supervisor1  Supervisor2
    /      \
 Analista1 Analista2
```

- Modela la jerarquía con nodos que tengan el campo `cargo`.
- Imprime el árbol recorriéndolo nivel por nivel. */
    static class NodoEmpleado {
    String cargo;
    NodoEmpleado izquierdo;
    NodoEmpleado derecho;

    public NodoEmpleado(String cargo) {
        this.cargo = cargo;
        this.izquierdo = null;
        this.derecho = null;
    }
}
    public static void main(String[] args) {

        // 🌳 Crear nodos
        NodoEmpleado gerente = new NodoEmpleado("Gerente");
        NodoEmpleado supervisor1 = new NodoEmpleado("Supervisor1");
        NodoEmpleado supervisor2 = new NodoEmpleado("Supervisor2");
        NodoEmpleado analista1 = new NodoEmpleado("Analista1");
        NodoEmpleado analista2 = new NodoEmpleado("Analista2");

        // 🔗 Armar la jerarquía
        gerente.izquierdo = supervisor1;
        gerente.derecho = supervisor2;

        supervisor1.izquierdo = analista1;
        supervisor1.derecho = analista2;

        // 🚀 Recorrido por niveles
        System.out.println("Recorrido por niveles:");
        imprimirPorNiveles(gerente);
    }

    // 🔍 BFS (nivel por nivel)
    public static void imprimirPorNiveles(NodoEmpleado raiz) {
        if (raiz == null) return;

        Queue<NodoEmpleado> cola = new LinkedList<>();
        cola.add(raiz);

        while (!cola.isEmpty()) {
            NodoEmpleado actual = cola.poll();
            System.out.println(actual.cargo);

            if (actual.izquierdo != null) {
                cola.add(actual.izquierdo);
            }

            if (actual.derecho != null) {
                cola.add(actual.derecho);
            }
        }
    }
}
