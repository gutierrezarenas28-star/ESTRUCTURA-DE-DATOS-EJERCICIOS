public class ejercicio013 {

    // clasificacion de residuos no lineales
    /*Ejercicio 13 — Clasificación de residuos (no lineal)
Modela una jerarquía de tipos de residuos con una estructura de árbol usando nodos:

```
        Residuos
       /        \
  Orgánicos   Inorgánicos
   /    \       /      \
Comida Jardín Plástico Papel
```

- Crea la clase `NodoResiduo` con un campo `nombre` y referencias `izquierdo` y `derecho`.
- Construye el árbol mostrado.
- Imprime la raíz y todos sus descendientes indicando el nivel. */
    static class NodoResiduo {
        String nombre;
        NodoResiduo izquierdo;
        NodoResiduo derecho;

        public NodoResiduo(String nombre) {
            this.nombre = nombre;
            this.izquierdo = null;
            this.derecho = null;
        }
    }

    public static void main(String[] args) {

        // Crear nodos
        NodoResiduo raiz = new NodoResiduo("Residuos");

        NodoResiduo organicos = new NodoResiduo("Orgánicos");
        NodoResiduo inorganicos = new NodoResiduo("Inorgánicos");

        NodoResiduo comida = new NodoResiduo("Comida");
        NodoResiduo jardin = new NodoResiduo("Jardín");

        NodoResiduo plastico = new NodoResiduo("Plástico");
        NodoResiduo papel = new NodoResiduo("Papel");

        // Construir el árbol
        raiz.izquierdo = organicos;
        raiz.derecho = inorganicos;

        organicos.izquierdo = comida;
        organicos.derecho = jardin;

        inorganicos.izquierdo = plastico;
        inorganicos.derecho = papel;

        // Imprimir árbol
        imprimirArbol(raiz, 0);
    }

    // Método recursivo para imprimir con nivel
    public static void imprimirArbol(NodoResiduo nodo, int nivel) {
        if (nodo != null) {

            System.out.println("Nivel " + nivel + ": " + nodo.nombre);

            imprimirArbol(nodo.izquierdo, nivel + 1);
            imprimirArbol(nodo.derecho, nivel + 1);

            
        }
    }
}
