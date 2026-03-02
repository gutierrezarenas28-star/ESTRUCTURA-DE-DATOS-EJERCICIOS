public class Ejercicio005 {
    /* ### Ejercicio 5 — Conversor de unidades
Una aplicación de cocina necesita convertir unidades:

- Declara una variable `tazas` (`double`) con la cantidad de tazas de un ingrediente.
- Convierte a mililitros (1 taza = 236.588 ml) y guarda el resultado en otra variable.
- Convierte también a litros.
- Muestra las tres medidas por consola. */

    public static void main(String[] args) {
        
        // conversor de unidades
        double tazas = 2.5;

        // Conversión a mililitros
        double mililitros = tazas * 236.588;

        // Conversión a litros
        double litros = mililitros / 1000;

        // Mostrar resultados
        System.out.println("Tazas: " + tazas);
        System.out.println("Mililitros: " + mililitros);
        System.out.println("Litros: " + litros);
    }
}
