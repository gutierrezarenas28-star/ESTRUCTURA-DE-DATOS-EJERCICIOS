/* ### Ejercicio 1 — Ficha de un estudiante
Un sistema universitario necesita registrar la información básica de un estudiante: nombre completo, código (número entero), semestre actual, promedio acumulado y si está matriculado o no.

- Declara las variables con los tipos de datos apropiados.
- Asigna valores de ejemplo.
- Imprime un reporte por consola con el siguiente formato: */

public class Ejercicio001 {

    
    public static void main(String[] args) {
        
        //Ficha del estudiante
        String nombre= "Juan Jose";
        int codigo= 1234;
        int semestre=6;
        double promedio=4.0;
        boolean matriculado= true;

        System.out.println("===Ficha del Estudiante===");
        System.out.println("Nombre: "+ nombre+  "\nCodigo: " + codigo+ "\nSemestre: "+ semestre
            + "\nPromedio: "+ promedio+ "\nMatriculado: "+ matriculado
        );
    }

}
