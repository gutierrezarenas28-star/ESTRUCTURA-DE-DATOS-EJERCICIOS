public class Ejercicio002 {

    /* ### Ejercicio 2 — Calculadora de una tienda
Una tienda de barrio vende productos al por menor. El cajero necesita calcular:

- Precio unitario de un producto (`double`)
- Cantidad comprada (`int`)
- Descuento aplicado en porcentaje (`double`)
- Total a pagar después del descuento

Declara las variables, realiza el cálculo y muestra el resultado por consola. */
    
public static void main(String[] args) {
        
        //calculadora de una tienda
        double precioProducto=1200;
        int cantidad=5;
        double descuento=0.20;

        double totalDes=(precioProducto*cantidad)*descuento;
        double toPagar=(precioProducto*cantidad)-totalDes;
        System.out.println("el valor a pagar es: "+toPagar);
    }
}
