public class ejercicio008 {

    //historial de mensajes
    /*### Ejercicio 8 — Historial de mensajes
Un chat guarda el último mensaje enviado. Se usan dos variables `String`:

- `ultimoMensaje = "Hola"`
- `copiaTexto = ultimoMensaje`
- Luego `copiaTexto` se cambia a `"¿Cómo estás?"`

Muestra ambas variables y explica en un comentario por qué `ultimoMensaje` **no cambió** (inmutabilidad de `String`). */
    public static void main(String[] args) {

        String ultimoMensaje = "Hola";
        String copiaTexto = ultimoMensaje;


        copiaTexto = "¿Cómo estás?";

        System.out.println("Último mensaje: " + ultimoMensaje);
        System.out.println("Copia del texto: " + copiaTexto);

        
         //EXPLICACIÓN:
         //En Java, String es inmutable, lo que significa que su contenido
         //no puede modificarse después de crearse.
    }
}
