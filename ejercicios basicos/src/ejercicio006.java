public class ejercicio006 {

    //variables por referencia
    /*### Ejercicio 6 — Turno en un banco
Un cajero de banco trabaja con el número del turno actual. Se crea una variable `turnoActual` y se asigna a `turnoEnPantalla`.

- Demuestra con código que cambiar `turnoEnPantalla` **no** afecta a `turnoActual` (comportamiento por valor).
- Explica en un comentario por qué ocurre esto. */
    public static void main(String[] args) {
        int turnoActual = 25;
        int turnoEnPantalla = turnoActual;

        // Cambiamos el valor de la copia
        turnoEnPantalla = 30;

        // Mostramos resultados
        System.out.println("Turno actual: " + turnoActual);
        System.out.println("Turno en pantalla: " + turnoEnPantalla);

        /*
         EXPLICACIÓN:
         En Java, los tipos primitivos (como int) se pasan por valor.
         Esto significa que turnoEnPantalla recibe una COPIA del valor
         de turnoActual, no la misma variable.

         Por eso, al modificar turnoEnPantalla, turnoActual no cambia.
        */

    }
}
